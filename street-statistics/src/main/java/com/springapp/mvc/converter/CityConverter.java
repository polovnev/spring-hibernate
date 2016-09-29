package com.springapp.mvc.converter;

import com.springapp.mvc.dao.CountryDao;
import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.model.City;
import com.springapp.mvc.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityConverter {

    @Autowired
    private CountryDao countryDAO;

    public City convertToCity(CityDto cityDTO) {
        int id = cityDTO.getId();
        String name = cityDTO.getName();
        int countryId = cityDTO.getCountry();
        int population = cityDTO.getPopulation();
        Country country = (Country) countryDAO.getById(countryId);
        City city = new City(id, name, country, population);
        return city;
    }

    public CityDto convertToCityDto(City city, boolean isFullInfo) {
        int id = city.getId();
        String name = city.getName();
        if(isFullInfo) {
            int countryId = city.getCountry().getId();
            int population = city.getPopulation();
            return new CityDto(id,name,countryId, population);
        }
        return new CityDto(id,name);
    }
}
