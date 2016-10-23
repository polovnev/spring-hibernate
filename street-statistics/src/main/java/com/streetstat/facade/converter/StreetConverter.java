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
        City city = cityConverter.convertToCity(streetDTO.getCityDto());
        StreetNameInfo streetNameInfo = streetNameInfoConverter.convertToStreetNameInfo(streetDTO.getStreetNameInfoDto());
        Street street = new Street();
        street.setId(streetDTO.getId());
        street.setCity(city);
        street.setStreetNameInfo(streetNameInfo);
        street.setLength(streetDTO.getLength());
        return street;
    }

    public StreetDto convertToStreetDto(Street street) {
        StreetNameInfo streetNameInfo = street.getStreetNameInfo();
        StreetDto streetDto = new StreetDto();
        streetDto.setId(street.getId());
        CityDto cityDto = cityConverter.convertToCityDto(street.getCity());
        streetDto.setCityDto(cityDto);
        StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo);
        streetDto.setStreetNameInfoDto(streetNameInfoDto);
        streetDto.setLength(street.getLength());
        return streetDto;
    }
}
