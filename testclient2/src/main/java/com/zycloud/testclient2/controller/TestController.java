package com.zycloud.testclient2.controller;
import com.zy.zycloud.commons.utils.IpHelper;
import com.zycloud.testclient2.controller.api.FeignApi;
import com.zycloud.testclient2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Qualifier("com.zycloud.testclient2.controller.api.FeignApi")
    @Autowired(required = false)
    private FeignApi feignApi;

    @Autowired
    private TestService testService ;

    @GetMapping("/hi")
    public String test(String arg) {
        System.out.println("===ces==" + arg);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hello", "bt");
        if (feignApi == null) {
            return "服务由【" + IpHelper.getLocalIp() + "】 服务初始化未完成";
        }
        String calback = feignApi.t(map);
        return "服务由【" + IpHelper.getLocalIp() + "】 hello:[" + arg + "]" + calback;

    }

    @GetMapping("/hi1")
    public String test1(String arg){
        String  calback = testService.tService1();
        return "服务由【" + IpHelper.getLocalIp() + "】 hello:[" + arg + "]" + calback;
    }

    public String testFailure(String str) {
        System.out.println("====ces 熔断===" + str);
        return "ces 熔断" + str;
    }
}
