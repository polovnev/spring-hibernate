package com.springapp.mvc.service.impl;

import com.springapp.mvc.converter.CountryConverter;
import com.springapp.mvc.dao.CountryDao;
import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.model.Country;
import com.springapp.mvc.service.CountryService;
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

    public void removeCountry(int id) {
        countryDao.deleteById(id);
    }




}
