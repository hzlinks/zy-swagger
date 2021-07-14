package com.hzlinks.swagger.rpc.boot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: bw-swagger
 * @description: 配置文件
 * @author: feiyang
 * @create: 2021/03/02 17:04
 */
@Data
@ConfigurationProperties(prefix = "swaggerpc.config")
public class RpcSwaggerProperties {

    private String version;

    private String groupId;

    private String artifactId;

    private Boolean enable;

}