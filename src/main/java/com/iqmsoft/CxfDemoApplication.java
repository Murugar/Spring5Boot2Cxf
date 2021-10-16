package com.iqmsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class CxfDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CxfDemoApplication.class, args);
	}
}
