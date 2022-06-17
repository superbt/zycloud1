package com.zycloud.testclient.controller.api;


import com.zycloud.testclient.controller.api.fallback.FeignApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Map;

@FeignClient(value = "zy-server", fallback = FeignApiFallBack.class)
public interface FeignApi {

    // @RequestMapping(value = "/TestApi/t",method = RequestMethod.GET)
    @GetMapping("/TestApi/t")
    String t(Map<String, Object> arrMap);

}
