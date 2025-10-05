package com.deepak.Chache_Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChacheDemoApplication.class, args);
	}

}
