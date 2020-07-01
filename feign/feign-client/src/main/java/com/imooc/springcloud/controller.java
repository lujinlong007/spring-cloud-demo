package com.imooc.springcloud;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class controller implements IService {

    @Value("${server.port}")
    private String port;
    @Override
    public String sayHi() {
        return "This is"+port;
    }

    @Override
    public Friend sayHiPost(Friend friend) {
        log.info("you are "+friend.getName());
        friend.setPort(friend.getPort());
        return friend;
    }

    @Override
    public String retry(@RequestParam(name = "timeout") int timeout) {

        while(--timeout>=0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("retry"+port);
        return port;
    }

    @Override
    public String error() {
        throw  new RuntimeException("black sheep");
    }
}
