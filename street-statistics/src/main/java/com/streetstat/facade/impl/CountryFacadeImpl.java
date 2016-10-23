package com.streetstat.facade.impl;


import com.streetstat.facade.CountryFacade;
import com.streetstat.facade.converter.CountryConverter;
import com.streetstat.facade.dto.CountryDto;
import com.streetstat.model.Country;
import com.streetstat.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryFacadeImpl implements CountryFacade {

    @Autowired
    CountryService countryService;

    @Autowired
    CountryConverter countryConverter;

    @Override
    public void saveCountry(CountryDto countryDto) {
        Country country = countryConverter.convertToCountry(countryDto);
        countryService.saveCountry(country);
    }

    @Override
    public CountryDto getCountryDtoById(long id) {
        Country country = countryService.getCountryById(id);
        return countryConverter.convertToCountryDto(country);
    }

    @Override
    public List<CountryDto> getAllCountriesDtos() {
        List<Country> countries = countryService.getAllCountries();
        List<CountryDto> countryDtos = new ArrayList<>(countries.size());
        for(Country country : countries) {
            countryDtos.add(countryConverter.convertToCountryDto(country));
        }
        return countryDtos;
    }

    @Override
    public void removeCountry(long id) {
        countryService.removeCountry(id);
    }

}
