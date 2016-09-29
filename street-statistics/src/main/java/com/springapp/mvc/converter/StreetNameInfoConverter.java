package com.springapp.mvc.converter;


import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.model.StreetNameInfo;
import org.springframework.stereotype.Component;

@Component
public class StreetNameInfoConverter {

    public StreetNameInfo convertToStreetNameInfo(StreetNameInfoDto streetNameDTO) {
        int id = streetNameDTO.getId();
        String name = streetNameDTO.getName();
        int isPerson = (streetNameDTO.isPerson()) ? 1 : 0;
        String description = streetNameDTO.getDescription();
        return new StreetNameInfo(id, name, isPerson, description);
    }

    public StreetNameInfoDto convertToStreetNameInfoDto(StreetNameInfo streetName, boolean isFullInfo) {
        int id = streetName.getId();
        String name = streetName.getName();
        if (isFullInfo) {
            String description = streetName.getDescription();
            boolean isPerson = streetName.getPerson() == 1;
            return new StreetNameInfoDto(id, name, isPerson, description);
        }
        return new StreetNameInfoDto(id, name);
    }
}
