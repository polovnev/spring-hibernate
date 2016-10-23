package com.streetstat.service;


import com.streetstat.facade.dto.CountryDto;
import com.streetstat.model.Country;

import java.util.List;

public interface CountryService {

    void saveCountry(Country country);

    Country getCountryById(long id);

    List<Country> getAllCountries();

    void removeCountry(long id);


}
