package com.imooc.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FeignClientApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder( FeignClientApp.class).web(WebApplicationType.SERVLET).run(args);

    }
}
