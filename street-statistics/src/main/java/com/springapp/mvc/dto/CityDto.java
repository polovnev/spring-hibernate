package com.springapp.mvc.dto;


public class CityDto {

    private int id;
    private String name;
    private int country;
    private int population;

    public String getName() {
        return name;
    }

    public int getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public int getId() {
        return id;
    }

    public CityDto(int id, String name, int country, int population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public CityDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDto(String name, int country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }
}
