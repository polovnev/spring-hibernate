package com.springapp.mvc.service;


import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;

import java.util.List;

public interface DtoService {

    CityDto getCityDtoById(int id);

    CountryDto getCountryDtoById(int id);

    StreetDto getStreetDtoById(int id);

    StreetNameInfoDto getStreetNameInfoById(int id);

    List<CountryDto> getAllCountriesDtos();

    List<CityDto> getAllCityDtos();

    List<StreetNameInfoDto> getAllStreetNamesInfoDtos();

    List<CityDto> getCitiesByCountry(int id);

    List<StreetDto> getStreetsByCity(int id);



}
