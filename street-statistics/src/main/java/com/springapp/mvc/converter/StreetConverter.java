package com.springapp.mvc.converter;


import com.springapp.mvc.dao.CityDao;
import com.springapp.mvc.dao.StreetNameInfoDao;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.model.City;
import com.springapp.mvc.model.Street;
import com.springapp.mvc.model.StreetNameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StreetConverter {

    @Autowired
    private CityDao cityDAO;

    @Autowired
    private StreetNameInfoDao streetNameDAO;

    public Street convertToStreet(StreetDto streetDTO){
        int id = streetDTO.getId();
        int cityId = streetDTO.getCityId();
        int streetNameId = streetDTO.getStreetNameId();
        int length = streetDTO.getLength();

        City city = (City)cityDAO.getById(cityId);
        StreetNameInfo streetNameInfo = (StreetNameInfo)streetNameDAO.getById(streetNameId);
        Street result = new Street();
        result.setId(id);
        result.setCity(city);
        result.setStreetName(streetNameInfo);
        result.setLength(length);
        return result;
    }


    public StreetDto convertToStreetDto(Street street){
        int id = street.getId();
        int cityId = street.getCity().getId();
        int streetNameId = street.getStreetName().getId();
        int length = street.getLength();
        StreetDto result = new StreetDto();
        result.setId(id);
        result.setCityId(cityId);
        result.setStreetNameId(streetNameId);
        result.setLength(length);
        return result;
    }
}
