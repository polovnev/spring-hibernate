package com.streetstat.facade.impl;


import com.streetstat.facade.CityFacade;
import com.streetstat.facade.converter.CityConverter;
import com.streetstat.facade.dto.CityDto;
import com.streetstat.model.City;
import com.streetstat.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CityFacadeImpl implements CityFacade {

    @Autowired
    CityService cityService;

    @Autowired
    CityConverter cityConverter;

    public void saveCity(CityDto cityDto) {
        City city = cityConverter.convertToCity(cityDto);
        cityService.saveCity(city);
    }

    @Override
    public CityDto getCityDtoById(long id) {
        City city = cityService.getCityById(id);
        return cityConverter.convertToCityDto(city);
    }

    @Override
    public List<CityDto> getAllCityDtos() {
        List<City> cities = cityService.getAllCity();
        List<CityDto> cityDtos = new ArrayList<>(cities.size());
        for (City city : cities) {
            cityDtos.add(cityConverter.convertToCityDto(city));
        }
        return cityDtos;
    }

    @Override
    public Set<CityDto> getCityDtosByCountry(long id) {
        Set<City> cities = cityService.getCitiesByCountry(id);
        Set<CityDto> cityDtos = new HashSet<>(cities.size());
        for (City city : cities) {
            cityDtos.add(cityConverter.convertToCityDto(city));
        }
        return cityDtos;
    }

    @Override
    public void removeCity(long id) {
        cityService.removeCity(id);
    }

    @Override
    public CityDto showCityDtoThisSumLongestStreet(long countryId) {
        City city = cityService.showCityThisSumLongestStreet(countryId);
        return cityConverter.convertToCityDto(city);
     }

    @Override
    public CityDto showCityDtoThisBiggestPopulation(long countryId) {
        City city = cityService.showCityThisBiggestPopulation(countryId);
        return cityConverter.convertToCityDto(city);
    }

    @Override
    public CityDto showCityDtoThisSmallestPopulation(long countryId) {
        City city = cityService.showCityThisSmallestPopulation(countryId);
        return cityConverter.convertToCityDto(city);
    }

}
