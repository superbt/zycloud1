package com.zycloud.testclient2.controller.api.fallback;
import com.zy.zycloud.commons.utils.IpHelper;
import com.zycloud.testclient2.controller.api.FeignApi;
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
