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
        return new Country(id, name, population);
    }

    public CountryDto convertToCountryDto(Country country) {
        int id = country.getId();
        String name = country.getName();
        return new CountryDto(id,name);
    }


}
