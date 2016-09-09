package com.springapp.mvc.dao;


import com.springapp.mvc.entity.City;

import java.util.List;
import java.util.Set;

public interface CityDao {
    Set<City> getAllCityForCountry(int idCountry);

    List<City> getAllCityByStreetName(int idStreetName);
}
