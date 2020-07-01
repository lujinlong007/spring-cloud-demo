package coom.imooc.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.turbine.EnableTurbine;



@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@EnableTurbine
@EnableAutoConfiguration
public class TurbineApp {

    public static void main(String[] args) throws NoSuchMethodException {

        //System.out.println(Feign.configKey(MyService.class,MyService.class.getMethod("retry",int.class)));
        new SpringApplicationBuilder( TurbineApp.class).web(WebApplicationType.SERVLET).run(args);

    }
}
