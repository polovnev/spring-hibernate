package com.springapp.mvc.dao;

import com.springapp.mvc.entity.Street;

import java.util.Set;

public interface StreetDAO {

    Set<Street> getStreetsForCityId(int idCity);

    void add(Street street);

    void update(Street street);

}
