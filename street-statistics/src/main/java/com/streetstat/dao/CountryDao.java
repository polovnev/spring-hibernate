package com.streetstat.dao;


import com.streetstat.model.Country;

import java.util.List;

public interface CountryDao extends Dao {

    List<Country> getCountries(int page, int pageSize);
}
