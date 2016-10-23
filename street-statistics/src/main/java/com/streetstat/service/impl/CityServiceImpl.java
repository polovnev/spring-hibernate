package com.streetstat.service.impl;


import com.streetstat.dao.CityDao;
import com.streetstat.facade.dto.CityDto;
import com.streetstat.model.City;
import com.streetstat.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public void saveCity(City city) {
        cityDao.saveOrUpdate(city);
    }


    @Override
    public City getCityById(long id) {
        return (City) cityDao.findById(id,"");
    }

    @Override
    public List<City> getAllCity() {
        return cityDao.getCities(0,100);
    }

    @Override
    public Set<City> getCitiesByCountry(long id) {
        return cityDao.getAllCityForCountry(id);
    }

    public void removeCity(long id) {
        cityDao.deleteById(id);
    }


    @Override
    public City showCityThisSumLongestStreet(long countryId) {
        return cityDao.showCityThisSumLongestStreet(countryId);
    }

    @Override
    public City showCityThisBiggestPopulation(long countryId) {
        return cityDao.showCityThisBiggerstPopulation(countryId);
    }

    @Override
    public City showCityThisSmallestPopulation(long countryId) {
        return cityDao.showCityThisSmallestPopulation(countryId);
    }

}
