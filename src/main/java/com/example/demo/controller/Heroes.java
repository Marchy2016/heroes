package com.example.demo.controller;

import com.example.demo.Hero;
import com.example.demo.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController

public class Heroes {

    @Autowired

    private HeroRepository heroRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name) {
        Hero h = new Hero();
        h.setName(name);
        heroRepository.save(h);
        return "Saved";
    }


    @RequestMapping("/adafa")
   @CrossOrigin(origins = "http://localhost:4200")
    public List<Hero> getAllHeroes(){
        return Arrays.asList(
                new Hero(1,"Marcus"),
                new Hero(2,"Molefe"),
                new Hero(3,"Phillip")      );

    }
    @RequestMapping("/all")
    public @ResponseBody Iterable<Hero> getAllHeros()
    {
        return heroRepository.findAll();
    }


}
