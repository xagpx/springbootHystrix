package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
@RestController
public class HelloService {
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiFail")
    public String hi(String name){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        throw new RuntimeException("test");
        return "hi "+name;
    }


    public String hiFail(String name){
        return "hiFail "+name;
    }
}