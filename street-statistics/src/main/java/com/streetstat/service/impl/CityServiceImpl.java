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
    public CityDto getCityDtoById(int id) {
        City city = (City) cityDao.getById(id);
        CityDto cityDto = cityConverter.convertToCityDto(city);
        return cityDto;
    }

    @Override
    public List<CityDto> getAllCityDtos() {
        List<City> cityList = cityDao.getAll();
        List<CityDto> result = new ArrayList<CityDto>(cityList.size());
        for (City city : cityList) {
            CityDto cityDto = cityConverter.convertToCityDto(city);
            result.add(cityDto);
        }
        return result;
    }

    @Override
    public List<CityDto> getCitiesByCountry(int id) {
        Set<City> citySet = cityDao.getAllCityForCountry(id);
        List<CityDto> result = new ArrayList<CityDto>(citySet.size());
        for (City city : citySet) {
            CityDto cityDto = cityConverter.convertToCityDto(city);
            result.add(cityDto);
        }
        return result;
    }

    public void removeCity(int id) {
        cityDao.deleteById(id);
    }


    @Override
    public CityDto showCityThisSumLongestStreet(int countryId) {
        City city = cityDao.showCityThisSumLongestStreet(countryId);
        return cityConverter.convertToCityDto(city);
    }

    @Override
    public CityDto showCityThisBiggestPopulation(int countryId) {
        City city = cityDao.showCityThisBiggerstPopulation(countryId);
        return cityConverter.convertToCityDto(city);
    }

    @Override
    public CityDto showCityThisSmallestPopulation(int countryId) {
        City city = cityDao.showCityThisSmallestPopulation(countryId);
        return cityConverter.convertToCityDto(city);
    }

}
