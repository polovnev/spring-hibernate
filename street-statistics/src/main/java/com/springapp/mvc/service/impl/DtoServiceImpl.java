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
import com.springapp.mvc.service.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class DtoServiceImpl implements DtoService {

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private StreetNameInfoDao streetNameInfoDao;

    @Autowired
    private StreetDao streetDao;


    @Autowired
    private CountryConverter countryConverter;

    @Autowired
    private CityConverter cityConverter;

    @Autowired
    private StreetNameInfoConverter streetNameInfoConverter;

    @Autowired
    private StreetConverter streetConverter;

    @Override
    public CityDto getCityDtoById(int id) {
        City city = (City) cityDao.getById(id);
        CityDto cityDto = cityConverter.convertToCityDto(city, true);
        return cityDto;
    }

    public CountryDto getCountryDtoById(int id) {
        Country country = (Country) countryDao.getById(id);
        CountryDto countryDto = countryConverter.convertToCountryDto(country);
        return countryDto;
    }

    @Override
    public StreetDto getStreetDtoById(int id) {
        Street street = (Street) streetDao.getById(id);
        StreetDto streetDto = streetConverter.convertToStreetDto(street);
        return streetDto;
    }

    @Override
    public StreetNameInfoDto getStreetNameInfoById(int id) {
        StreetNameInfo streetNameInfo = (StreetNameInfo) streetNameInfoDao.getById(id);
        StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo,true);
        return streetNameInfoDto;
    }


    @Override
    public List<CityDto> getAllCityDtos() {
        List<City> cityList = cityDao.getAll();
        List<CityDto> result = new ArrayList<CityDto>(cityList.size());
        for (City city : cityList) {
            CityDto cityDto = cityConverter.convertToCityDto(city, false);
            result.add(cityDto);
        }
        return result;
    }

    @Override
    public List<StreetNameInfoDto> getAllStreetNamesInfoDtos() {
        List<StreetNameInfo> streetNamesInfo = streetNameInfoDao.getAll();
        List<StreetNameInfoDto> result = new ArrayList<StreetNameInfoDto>(streetNamesInfo.size());
        for (StreetNameInfo streetNameInfo : streetNamesInfo) {
            StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo,false);
            result.add(streetNameInfoDto);
        }
        return result;
    }

    @Override
    public List<CityDto> getCitiesByCountry(int id) {
        Set<City> citySet = cityDao.getAllCityForCountry(id);
        List<CityDto> result = new ArrayList<CityDto>(citySet.size());
        for (City city : citySet) {
            CityDto cityDto = cityConverter.convertToCityDto(city, false);
            result.add(cityDto);
        }
        return result;
    }

    @Override
    public List<StreetDto> getStreetsByCity(int id) {
        Set<Street> streets = streetDao.getStreetsForCityId(id);
        List<StreetDto> result = new ArrayList<StreetDto>(streets.size());
        for (Street street : streets) {
            StreetDto streetDto = streetConverter.convertToStreetDto(street);
            result.add(streetDto);
        }
        return result;
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


}
