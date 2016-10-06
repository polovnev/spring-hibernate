package com.springapp.mvc.dto;

import java.util.List;


public class CityDto {

    private int id;
    private String name;
    private int country;
    private int population;
    private CountryDto countryDto;
    private List<StreetDto> streetDtos;



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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(int country) {
        this.country = country;
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

    public List<StreetDto> getStreetDtos() {
        return streetDtos;
    }

    public void setStreetDtos(List<StreetDto> streetDtos) {
        this.streetDtos = streetDtos;
    }
}
