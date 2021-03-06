package com.streetstat.facade.dto;

import java.util.Set;


public class CityDto {

    private long id;
    private String name;
    private int population;
    private CountryDto countryDto;
    private Set<StreetDto> streetDtos;



    public String getName() {
        return name;
    }


    public int getPopulation() {
        return population;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public CountryDto getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }

    public Set<StreetDto> getStreetDtos() {
        return streetDtos;
    }

    public void setStreetDtos(Set<StreetDto> streetDtos) {
        this.streetDtos = streetDtos;
    }
}
