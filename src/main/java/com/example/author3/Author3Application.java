package com.example.author3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.*")
@ComponentScan(basePackages = "com.example.*")
public class Author3Application {

	public static void main(String[] args) {
		SpringApplication.run(Author3Application.class, args);
	}

}
