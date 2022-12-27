package com.springboot.project.rickandmortyapp.dto;

import com.springboot.project.rickandmortyapp.model.Gender;
import com.springboot.project.rickandmortyapp.model.Status;
import lombok.Data;

@Data
public class CharacterResponseDto {
    private Long id;
    private Long externalId;
    private String name;
    private Status status;
    private Gender gender;
}
