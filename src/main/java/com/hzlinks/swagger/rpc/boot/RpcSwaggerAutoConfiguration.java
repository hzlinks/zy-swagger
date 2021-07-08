package com.hzlinks.swagger.rpc.boot;

import com.hzlinks.swagger.rpc.config.DubboPropertyConfig;
import com.hzlinks.swagger.rpc.config.DubboServiceScanner;
import com.hzlinks.swagger.rpc.config.SwaggerDocCache;
import com.hzlinks.swagger.rpc.web.DubboHttpController;
import com.hzlinks.swagger.rpc.web.SwaggerDubboController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: rpc-swagger
 * @description: SpringAutoConfiguration
 * @author: feiyang
 * @create: 2021/03/02 15:09
 */
@Configuration
@ConditionalOnClass({DubboPropertyConfig.class, DubboServiceScanner.class, SwaggerDocCache.class
        , DubboHttpController.class, SwaggerDubboController.class
})
@EnableConfigurationProperties(RpcSwaggerProperties.class)
@ComponentScan({"com.hzlinks.swagger"})
public class RpcSwaggerAutoConfiguration {

}