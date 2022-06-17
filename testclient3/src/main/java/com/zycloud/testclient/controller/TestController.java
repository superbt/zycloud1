package com.zycloud.testclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/h1")
    @ResponseBody
    public String test_bt1(Map<String,Object> map){
        return "hello bt";
    }

    @RequestMapping("/ping")
    @ResponseBody
    public String test(){
        return "this is test ping";
    }
}
