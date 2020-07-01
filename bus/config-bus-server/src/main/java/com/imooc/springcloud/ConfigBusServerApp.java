package com.imooc.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigBusServerApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigBusServerApp.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

    //http://localhost:60000/{label}/{application}-{profile}.json(yml/properties)
    //http://localhost:60000//{application}/profile}/{label}
}