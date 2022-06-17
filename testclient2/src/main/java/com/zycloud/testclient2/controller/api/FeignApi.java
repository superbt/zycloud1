package com.zycloud.testclient2.controller.api;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zycloud.testclient2.controller.api.fallback.FeignApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(value = "zy-server", fallback = FeignApiFallBack.class)
public interface FeignApi {

    // @RequestMapping(value = "/TestApi/t",method = RequestMethod.GET)
    @GetMapping("/TestApi/t")
   // @HystrixCommand(commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000") })
    String t(Map<String, Object> arrMap);

}
