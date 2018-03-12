package com.example.demo.controller;

import com.example.demo.model.Hero;
import com.example.demo.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class HeroesController {

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
                new Hero(1L,"Marcus"),
                new Hero(2L,"Molefe"),
                new Hero(3L,"Phillip")      );

    }
    @RequestMapping("/all")
    public @ResponseBody Iterable<Hero> getAllHeros()
    {
        return heroRepository.findAll();
    }


}
