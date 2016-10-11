package com.streetstat.converter;

import com.streetstat.dto.CityDto;
import com.streetstat.dto.CountryDto;
import com.streetstat.model.City;
import com.streetstat.model.Country;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CountryConverter {

    @Autowired
    CityConverter cityConverter;

    public Country convertToCountry(CountryDto countryDTO) {
        int id = countryDTO.getId();
        String name = countryDTO.getName();
        int population = countryDTO.getPopulation();
        Set<CityDto> cityDtos = countryDTO.getCityDtos();

        Country result = new Country();
        result.setId(id);
        result.setName(name);
        result.setPopulation(population);

        Set<City> citySet = getCities(cityDtos);
        result.setCities(citySet);
        return result;
    }


    public CountryDto convertToCountryDto(Country country) {
        int id = country.getId();
        String name = country.getName();
        int population = country.getPopulation();
        Set<City> cities = country.getCities();

        CountryDto result = new CountryDto();
        result.setId(id);
        result.setName(name);
        result.setPopulation(population);

        Set<CityDto> cityDtos = getCityDtos(cities);
        result.setCityDtos(cityDtos);
        return result;
    }

    private Set<CityDto> getCityDtos(Set<City> cities) {
        Set<CityDto> cityDtos = new HashSet<CityDto>();
        if (Hibernate.isInitialized(cities)) {
            for (City city : cities) {
                cityDtos.add(cityConverter.convertToCityDto(city));
            }
        }
        return cityDtos;
    }

    private Set<City> getCities(Set<CityDto> cityDtos) {
        Set<City> cities = new HashSet<City>();
        if (cityDtos != null) {
            for (CityDto cityDto : cityDtos) {
                cities.add(cityConverter.convertToCity(cityDto));
            }
        }
        return cities;
    }


}
