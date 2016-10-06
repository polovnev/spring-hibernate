package com.springapp.mvc.dao;


import com.springapp.mvc.model.City;

import java.util.List;
import java.util.Set;

public interface CityDao extends AbstractDao {

    Set<City> getAllCityForCountry(int idCountry);

    List<City> getAllCityByStreetName(int idStreetName);

    City showCityThisSumLongestStreet(int countryId);

    City showCityThisBiggerstPopulation(int countryId);

    City showCityThisSmallestPopulation(int countryId);



}
