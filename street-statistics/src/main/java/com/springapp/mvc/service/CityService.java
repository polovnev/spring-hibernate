package com.springapp.mvc.service;


import com.springapp.mvc.dto.CityDto;

import java.util.List;

public interface CityService {

    void saveCity(CityDto cityDto);

    CityDto getCityDtoById(int id);

    List<CityDto> getAllCityDtos();

    List<CityDto> getCitiesByCountry(int id);

    void removeCity(int id);
}
