package com.springapp.mvc.dao;

import com.springapp.mvc.model.Street;

import java.util.Set;

public interface StreetDao extends AbstractDao {

    Set<Street> getStreetsForCityId(int idCity);


}
