package com.zy.zycloud.zygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZygatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZygatewayApplication.class, args);
        System.out.println("====gateway==启动");
    }

}
