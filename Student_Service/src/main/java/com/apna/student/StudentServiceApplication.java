package com.apna.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class StudentServiceApplication {

	public static void main(String[] args) {
		System.out.println("Student Service Running...");
		SpringApplication.run(StudentServiceApplication.class, args);
	}

}
