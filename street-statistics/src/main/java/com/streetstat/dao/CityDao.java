package com.streetstat.dao;


import com.streetstat.model.City;

import java.util.List;
import java.util.Set;

public interface CityDao extends Dao {

    Set<City> getAllCityForCountry(long idCountry);

    List<City> getAllCityByStreetName(long idStreetName);

    City showCityThisSumLongestStreet(long countryId);

    City showCityThisBiggerstPopulation(long countryId);

    City showCityThisSmallestPopulation(long countryId);

    List<City> getCities(int page, int pageSize);


}
