package com.streetstat.service;


import com.streetstat.facade.dto.CityDto;
import com.streetstat.model.City;

import java.util.List;
import java.util.Set;

public interface CityService {

    void saveCity(City city);

    City getCityById(long id);

    List<City> getAllCity();

    Set<City> getCitiesByCountry(long id);

    void removeCity(long id);

    City showCityThisSumLongestStreet(long countryId);

    City showCityThisBiggestPopulation(long countryId);

    City showCityThisSmallestPopulation(long countryId);
}
