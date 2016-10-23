package com.streetstat.facade.dto;

import java.util.Set;

public class CountryDto {
    private long id;
    private String name;
    private int population;
    private Set<CityDto> cityDtos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
