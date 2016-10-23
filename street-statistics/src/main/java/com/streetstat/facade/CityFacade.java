package com.streetstat.facade;


import com.streetstat.facade.dto.CityDto;
import com.streetstat.model.City;

import java.util.List;
import java.util.Set;

public interface CityFacade {

    void saveCity(CityDto cityDto);

    CityDto getCityDtoById(long id);

    List<CityDto> getAllCityDtos();

    Set<CityDto> getCityDtosByCountry(long id);

    void removeCity(long id);

    CityDto showCityDtoThisSumLongestStreet(long countryId);

    CityDto showCityDtoThisBiggestPopulation(long countryId);

    CityDto showCityDtoThisSmallestPopulation(long countryId);
}
