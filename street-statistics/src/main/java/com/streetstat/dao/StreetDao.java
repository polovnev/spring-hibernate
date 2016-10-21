package com.streetstat.dao;

import com.streetstat.model.Street;

import java.util.Set;

public interface StreetDao extends Dao {

    Set<Street> getStreetsForCityId(long idCity);


}
