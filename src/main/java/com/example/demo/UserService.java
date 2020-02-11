package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*@FeignClient(name="user-service", fallback = UserServiceFallback.class)*/
public interface UserService {

    @RequestMapping(value = "/user/timeout")
    public String timeout();

    @RequestMapping(value = "/user/exception")
    public String exception();
}