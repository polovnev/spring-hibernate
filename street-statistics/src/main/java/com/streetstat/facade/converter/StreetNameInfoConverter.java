package com.streetstat.facade.converter;


import com.streetstat.facade.dto.StreetNameInfoDto;
import com.streetstat.model.StreetNameInfo;
import org.springframework.stereotype.Component;

@Component
public class StreetNameInfoConverter {

    public StreetNameInfo convertToStreetNameInfo(StreetNameInfoDto streetNameDTO) {
        if(streetNameDTO == null) {
            return null;
        }
        StreetNameInfo streetNameInfo = new StreetNameInfo();
        streetNameInfo.setId(streetNameDTO.getId());
        streetNameInfo.setName(streetNameDTO.getName());
        streetNameInfo.setPerson(streetNameDTO.isPerson());
        streetNameInfo.setDescription(streetNameDTO.getDescription());
        return streetNameInfo;
    }

    public StreetNameInfoDto convertToStreetNameInfoDto(StreetNameInfo streetName) {
        if(streetName == null) {
            return null;
        }
        StreetNameInfoDto streetNameInfoDto = new StreetNameInfoDto();
        streetNameInfoDto.setId(streetName.getId());
        streetNameInfoDto.setName(streetName.getName());
        streetNameInfoDto.setDescription(streetName.getDescription());
        streetNameInfoDto.setPerson(streetName.getPerson());
        return streetNameInfoDto;
    }
}
