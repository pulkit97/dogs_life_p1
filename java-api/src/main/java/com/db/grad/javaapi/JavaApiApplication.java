package com.db.grad.javaapi;

import com.db.grad.javaapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaApiApplication implements CommandLineRunner {

	@Autowired
	DogRepository dogRepository;

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		System.out.println("Test message");

	}
}
