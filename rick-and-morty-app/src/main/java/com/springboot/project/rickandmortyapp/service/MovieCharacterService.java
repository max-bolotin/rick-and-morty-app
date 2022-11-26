package com.springboot.project.rickandmortyapp.service;

import org.springframework.stereotype.Service;

@Service
public interface MovieCharacterService {
    void syncExternalCharacters();
}
