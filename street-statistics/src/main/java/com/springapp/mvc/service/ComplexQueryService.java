package com.springapp.mvc.service;


import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.model.City;

public interface ComplexQueryService {

    CityDto showCityThisSumLongestStreet(int countryId);

    CityDto showCityThisBiggestPopulation(int countryId);

    CityDto showCityThisSmallestPopulation(int countryId);
}
