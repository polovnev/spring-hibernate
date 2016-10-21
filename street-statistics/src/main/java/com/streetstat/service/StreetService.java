package com.streetstat.service;

import com.streetstat.dto.StreetDto;
import com.streetstat.dto.StreetNameInfoDto;
import com.streetstat.model.StreetNameInfo;

import java.util.List;


public interface StreetService {

    void saveStreet(StreetDto streetDto);

    StreetDto getStreetDtoById(long id);

    List<StreetDto> getStreetsByCity(long id);

    void removeStreet(long id);

    void saveStreetNameInfo(StreetNameInfoDto streetNameInfoDto);

    StreetNameInfoDto getStreetNameInfoDtoById(long id);

    StreetNameInfo getStreetNameInfoById(long id);

    List<StreetNameInfoDto> getAllStreetNamesInfoDtos();

    void removeStreetNameInfo(long id);

}
