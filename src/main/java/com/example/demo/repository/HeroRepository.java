package com.example.demo.repository;

import com.example.demo.model.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long>{

}
