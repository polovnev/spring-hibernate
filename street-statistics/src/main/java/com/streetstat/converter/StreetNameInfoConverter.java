package com.streetstat.converter;


import com.streetstat.dto.StreetNameInfoDto;
import com.streetstat.model.StreetNameInfo;
import org.springframework.stereotype.Component;

@Component
public class StreetNameInfoConverter {

    public StreetNameInfo convertToStreetNameInfo(StreetNameInfoDto streetNameDTO) {
        long id = streetNameDTO.getId();
        String name = streetNameDTO.getName();
        int isPerson = (streetNameDTO.isPerson()) ? 1 : 0;
        String description = streetNameDTO.getDescription();
        StreetNameInfo result = new StreetNameInfo();
        result.setId(id);
        result.setName(name);
        result.setPerson(isPerson);
        result.setDescription(description);
        return result;
    }

    public StreetNameInfoDto convertToStreetNameInfoDto(StreetNameInfo streetName) {
        long id = streetName.getId();
        String name = streetName.getName();
        StreetNameInfoDto result = new StreetNameInfoDto();
        String description = streetName.getDescription();
        boolean isPerson = streetName.getPerson() == 1;
        result.setId(id);
        result.setName(name);
        result.setDescription(description);
        result.setPerson(isPerson);
        return result;
    }
}
