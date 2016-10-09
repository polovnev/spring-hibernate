package com.streetstat.service;


import com.streetstat.dto.CountryDto;

import java.util.List;

public interface CountryService {

    void saveCountry(CountryDto countryDto);

    CountryDto getCountryDtoById(int id);

    List<CountryDto> getAllCountriesDtos();

    void removeCountry(int id);


}
