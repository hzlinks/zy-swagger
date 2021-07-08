package com.hzlinks.swagger.rpc.web;

import com.hzlinks.swagger.rpc.config.DubboPropertyConfig;
import com.hzlinks.swagger.rpc.config.DubboServiceScanner;
import com.hzlinks.swagger.rpc.config.SwaggerDocCache;
import com.hzlinks.swagger.rpc.reader.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.config.SwaggerConfig;
import io.swagger.models.Swagger;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

/**
 * @author harold
 */
@Controller
@RequestMapping("/v2")
@Api(hidden = true)
public class SwaggerDubboController {

    public static final String DEFAULT_URL = "/rpc-docs";
    private static final String HAL_MEDIA_TYPE = "application/hal+json";

    @Autowired
    private DubboServiceScanner dubboServiceScanner;
    @Autowired
    private DubboPropertyConfig dubboPropertyConfig;
    @Autowired
    private SwaggerDocCache swaggerDocCache;

    @Value("${swagger.dubbo.http:h}")
    private String httpContext;
    @Value("${swagger.enabled:true}")
    private final boolean enable = true;

    @RequestMapping(value = DEFAULT_URL,
            method = RequestMethod.GET,
            produces = {"application/json; charset=utf-8", HAL_MEDIA_TYPE})
    @ResponseBody
    public ResponseEntity<Json> getApiList() throws JsonProcessingException {

        if (!enable) {
            return new ResponseEntity<Json>(HttpStatus.NOT_FOUND);
        }

        Swagger swagger = swaggerDocCache.getSwagger();
        if (null != swagger) {
            return new ResponseEntity<Json>(new Json(io.swagger.util.Json.mapper().writeValueAsString(swagger)),
                    HttpStatus.OK);
        } else {
            swagger = new Swagger();
        }

        final SwaggerConfig configurator = dubboPropertyConfig;
        if (configurator != null) {
            configurator.configure(swagger);
        }

        Map<Class<?>, Object> interfaceMapRef = dubboServiceScanner.interfaceMapRef();
        if (null != interfaceMapRef) {
            Reader.read(swagger, interfaceMapRef, httpContext);
        }
        swaggerDocCache.setSwagger(swagger);
        return new ResponseEntity<Json>(new Json(io.swagger.util.Json.mapper().writeValueAsString(swagger)),
                HttpStatus.OK);
    }

}
