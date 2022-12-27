package com.springboot.project.rickandmortyapp.controller;

import com.springboot.project.rickandmortyapp.dto.CharacterResponseDto;
import com.springboot.project.rickandmortyapp.dto.mapper.MovieCharacterMapper;
import com.springboot.project.rickandmortyapp.model.MovieCharacter;
import com.springboot.project.rickandmortyapp.service.MovieCharacterService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-characters")
public class MovieCharacterController {
    private final MovieCharacterService characterService;
    private final MovieCharacterMapper characterMapper;

    public MovieCharacterController(MovieCharacterService characterService,
                                    MovieCharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @GetMapping("/random")
    public CharacterResponseDto getRandom() {
        MovieCharacter randomCharacter = characterService.getRandomCharacter();
        return characterMapper.toResponseDto(randomCharacter);
    }

    @GetMapping("/by-name")
    public List<CharacterResponseDto> getAllByNameContains(@RequestParam("name") String namePart) {
        return characterService.findAllByNameContains(namePart).stream()
                .map(characterMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}

