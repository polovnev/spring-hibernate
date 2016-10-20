package com.streetstat.converter;


import com.streetstat.dto.CityDto;
import com.streetstat.dto.StreetDto;
import com.streetstat.dto.StreetNameInfoDto;
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
        int id = streetDTO.getId();
        CityDto cityDto = streetDTO.getCityDto();
        StreetNameInfoDto streetNameInfoDto = streetDTO.getStreetNameInfoDto();
        int length = streetDTO.getLength();

        City city = cityConverter.convertToCity(cityDto);
        StreetNameInfo streetNameInfo = streetNameInfoConverter.convertToStreetNameInfo(streetNameInfoDto);
        Street result = new Street();
        result.setId(id);
        result.setCity(city);
        result.setStreetNameInfo(streetNameInfo);
        result.setLength(length);
        return result;
    }


    public StreetDto convertToStreetDto(Street street) {
        int id = street.getId();
        City city = street.getCity();
        StreetNameInfo streetNameInfo = street.getStreetNameInfo();
        int length = street.getLength();
        StreetDto result = new StreetDto();
        result.setId(id);
        city.setStreets(null);
        CityDto cityDto = cityConverter.convertToCityDto(city);
        result.setCityDto(cityDto);

        StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo);
        result.setStreetNameInfoDto(streetNameInfoDto);
        result.setLength(length);
        return result;
    }


}
