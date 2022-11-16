package com.example.rickandmortyinmemory.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "movie_character")
public class MovieCharacter {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @Enumerated(EnumType.STRING)
    private String status;
//    @Enumerated(EnumType.STRING)
    private String gender;

}
