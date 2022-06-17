package com.zycloud.zyzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZyzipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyzipkinApplication.class, args);
        System.out.println("====服务【zip】启动");
    }

}
