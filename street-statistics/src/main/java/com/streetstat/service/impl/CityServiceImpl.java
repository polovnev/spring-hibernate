package com.streetstat.service.impl;


import com.streetstat.converter.CityConverter;
import com.streetstat.dao.CityDao;
import com.streetstat.dto.CityDto;
import com.streetstat.model.City;
import com.streetstat.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CityConverter cityConverter;

    @Override
    public void saveCity(CityDto cityDto) {
        City city = cityConverter.convertToCity(cityDto);
        cityDao.saveOrUpdate(city);
    }

    @Override
    public CityDto getCityDtoById(long id) {
        City city = (City) cityDao.findById(id,"");
        CityDto cityDto = cityConverter.convertToCityDto(city);
        return cityDto;
    }

    @Override
    public City getCityById(long id) {
        return (City) cityDao.findById(id,"");
    }

    @Override
    public List<CityDto> getAllCityDtos() {
        List<City> cityList = cityDao.getCities(0,100);
        List<CityDto> result = new ArrayList<CityDto>(cityList.size());
        for (City city : cityList) {
            CityDto cityDto = cityConverter.convertToCityDto(city);
            result.add(cityDto);
        }
        return result;
    }

    @Override
    public List<CityDto> getCitiesByCountry(long id) {
        Set<City> citySet = cityDao.getAllCityForCountry(id);
        List<CityDto> result = new ArrayList<CityDto>(citySet.size());
        for (City city : citySet) {
            CityDto cityDto = cityConverter.convertToCityDto(city);
            result.add(cityDto);
        }
        return result;
    }

    public void removeCity(long id) {
        cityDao.deleteById(id);
    }


    @Override
    public CityDto showCityThisSumLongestStreet(long countryId) {
        City city = cityDao.showCityThisSumLongestStreet(countryId);
        return cityConverter.convertToCityDto(city);
    }

    @Override
    public CityDto showCityThisBiggestPopulation(long countryId) {
        City city = cityDao.showCityThisBiggerstPopulation(countryId);
        return cityConverter.convertToCityDto(city);
    }

    @Override
    public CityDto showCityThisSmallestPopulation(long countryId) {
        City city = cityDao.showCityThisSmallestPopulation(countryId);
        return cityConverter.convertToCityDto(city);
    }

}
