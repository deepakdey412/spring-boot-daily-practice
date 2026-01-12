package com.deepak.Demo_02.controller;

import com.deepak.Demo_02.feign.feignProvider;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final feignProvider feignProvider;
    private final Environment environment;

    public DemoController(feignProvider feignProvider, Environment environment) {
        this.feignProvider = feignProvider;
        this.environment = environment;
    }

    @GetMapping("/get-port")
    private  String getPort() {
        return environment.getProperty("server.port");
    }

    @GetMapping("/service2")
    public String service2(){
        String msg1 = "Service 02 ";
        String msg2 = feignProvider.invokeService2Method();
        return msg2+"  "+msg1 ;
    }
}
