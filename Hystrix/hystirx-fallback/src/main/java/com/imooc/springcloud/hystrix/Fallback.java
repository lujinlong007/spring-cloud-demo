package com.imooc.springcloud.hystrix;

import com.imooc.springcloud.Friend;
import com.imooc.springcloud.MyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Fallback implements MyService {

    @Override
    @HystrixCommand(fallbackMethod = "fallback2")
    public String error() {

        log.info("fallback: i'am not a black sheep any more ");
        throw  new  RuntimeException("first fallback");
    }
    @HystrixCommand(fallbackMethod = "fallback3")
    public String fallback2(){
        log.info("fallback again");
        throw  new  RuntimeException("allback again");
    }
    public String fallback3(){
        log.info("fallback again and again");
        return  "success";
    }
    @Override
    public String sayHi() {
        return null;
    }

    @Override
    public Friend sayHiPost(Friend friend) {
        return null;
    }

    @Override
    public String retry(int timeout) {
        return "you are late!!!!";
    }


}
