package com.zycloud.testclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TestController1 {

    @RequestMapping("/ping")
    @ResponseBody
    public String ping(){
        return "{'status': 'up'}";
    }

    //
    @RequestMapping("/readFrontendConfig")
    @ResponseBody
    public String readFrontendConfig(){
        return "this is test readFrontendConfig";
    }

    //
    @RequestMapping("/undefinedList")
    @ResponseBody
    public String undefinedList(){
        return "this is test undefinedList";
    }
}
