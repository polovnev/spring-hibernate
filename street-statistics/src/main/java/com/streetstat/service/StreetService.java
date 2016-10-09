package com.streetstat.service;

import com.streetstat.dto.StreetDto;
import com.streetstat.dto.StreetNameInfoDto;

import java.util.List;


public interface StreetService {

    void saveStreet(StreetDto streetDto);

    StreetDto getStreetDtoById(int id);

    List<StreetDto> getStreetsByCity(int id);

    void removeStreet(int id);

    void saveStreetNameInfo(StreetNameInfoDto streetNameInfoDto);

    StreetNameInfoDto getStreetNameInfoById(int id);

    List<StreetNameInfoDto> getAllStreetNamesInfoDtos();

    void removeStreetNameInfo(int id);

}
