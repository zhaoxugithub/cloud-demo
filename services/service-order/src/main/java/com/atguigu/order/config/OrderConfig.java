package com.atguigu.order.config;

import feign.Logger;
import feign.RetryableException;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfig {



//    @Bean
    Retryer retryer(){
        return new Retryer.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 这个注解式负载均衡，会让RestTemplate具备负载均衡的能力
     * 在测试v1,v2 版本时，需要注释掉这个注解，不然会报错
     * @return
     */
    @LoadBalanced //注解式负载均衡
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
