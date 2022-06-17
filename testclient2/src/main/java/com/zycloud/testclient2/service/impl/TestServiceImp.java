package com.zycloud.testclient2.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zycloud.testclient2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TestServiceImp implements TestService {

    @Autowired
    private RestTemplate restTemplate ;

    @HystrixCommand
    public String tService1(){
        return restTemplate.getForObject("http://zy-server/TestApi/t", String.class);
    }
}
