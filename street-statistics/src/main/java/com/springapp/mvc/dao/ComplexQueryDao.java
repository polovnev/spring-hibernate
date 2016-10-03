package com.springapp.mvc.dao;

import com.springapp.mvc.model.City;

public interface ComplexQueryDao {

    City showCityThisSumLongestStreet(int countryId);

    City showCityThisBiggerstPopulation(int countryId);

    City showCityThisSmallestPopulation(int countryId);

}
