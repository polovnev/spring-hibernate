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
        StreetNameInfo streetName = (StreetNameInfo)streetNameDAO.getById(streetNameId);

        return new Street(id,city,streetName,length);
    }


    public StreetDto convertToStreetDto(Street street){
        int id = street.getId();
        int cityId = street.getCity().getId();
        int streetNameId = street.getStreetName().getId();
        int length = street.getLength();

        return new StreetDto(id,cityId,streetNameId,length);
    }
}
