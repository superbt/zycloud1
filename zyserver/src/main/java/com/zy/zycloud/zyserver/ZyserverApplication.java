package com.zy.zycloud.zyserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZyserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyserverApplication.class, args);
        System.out.println("====zy-server-启动");
    }

}
