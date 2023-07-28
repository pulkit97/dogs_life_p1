package com.qa.superheroes;

import com.qa.superheroes.practice.Calculator;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {

	@Autowired
	Calculator calc;

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int result = calc.addition(4,5);
		System.out.println(result);
	}


}
