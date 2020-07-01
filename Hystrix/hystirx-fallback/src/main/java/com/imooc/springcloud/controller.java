package com.imooc.springcloud;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
  private MyService myService;
   @Autowired
    private RequestCacheService requestCacheService;
    @GetMapping("/fallback")
    public String fallback() {
        return myService.error();
    }

    @GetMapping("/timeout")
    public  String timeout(int timeout){
        return myService.retry(timeout);
    }
    @GetMapping("/cache")
    public  Friend cache(String name){
        @Cleanup HystrixRequestContext context = HystrixRequestContext.initializeContext();
        Friend friend = requestCacheService.requestCache(name);
        name+="!";
        friend = requestCacheService.requestCache(name);
        return friend;

    }
    @GetMapping("/timeout2")
    @HystrixCommand(fallbackMethod = "timeoutFallback",commandProperties ={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    } )
    public  String timeout2(int timeout){
        return myService.retry(timeout);
    }

    public  String timeoutFallback(int timeout){
        return "success";
    }
}
