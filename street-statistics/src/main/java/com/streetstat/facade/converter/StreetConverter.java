package com.streetstat.facade.converter;


import com.streetstat.facade.dto.CityDto;
import com.streetstat.facade.dto.StreetDto;
import com.streetstat.facade.dto.StreetNameInfoDto;
import com.streetstat.model.City;
import com.streetstat.model.Street;
import com.streetstat.model.StreetNameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StreetConverter {

    @Autowired
    private CityConverter cityConverter;

    @Autowired
    private StreetNameInfoConverter streetNameInfoConverter;

    public Street convertToStreet(StreetDto streetDTO) {
        if(streetDTO == null) {
            return null;
        }
        Street street = new Street();
        street.setId(streetDTO.getId());
        City city = cityConverter.convertToCity(streetDTO.getCityDto());
        street.setCity(city);
        StreetNameInfo streetNameInfo = streetNameInfoConverter.convertToStreetNameInfo(streetDTO.getStreetNameInfoDto());
        street.setStreetNameInfo(streetNameInfo);
        street.setLength(streetDTO.getLength());
        return street;
    }

    public StreetDto convertToStreetDto(Street street) {
        if(street == null) {
            return null;
        }
        StreetDto streetDto = new StreetDto();
        streetDto.setId(street.getId());
        CityDto cityDto = cityConverter.convertToCityDto(street.getCity());
        streetDto.setCityDto(cityDto);
        StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(street.getStreetNameInfo());
        streetDto.setStreetNameInfoDto(streetNameInfoDto);
        streetDto.setLength(street.getLength());
        return streetDto;
    }
}
