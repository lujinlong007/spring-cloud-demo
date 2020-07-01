package com.imooc.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableHystrixDashboard
@SpringCloudApplication
public class HystrixDashboardApp {

    public static void main(String[] args) throws NoSuchMethodException {

        //System.out.println(Feign.configKey(MyService.class,MyService.class.getMethod("retry",int.class)));
        new SpringApplicationBuilder( HystrixDashboardApp.class).web(WebApplicationType.SERVLET).run(args);

    }
}
