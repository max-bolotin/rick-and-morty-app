package com.example.rickandmortyinmemory.repository;

import com.example.rickandmortyinmemory.model.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Long> {
/*    @Query(value = "INSERT INTO movie_character(id, name, status, gender)\n" +
            "VALUES (?, ?, ?, ?)\n" +
            "RETURNING id", nativeQuery = true)
    MovieCharacter save(MovieCharacter movieCharacter);*/
}
