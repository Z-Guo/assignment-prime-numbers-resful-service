package com.example.assignmentprimenumbersapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AssignmentPrimeNumbersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentPrimeNumbersApiApplication.class, args);
	}

}
