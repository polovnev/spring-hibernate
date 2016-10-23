package com.streetstat.facade.converter;

import com.streetstat.facade.dto.CityDto;
import com.streetstat.facade.dto.CountryDto;
import com.streetstat.model.City;
import com.streetstat.model.Country;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CountryConverter {

    @Autowired
    CityConverter cityConverter;

    public Country convertToCountry(CountryDto countryDTO) {
        if(countryDTO == null) {
            return null;
        }
        Country country = new Country();
        country.setId(countryDTO.getId());
        country.setName(countryDTO.getName());
        country.setPopulation(countryDTO.getPopulation());
        country.setCities(getCities(countryDTO.getCityDtos(), country));
        return country;
    }

    public CountryDto convertToCountryDto(Country country) {
        if(country == null) {
            return null;
        }
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setPopulation(country.getPopulation());
        countryDto.setCityDtos(getCityDtos(country.getCities(), countryDto));
        return countryDto;
    }

    private Set<CityDto> getCityDtos(Set<City> cities, CountryDto countryDto) {
        if (!Hibernate.isInitialized(cities)) {
            return null;
        }
        Set<CityDto> cityDtos = new HashSet<CityDto>();
        for (City city : cities) {
            Country country = city.getCountry();
            city.setCountry(null);
            CityDto cityDto = cityConverter.convertToCityDto(city);
            cityDto.setCountryDto(countryDto);
            cityDtos.add(cityDto);
            city.setCountry(country);
        }
        return cityDtos;
    }

    private Set<City> getCities(Set<CityDto> cityDtos, Country country) {
        if (cityDtos == null) {
            return null;
        }
        Set<City> cities = new HashSet<City>();
        for (CityDto cityDto : cityDtos) {
            cityDto.setCountryDto(null);
            City city = cityConverter.convertToCity(cityDto);
            city.setCountry(country);
            cities.add(city);
        }
        return cities;
    }
}
