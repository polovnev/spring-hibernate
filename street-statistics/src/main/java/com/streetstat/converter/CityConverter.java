package com.streetstat.converter;

import com.streetstat.dao.CountryDao;
import com.streetstat.dto.CityDto;
import com.streetstat.dto.StreetDto;
import com.streetstat.model.City;
import com.streetstat.model.Country;
import com.streetstat.model.Street;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CityConverter {

    @Autowired
    private CountryDao countryDAO;

    @Autowired
    private StreetConverter streetConverter;

    public City convertToCity(CityDto cityDTO) {
        int id = cityDTO.getId();
        String name = cityDTO.getName();
        int countryId = cityDTO.getCountry();
        int population = cityDTO.getPopulation();
        Country country = (Country) countryDAO.getById(countryId);
        Set<StreetDto> streetDtos = cityDTO.getStreetDtos();

        City result = new City();
        result.setId(id);
        result.setName(name);
        result.setCountry(country);
        result.setPopulation(population);

        Set<Street> streets = streetConverter.convertToSetStreet(streetDtos);
        result.setStreets(streets);
        return result;
    }


    public CityDto convertToCityDto(City city) {
        int id = city.getId();
        String name = city.getName();
        int countryId = city.getCountry().getId();
        int population = city.getPopulation();
        Set<Street> streets = city.getStreets();

        CityDto result = new CityDto();
        result.setId(id);
        result.setName(name);
        result.setPopulation(population);
        result.setCountry(countryId);

        if (streets != null) {
            Set<StreetDto> streetDtos = streetConverter.convertToSetStreetDtos(streets);
            result.setStreetDtos(streetDtos);
        }
        return result;
    }

    Set<CityDto> convertSetToCityDto(Set<City> cities) {
        Set<CityDto> result = new HashSet<CityDto>();
        try {
            for (City city : cities) {
                CityDto cityDto = convertToCityDto(city);
                result.add(cityDto);
            }
        } catch (LazyInitializationException e) {
        }
        return result;
    }

    Set<City> convertSetToCity(Set<CityDto> cities) {
        if(cities == null)
            return null;
        Set<City> result = new HashSet<City>();
        for (CityDto cityDto : cities) {
            City city = convertToCity(cityDto) ;
            result.add(city);
        }
        return result;
    }
}
