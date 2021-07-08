# rpc-swagger

### 说明

rpc swagger-ui spring boot starter项目


### 使用说明
    
   1. pom.xml中加入依赖

    <dependency>
      <groupId>com.hzlinks.swagger</groupId>
      <artifactId>swaggerpc-springboot-starter</artifactId>
      <version>${swaggerpc.version}</version>
    </dependency>
   
   2. 在application.yml 或者 application.properties中填写属性


        swaggerpc
        
            jar
       
                version: 1.0.1-SNAPSHOT
       
                groupId: com.hzlinks.xxxx
    
                artifactId: xxxx-client


   3. 打开 http://{host}/context/rpc/index.html    即可

### 其他配置
   swagger.enabled 配置 
