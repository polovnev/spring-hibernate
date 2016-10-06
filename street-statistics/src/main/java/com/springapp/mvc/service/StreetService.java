package com.springapp.mvc.service;

import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;

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
