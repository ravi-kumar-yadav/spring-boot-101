package com.ravi.spring_boot_101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot101Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot101Application.class, args);
		System.out.println("********** Started application **********");
	}

}
