package com.example.rickandmortyinmemory.controller;

import com.example.rickandmortyinmemory.model.MovieCharacter;
import com.example.rickandmortyinmemory.repository.MovieCharacterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public MovieCharacter saveCharacter(Long id,
                                        String name,
                                        String status,
                                        String gender) {
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setId(id);
        movieCharacter.setName(name);
        movieCharacter.setStatus(status);
        movieCharacter.setGender(gender);
        return repository.save(movieCharacter);
    }
}
