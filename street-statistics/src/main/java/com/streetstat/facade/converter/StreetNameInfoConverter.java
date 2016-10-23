package com.streetstat.facade.converter;


import com.streetstat.facade.dto.StreetNameInfoDto;
import com.streetstat.model.StreetNameInfo;
import org.springframework.stereotype.Component;

@Component
public class StreetNameInfoConverter {

    public StreetNameInfo convertToStreetNameInfo(StreetNameInfoDto streetNameDTO) {
        StreetNameInfo streetNameInfo = new StreetNameInfo();
        streetNameInfo.setId(streetNameDTO.getId());
        streetNameInfo.setName(streetNameDTO.getName());
        int isPerson = (streetNameDTO.isPerson()) ? 1 : 0;
        streetNameInfo.setPerson(isPerson);
        streetNameInfo.setDescription(streetNameDTO.getDescription());
        return streetNameInfo;
    }

    public StreetNameInfoDto convertToStreetNameInfoDto(StreetNameInfo streetName) {
        StreetNameInfoDto streetNameInfoDto = new StreetNameInfoDto();
        boolean isPerson = streetName.getPerson() == 1;
        streetNameInfoDto.setId(streetName.getId());
        streetNameInfoDto.setName(streetName.getName());
        streetNameInfoDto.setDescription(streetName.getDescription());
        streetNameInfoDto.setPerson(isPerson);
        return streetNameInfoDto;
    }
}
