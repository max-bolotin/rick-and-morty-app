package com.example.rickandmortyinmemory.model;

enum Gender {
        FEMALE("Female"),
        MALE("Male"),
        GENDERLESS("Genderless"),
        UNKNOWN("unknown");

        private String value;

        Gender(String value) {
            this.value = value;
        }
    }