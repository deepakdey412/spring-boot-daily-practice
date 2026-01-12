package com.deepak.Demo_02.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Demo-01")
public interface feignProvider {

    @GetMapping("/service1")
    String invokeService2Method();
}
