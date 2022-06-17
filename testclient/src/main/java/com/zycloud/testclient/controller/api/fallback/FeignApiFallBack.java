package com.zycloud.testclient.controller.api.fallback;

import com.zycloud.testclient.controller.api.FeignApi;
import com.zycloud.testclient.utils.IpHelper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FeignApiFallBack implements FeignApi {

    @Override
    public String t(Map<String, Object> arrMap) {
        System.out.println("====服务异常咯");
        return IpHelper.getLocalIp() + "服务异常";
    }
}
