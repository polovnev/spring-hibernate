package com.streetstat.dao;

import com.streetstat.model.Street;

import java.util.Set;

public interface StreetDao extends AbstractDao {

    Set<Street> getStreetsForCityId(int idCity);


}
