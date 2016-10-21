package com.streetstat.service;


import com.streetstat.dto.CountryDto;
import com.streetstat.model.Country;

import java.util.List;

public interface CountryService {

    void saveCountry(CountryDto countryDto);

    CountryDto getCountryDtoById(long id);

    List<CountryDto> getAllCountriesDtos();

    void removeCountry(long id);

    Country getCountryById(long id);


}
