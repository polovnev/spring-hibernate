package com.streetstat.dto;

import java.util.Set;

public class CountryDto {
    private int id;
    private String name;
    private int population;
    private Set<CityDto> cityDtos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Set<CityDto> getCityDtos() {
        return cityDtos;
    }

    public void setCityDtos(Set<CityDto> cityDtos) {
        this.cityDtos = cityDtos;
    }
}
