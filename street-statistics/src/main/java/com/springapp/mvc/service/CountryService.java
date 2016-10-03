package com.springapp.mvc.service;


import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.CountryDto;

import java.util.List;

public interface CountryService {

    void saveCountry(CountryDto countryDto);

    CountryDto getCountryDtoById(int id);

    List<CountryDto> getAllCountriesDtos();

    void removeCountry(int id);


}
