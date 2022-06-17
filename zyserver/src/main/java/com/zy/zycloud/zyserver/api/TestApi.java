package com.zy.zycloud.zyserver.api;

import com.zy.zycloud.commons.utils.IpHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping("/TestApi")
public class TestApi {

    @RequestMapping("/t")
    @ResponseBody
    public String t(Map<String, Object> arrMap) throws Exception {
        String ip = IpHelper.getLocalIp();
        //String ip = "test";
        if (1 == 1) {
            //throw  new Exception("模拟问题了");
        }
        return "处理服务：[" + ip + "] 处理 ces";
    }
}
