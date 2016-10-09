package com.streetstat.converter;


import com.streetstat.dto.StreetNameInfoDto;
import com.streetstat.model.StreetNameInfo;
import org.springframework.stereotype.Component;

@Component
public class StreetNameInfoConverter {

    public StreetNameInfo convertToStreetNameInfo(StreetNameInfoDto streetNameDTO) {
        int id = streetNameDTO.getId();
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

    public StreetNameInfoDto convertToStreetNameInfoDto(StreetNameInfo streetName, boolean isFullInfo) {
        int id = streetName.getId();
        String name = streetName.getName();
        StreetNameInfoDto result = new StreetNameInfoDto();
        result.setId(id);
        result.setName(name);
        if (isFullInfo) {
            String description = streetName.getDescription();
            boolean isPerson = streetName.getPerson() == 1;
            result.setDescription(description);
            result.setPerson(isPerson);
            return result;
        }
        return result;
    }
}
