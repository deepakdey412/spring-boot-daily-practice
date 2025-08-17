package com.dd.springcore_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.dd.springcore_demo",
                            "com.dd.component"}//Explicitly scanning the packages
)
public class SpringcoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoreDemoApplication.class, args);
    }

}
