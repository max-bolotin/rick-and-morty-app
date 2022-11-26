package com.springboot.project.rickandmortyapp.controller;

import com.springboot.project.rickandmortyapp.dto.ApiResponseDto;
import com.springboot.project.rickandmortyapp.service.HttpClient;
import com.springboot.project.rickandmortyapp.service.MovieCharacterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/demo")
public class DemoController {
    private final MovieCharacterService characterService;

    public DemoController(MovieCharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public String runDemo() {
        characterService.syncExternalCharacters();
        return "Done!";
    }

}
