package com.springapp.mvc.service;

import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;


public interface SaveService {

    void saveCity(CityDto cityDto);

    void saveCountry(CountryDto countryDto);

    void saveStreetNameInfo(StreetNameInfoDto streetNameInfoDto);

    void saveStreet(StreetDto streetDto);

}
