package com.springapp.mvc.service.impl;


import com.springapp.mvc.converter.CityConverter;
import com.springapp.mvc.dao.CityDao;
import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.model.City;
import com.springapp.mvc.service.CityService;
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
        CityDto cityDto = cityConverter.convertToCityDto(city, true);
        return cityDto;
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
    public List<CityDto> getCitiesByCountry(int id) {
        Set<City> citySet = cityDao.getAllCityForCountry(id);
        List<CityDto> result = new ArrayList<CityDto>(citySet.size());
        for (City city : citySet) {
            CityDto cityDto = cityConverter.convertToCityDto(city, false);
            result.add(cityDto);
        }
        return result;
    }

    public void removeCity(int id) {
        cityDao.deleteById(id);
    }

}
