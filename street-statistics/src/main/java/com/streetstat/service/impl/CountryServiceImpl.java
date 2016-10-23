package com.streetstat.service.impl;

import com.streetstat.dao.CountryDao;
import com.streetstat.model.Country;
import com.streetstat.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;



    @Override
    public void saveCountry(Country country) {
        countryDao.saveOrUpdate(country);
    }

    public List<Country> getAllCountries() {
        return countryDao.getCountries(0,100);
    }

    public Country getCountryById(long id) {
        Country country = (Country) countryDao.findById(id,"");
        return country;
    }

    public void removeCountry(long id) {
        countryDao.deleteById(id);
    }




}
