package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Component
@RestController
public class Hello2Service {
	//配置线程池
    @RequestMapping("/hello2")
    @HystrixCommand(fallbackMethod = "hiFail", commandProperties = {
    		//设置调用者等待命令执行的超时限制，超过此时间，HystrixCommand被标记为TIMEOUT，并执行回退逻辑
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
    },
            threadPoolProperties = {
            		//设置核心线程池大小。
                    @HystrixProperty(name = "coreSize", value = "1"),
                    //设置BlockingQueue最大的队列值。
                    @HystrixProperty(name = "maxQueueSize", value = "1"),
                    //设置存活时间，单位分钟。如果coreSize小于maximumSize，那么该属性控制一个线程从实用完成到被释放的时间。
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "0"),
                    //设置队列拒绝的阈值——一个人为设置的拒绝访问的最大队列值，即使maxQueueSize还没有达到。
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "1"),
                    //设置滚动的统计窗口被分成的桶（bucket）的数目
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "1"),
                    //设置统计的滚动窗口的时间段大小
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "60")
            })
    public String hi(String name) throws InterruptedException {
//    	 TimeUnit.MILLISECONDS.sleep(300);
        return "hi " + name;
    }


    public String hiFail(String name, Throwable e) {
        if (e != null) {
            e.printStackTrace();
        }
        return "hiFail " + name;
    }
}