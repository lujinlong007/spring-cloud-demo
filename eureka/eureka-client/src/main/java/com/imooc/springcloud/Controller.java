package com.imooc.springcloud;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

    @Value("${server.port}")
    private String port;

    @GetMapping("/sayHi")
    public  String sayHi(){
        return "This is"+port;
    }
    @PostMapping("/sayHi")
    public  Friend sayHi(@RequestBody Friend friend){
        log.info("you are "+friend.getName());
        friend.setPort(friend.getPort());
        return friend;

    }

}
