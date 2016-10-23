package com.streetstat.facade;


import com.streetstat.facade.dto.StreetDto;
import com.streetstat.facade.dto.StreetNameInfoDto;
import com.streetstat.model.Street;
import com.streetstat.model.StreetNameInfo;

import java.util.List;

public interface StreetFacade {

    void saveStreet(StreetDto streetDto);

    StreetDto getStreetDtoById(long id);

    List<StreetDto> getStreetDtosByCity(long id);

    void removeStreet(long id);

    void saveStreetNameInfoDto(StreetNameInfoDto streetNameInfoDto);

    StreetNameInfoDto getStreetNameInfoDtoById(long id);

    List<StreetNameInfoDto> getAllStreetNamesInfoDtos();

    void removeStreetNameInfo(long id);
}
