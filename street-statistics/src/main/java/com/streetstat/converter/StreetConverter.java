package com.streetstat.converter;


import com.streetstat.dao.CityDao;
import com.streetstat.dao.StreetNameInfoDao;
import com.streetstat.dto.StreetDto;
import com.streetstat.model.City;
import com.streetstat.model.Street;
import com.streetstat.model.StreetNameInfo;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StreetConverter {

    @Autowired
    private CityDao cityDAO;

    @Autowired
    private StreetNameInfoDao streetNameDAO;

    public Street convertToStreet(StreetDto streetDTO) {
        int id = streetDTO.getId();
        int cityId = streetDTO.getCityId();
        int streetNameId = streetDTO.getStreetNameId();
        int length = streetDTO.getLength();

        City city = (City) cityDAO.getById(cityId);
        StreetNameInfo streetNameInfo = (StreetNameInfo) streetNameDAO.getById(streetNameId);
        Street result = new Street();
        result.setId(id);
        result.setCity(city);
        result.setStreetName(streetNameInfo);
        result.setLength(length);
        return result;
    }


    public StreetDto convertToStreetDto(Street street) {
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

    Set<StreetDto> convertToSetStreetDtos(Set<Street> streets) {
        Set<StreetDto> result = new HashSet<StreetDto>();
        try {
            for (Street street : streets) {
                StreetDto streetDto = convertToStreetDto(street);
                result.add(streetDto);
            }
        } catch (LazyInitializationException e) {
        }
        return result;
    }

    Set<Street> convertToSetStreet(Set<StreetDto> streets) {
        if(streets == null)
            return null;
        Set<Street> result = new HashSet<Street>();
            for (StreetDto streetDto : streets) {
                Street street = convertToStreet(streetDto);
                result.add(street);
            }
        return result;
    }
}
