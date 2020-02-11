package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableHystrixDashboard
@EnableFeignClients
public class SpringbootHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHystrixApplication.class, args);
	}

}
