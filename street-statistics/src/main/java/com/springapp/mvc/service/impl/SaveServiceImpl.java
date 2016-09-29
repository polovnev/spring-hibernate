package com.springapp.mvc.service.impl;


import com.springapp.mvc.converter.CityConverter;
import com.springapp.mvc.converter.CountryConverter;
import com.springapp.mvc.converter.StreetConverter;
import com.springapp.mvc.converter.StreetNameInfoConverter;
import com.springapp.mvc.dao.CityDao;
import com.springapp.mvc.dao.CountryDao;
import com.springapp.mvc.dao.StreetDao;
import com.springapp.mvc.dao.StreetNameInfoDao;
import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.model.City;
import com.springapp.mvc.model.Country;
import com.springapp.mvc.model.Street;
import com.springapp.mvc.model.StreetNameInfo;
import com.springapp.mvc.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveServiceImpl implements SaveService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private StreetNameInfoDao streetNameInfoDao;

    @Autowired
    private StreetDao streetDao;

    @Autowired
    private CityConverter cityConverter;

    @Autowired
    private CountryConverter countryConverter;

    @Autowired
    private StreetNameInfoConverter streetNameInfoConverter;

    @Autowired
    private StreetConverter streetConverter;

    @Override
    public void saveCity(CityDto cityDto) {
        City city = cityConverter.convertToCity(cityDto);
        cityDao.saveOrUpdate(city);
    }

    @Override
    public void saveCountry(CountryDto countryDto) {
        Country country = countryConverter.convertToCountry(countryDto);
        countryDao.saveOrUpdate(country);
    }

    @Override
    public void saveStreetNameInfo(StreetNameInfoDto streetNameInfoDto) {
        StreetNameInfo streetNameInfo = streetNameInfoConverter.convertToStreetNameInfo(streetNameInfoDto);
        streetNameInfoDao.saveOrUpdate(streetNameInfo);
    }

    @Override
    public void saveStreet(StreetDto streetDto) {
        Street street = streetConverter.convertToStreet(streetDto);
        streetDao.saveOrUpdate(street);
    }
}
