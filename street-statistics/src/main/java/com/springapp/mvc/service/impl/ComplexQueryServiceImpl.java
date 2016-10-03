package com.springapp.mvc.service.impl;

import com.springapp.mvc.converter.CityConverter;
import com.springapp.mvc.dao.ComplexQueryDao;
import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.model.City;
import com.springapp.mvc.service.ComplexQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplexQueryServiceImpl implements ComplexQueryService {

    @Autowired
    private ComplexQueryDao complexQueryDao;

    @Autowired
    private CityConverter cityConverter;

    @Override
    public CityDto showCityThisSumLongestStreet(int countryId) {
        City city = complexQueryDao.showCityThisSumLongestStreet(countryId);
        return cityConverter.convertToCityDto(city, false);
    }

    @Override
    public CityDto showCityThisBiggestPopulation(int countryId) {
        City city = complexQueryDao.showCityThisBiggerstPopulation(countryId);
        return cityConverter.convertToCityDto(city,false);
    }

    @Override
    public CityDto showCityThisSmallestPopulation(int countryId) {
        City city = complexQueryDao.showCityThisSmallestPopulation(countryId);
        return cityConverter.convertToCityDto(city,false);
    }
}
