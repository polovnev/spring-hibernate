package com.springapp.mvc.dto;

public class CountryDto {
    private int id;
    private String name;
    private int population;

    public CountryDto(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public CountryDto(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public CountryDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }


}
