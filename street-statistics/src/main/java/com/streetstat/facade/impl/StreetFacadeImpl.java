package com.streetstat.facade.impl;


import com.streetstat.facade.StreetFacade;
import com.streetstat.facade.converter.StreetConverter;
import com.streetstat.facade.converter.StreetNameInfoConverter;
import com.streetstat.facade.dto.StreetDto;
import com.streetstat.facade.dto.StreetNameInfoDto;
import com.streetstat.model.Street;
import com.streetstat.model.StreetNameInfo;
import com.streetstat.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class StreetFacadeImpl implements StreetFacade {

    @Autowired
    private StreetService streetService;

    @Autowired
    private StreetConverter streetConverter;

    @Autowired
    private StreetNameInfoConverter streetNameInfoConverter;

    @Override
    public void saveStreet(StreetDto streetDto) {
        Street street = streetConverter.convertToStreet(streetDto);
        streetService.saveStreet(street);
    }

    @Override
    public StreetDto getStreetDtoById(long id) {
        Street street = streetService.getStreetById(id);
        return streetConverter.convertToStreetDto(street);
    }

    @Override
    public List<StreetDto> getStreetDtosByCity(long id) {
        Set<Street> streets = streetService.getStreetsByCity(id);
        List<StreetDto> streetDtos = new ArrayList<>(streets.size());
        for (Street street : streets) {
            streetDtos.add(streetConverter.convertToStreetDto(street));
        }
        return streetDtos;
     }

    @Override
    public void removeStreet(long id) {
        streetService.removeStreet(id);
    }

    @Override
    public void saveStreetNameInfoDto(StreetNameInfoDto streetNameInfoDto) {
        StreetNameInfo streetNameInfo = streetNameInfoConverter.convertToStreetNameInfo(streetNameInfoDto);
        streetService.saveStreetNameInfo(streetNameInfo);
    }

    @Override
    public StreetNameInfoDto getStreetNameInfoDtoById(long id) {
        StreetNameInfo streetNameInfo = streetService.getStreetNameInfoById(id);
        return streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo);
    }

    @Override
    public List<StreetNameInfoDto> getAllStreetNamesInfoDtos() {
        List<StreetNameInfo> streetNameInfos = streetService.getAllStreetNamesInfos();
        List<StreetNameInfoDto> streetNameInfoDtos = new ArrayList<>(streetNameInfos.size());
        for (StreetNameInfo streetNameInfo : streetNameInfos) {
            streetNameInfoDtos.add(streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo));
        }
        return streetNameInfoDtos;
   }

    @Override
    public void removeStreetNameInfo(long id) {
        streetService.removeStreetNameInfo(id);
    }
}
