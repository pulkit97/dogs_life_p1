package com.qa.superheroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qa.superheroes.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {

    @Query(nativeQuery = true, value = "select * from heroes where name like :letter")
    List<Hero> findHeroesNameStartingWithLetter(String letter);

    List<Hero> findTop3ByOrderByNameDesc();
}
