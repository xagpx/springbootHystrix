package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/feign/timeout")
    public String feignTimeout() {
        return userService.timeout();
    }

    @RequestMapping("/feign/exception")
    public String feignException() {
        return userService.exception();
    }
}