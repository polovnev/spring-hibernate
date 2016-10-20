package com.streetstat.converter;

import com.streetstat.dto.CityDto;
import com.streetstat.dto.CountryDto;
import com.streetstat.dto.StreetDto;
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
        int id = cityDTO.getId();
        String name = cityDTO.getName();
        int population = cityDTO.getPopulation();

        CountryDto countryDto = cityDTO.getCountryDto();
        Country country = null;
        if (countryDto != null) {
             countryConverter.convertToCountry(countryDto);
        }
        Set<StreetDto> streetDtos = cityDTO.getStreetDtos();

        City result = new City();
        result.setId(id);
        result.setName(name);
        result.setCountry(country);
        result.setPopulation(population);

        Set<Street> streets = getSetStreet(streetDtos);
        result.setStreets(streets);
        return result;
    }


    public CityDto convertToCityDto(City city) {
        int id = city.getId();
        String name = city.getName();
        Country country = city.getCountry();
        country.setCities(null);
        int population = city.getPopulation();
        Set<Street> streets = city.getStreets();

        CityDto result = new CityDto();
        result.setId(id);
        result.setName(name);
        result.setPopulation(population);

        CountryDto countryDto = countryConverter.convertToCountryDto(country);
        result.setCountryDto(countryDto);

        Set<StreetDto> streetDtos = getSetStreetDtos(streets);
        result.setStreetDtos(streetDtos);

        return result;
    }


    private Set<StreetDto> getSetStreetDtos(Set<Street> streets) {
        Set<StreetDto> result = new HashSet<StreetDto>();
        if (streets != null && Hibernate.isInitialized(streets)) {
            for (Street street : streets) {
                StreetDto streetDto = streetConverter.convertToStreetDto(street);
                result.add(streetDto);
            }
        }
        return result;
    }

    private Set<Street> getSetStreet(Set<StreetDto> streets) {
        Set<Street> result = new HashSet<Street>();
        if (streets != null) {
            for (StreetDto streetDto : streets) {
                Street street = streetConverter.convertToStreet(streetDto);
                result.add(street);
            }
        }
        return result;
    }

}
