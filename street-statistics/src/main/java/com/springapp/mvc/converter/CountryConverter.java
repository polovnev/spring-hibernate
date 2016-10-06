package com.springapp.mvc.converter;

import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryConverter {

    public Country convertToCountry(CountryDto countryDTO) {
        int id = countryDTO.getId();
        String name = countryDTO.getName();
        int population = countryDTO.getPopulation();
        Country result = new Country();
        result.setId(id);
        result.setName(name);
        result.setPopulation(population);
        return result;
    }

    public CountryDto convertToCountryDto(Country country) {
        int id = country.getId();
        String name = country.getName();
        CountryDto result = new CountryDto();
        result.setId(id);
        result.setName(name);
        return result;
    }


}
