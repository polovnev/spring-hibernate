package com.springapp.mvc.dao;

import com.springapp.mvc.model.City;

public interface ComplexQueryDao {

    City showCityThisSumLongestStreet(int countryId);

}
