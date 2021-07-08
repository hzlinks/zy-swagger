package com.hzlinks.swagger.rpc.config;

import io.swagger.models.Swagger;
import org.springframework.stereotype.Component;

@Component
public class SwaggerDocCache {

    private Swagger swagger;

    public Swagger getSwagger() {
        return swagger;
    }

    public void setSwagger(Swagger swagger) {
        this.swagger = swagger;
    }

}
