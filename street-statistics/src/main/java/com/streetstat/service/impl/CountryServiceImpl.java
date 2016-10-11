package com.streetstat.service.impl;

import com.streetstat.converter.CountryConverter;
import com.streetstat.dao.CountryDao;
import com.streetstat.dto.CountryDto;
import com.streetstat.model.Country;
import com.streetstat.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private CountryConverter countryConverter;


    @Override
    public void saveCountry(CountryDto countryDto) {
        Country country = countryConverter.convertToCountry(countryDto);
        countryDao.saveOrUpdate(country);
    }

    public List<CountryDto> getAllCountriesDtos() {
        List<Country> countryList = countryDao.getAll();
        List<CountryDto> result = new ArrayList<CountryDto>(countryList.size());
        for (Country country : countryList) {
            CountryDto countryDto = countryConverter.convertToCountryDto(country);
            result.add(countryDto);
        }
        return result;
    }

    public CountryDto getCountryDtoById(int id) {
        Country country = (Country) countryDao.getById(id);
        CountryDto countryDto = countryConverter.convertToCountryDto(country);
        return countryDto;
    }

    public Country getCountryById(int id) {
        Country country = (Country) countryDao.getById(id);
        return country;
    }

    public void removeCountry(int id) {
        countryDao.deleteById(id);
    }




}
