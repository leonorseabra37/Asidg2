package com.java.SAGA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SAGAAplication {

	public static void main(String[] args) {
		SpringApplication.run(SAGAAplication.class, args);
	}

}
