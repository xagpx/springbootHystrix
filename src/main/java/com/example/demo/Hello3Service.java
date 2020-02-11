package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@RestController
public class Hello3Service {
    @RequestMapping("/hello3")
    @HystrixCommand(fallbackMethod = "hiFail", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
           //允许的最大请求数。如果达到最大并发数时，后续请求会被拒绝。
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "1"),
            //允许最大请求数目。如果达到最大并发数目，后续请求将会被拒绝，如果没有实现回退，则抛出异常。
            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "1"),
           //隔离策略，有两种选项 THREAD —— 在固定大小线程池中，以单独线程执行，并发请求数受限于线程池大小 SEMAPHORE —— 在调用线程中执行，通过信号量来限制并发量
            @HystrixProperty(name = "execution.isolation.strategy", value ="SEMAPHORE")
    })
    public String hi(String name) {
        return "hi " + name;
    }


    public String hiFail(String name, Throwable e) {
        if (e != null) {
            e.printStackTrace();
        }
        return "hiFail " + name;
    }
}