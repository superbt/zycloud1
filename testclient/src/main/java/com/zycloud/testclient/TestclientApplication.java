package com.zycloud.testclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableHystrix
public class TestclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestclientApplication.class, args);
        System.out.println("=====测速testClient启动===");
    }

}
