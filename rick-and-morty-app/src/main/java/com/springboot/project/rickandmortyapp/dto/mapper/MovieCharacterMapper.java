package com.springboot.project.rickandmortyapp.dto.mapper;

import com.springboot.project.rickandmortyapp.dto.ApiCharacterDto;
import com.springboot.project.rickandmortyapp.dto.ApiResponseDto;
import com.springboot.project.rickandmortyapp.model.Gender;
import com.springboot.project.rickandmortyapp.model.MovieCharacter;
import com.springboot.project.rickandmortyapp.model.Status;
import org.springframework.stereotype.Component;

@Component
public class MovieCharacterMapper {
    public MovieCharacter parseApiCharacterResponseDto(ApiCharacterDto dto) {
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setName(dto.getName());
        movieCharacter.setGender(Gender.valueOf(dto.getGender().toUpperCase()));
        movieCharacter.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        movieCharacter.setExternalId(dto.getId());
        return movieCharacter;
    }
}
