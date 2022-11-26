package com.springboot.project.rickandmortyapp.controller;

import com.springboot.project.rickandmortyapp.model.MovieCharacter;
import com.springboot.project.rickandmortyapp.repository.MovieCharacterRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MovieCharacterController {
    private final MovieCharacterRepository repository;

    public MovieCharacterController(MovieCharacterRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String helloWorld() {
        return "Hello World!!";
    }

    @GetMapping("/all")
    public List<MovieCharacter> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public MovieCharacter saveCharacter(/*Long id,
                                        */String name,
                                        String status,
                                        String gender) {
        MovieCharacter movieCharacter = new MovieCharacter();
//        movieCharacter.setId(id);
        movieCharacter.setName(name);
//        movieCharacter.setStatus(status);
//        movieCharacter.setGender(gender);
        return repository.save(movieCharacter);
    }
}

