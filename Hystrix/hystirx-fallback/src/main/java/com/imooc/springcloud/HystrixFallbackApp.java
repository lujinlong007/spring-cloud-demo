package com.imooc.springcloud;

import feign.Feign;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class HystrixFallbackApp  {

    public static void main(String[] args) throws NoSuchMethodException {

        //System.out.println(Feign.configKey(MyService.class,MyService.class.getMethod("retry",int.class)));
        new SpringApplicationBuilder( HystrixFallbackApp.class).web(WebApplicationType.SERVLET).run(args);

    }
}
