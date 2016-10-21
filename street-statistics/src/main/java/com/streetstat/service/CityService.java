package com.streetstat.service;


import com.streetstat.dto.CityDto;
import com.streetstat.model.City;

import java.util.List;

public interface CityService {

    void saveCity(CityDto cityDto);

    CityDto getCityDtoById(long id);

    City getCityById(long id);

    List<CityDto> getAllCityDtos();

    List<CityDto> getCitiesByCountry(long id);

    void removeCity(long id);

    CityDto showCityThisSumLongestStreet(long countryId);

    CityDto showCityThisBiggestPopulation(long countryId);

    CityDto showCityThisSmallestPopulation(long countryId);
}
