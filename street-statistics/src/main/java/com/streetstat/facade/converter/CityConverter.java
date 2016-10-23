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
        if (cityDTO == null) {
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
        Set<Street> streets = getStreet(cityDTO.getStreetDtos(), city);
        city.setStreets(streets);
        return city;
    }

    public CityDto convertToCityDto(City city) {
        if(city == null) {
            return null;
        }
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getName());
        cityDto.setPopulation(city.getPopulation());
        CountryDto countryDto = countryConverter.convertToCountryDto(city.getCountry());
        cityDto.setCountryDto(countryDto);
        Set<StreetDto> streetDtos = getStreetDtos(city.getStreets(), cityDto);
        cityDto.setStreetDtos(streetDtos);
        return cityDto;
    }

    private Set<StreetDto> getStreetDtos(Set<Street> streets, CityDto cityDto) {
        if (!Hibernate.isInitialized(streets)) {
            return null;
        }
        Set<StreetDto> streetDtos = new HashSet<StreetDto>();
        for (Street street : streets) {
            City city = street.getCity();
            street.setCity(null);
            StreetDto streetDto = streetConverter.convertToStreetDto(street);
            streetDto.setCityDto(cityDto);
            streetDtos.add(streetDto);
            street.setCity(city);
        }
        return streetDtos;
    }

    private Set<Street> getStreet(Set<StreetDto> streetDtos, City city) {
        if (streetDtos == null) {
            return null;
        }
        Set<Street> streets = new HashSet<Street>();
        if (streetDtos != null) {
            for (StreetDto streetDto : streetDtos) {
                streetDto.setCityDto(null);
                Street street = streetConverter.convertToStreet(streetDto);
                street.setCity(city);
                streets.add(street);
            }
        }
        return streets;
    }
}
