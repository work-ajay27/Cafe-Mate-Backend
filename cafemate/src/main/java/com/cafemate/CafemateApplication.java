package com.cafemate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CafemateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafemateApplication.class, args);
		System.out.println("Spring Boot Stated");
	}

}
