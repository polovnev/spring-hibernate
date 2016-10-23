package com.streetstat.facade.converter;

import com.streetstat.facade.dto.CityDto;
import com.streetstat.facade.dto.CountryDto;
import com.streetstat.facade.dto.StreetDto;
import com.streetstat.model.City;
import com.streetstat.model.Country;
import com.streetstat.model.Street;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CityConverter {

    @Autowired
    private CountryConverter countryConverter;

    @Autowired
    private StreetConverter streetConverter;

    public City convertToCity(CityDto cityDTO) {
        if(cityDTO == null) {
            return null;
        }
        CountryDto countryDto = cityDTO.getCountryDto();
        Country country = null;
        if (countryDto != null) {
            country = countryConverter.convertToCountry(countryDto);
        }
        City city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setCountry(country);
        city.setPopulation(cityDTO.getPopulation());
        Set<Street> streets = getStreet(cityDTO.getStreetDtos());
        city.setStreets(streets);
        return city;
    }

    public CityDto convertToCityDto(City city) {
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setPopulation(city.getPopulation());
        CountryDto countryDto = countryConverter.convertToCountryDto(city.getCountry());
        cityDto.setCountryDto(countryDto);
        Set<StreetDto> streetDtos = getStreetDtos(city.getStreets());
        cityDto.setStreetDtos(streetDtos);
        return cityDto;
    }

    private Set<StreetDto> getStreetDtos(Set<Street> streets) {
        Set<StreetDto> streetDtos = new HashSet<StreetDto>();
        if (streets != null && Hibernate.isInitialized(streets)) {
            for (Street street : streets) {
                StreetDto streetDto = streetConverter.convertToStreetDto(street);
                streetDtos.add(streetDto);
            }
        }
        return streetDtos;
    }

    private Set<Street> getStreet(Set<StreetDto> streetDtos) {
        Set<Street> streets = new HashSet<Street>();
        if (streetDtos != null) {
            for (StreetDto streetDto : streetDtos) {
                Street street = streetConverter.convertToStreet(streetDto);
                streets.add(street);
            }
        }
        return streets;
    }
}
