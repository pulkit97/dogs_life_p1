package com.qa.superheroes;

import com.qa.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.qa.superheroes.model.*;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication {

	@Autowired
	HeroService heroService;

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
////		List<Hero> heroes = heroRepository.findAll();
////		List<Hero> heroes = heroRepository.findHeroesNameStartingWithLetter("C%");
//
//		List<Hero> heroes = heroService.getHeroesStartingWithLetter("C");
//
//		for (Hero hero: heroes){
//			System.out.println(hero);
//		}
//	}
}
