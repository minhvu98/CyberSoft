package com.myclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.myclass")
public class CybersoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(CybersoftApplication.class, args);
	}

}
