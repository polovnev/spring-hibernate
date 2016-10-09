package com.streetstat.converter;

import com.streetstat.dto.CityDto;
import com.streetstat.dto.CountryDto;
import com.streetstat.model.City;
import com.streetstat.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CountryConverter {

    @Autowired
    CityConverter cityConverter;

    public Country convertToCountry(CountryDto countryDTO) {
        int id = countryDTO.getId();
        String name = countryDTO.getName();
        int population = countryDTO.getPopulation();
        Set<CityDto> cities = countryDTO.getCityDtos();

        Country result = new Country();
        result.setId(id);
        result.setName(name);
        result.setPopulation(population);

        Set<City> citySet = cityConverter.convertSetToCity(cities);
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

        Set<CityDto> cityDtos = cityConverter.convertSetToCityDto(cities);
        result.setCityDtos(cityDtos);
        return result;
    }


}
