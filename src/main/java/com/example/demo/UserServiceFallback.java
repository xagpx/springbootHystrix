package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {

    @Override
    public String timeout() {
        return "timeout 降级";
    }

    @Override
    public String exception() {
        return "exception 降级";
    }
}