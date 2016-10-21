package com.streetstat.service.impl;

import com.streetstat.converter.StreetConverter;
import com.streetstat.converter.StreetNameInfoConverter;
import com.streetstat.dao.StreetDao;
import com.streetstat.dao.StreetNameInfoDao;
import com.streetstat.dto.StreetDto;
import com.streetstat.dto.StreetNameInfoDto;
import com.streetstat.model.Street;
import com.streetstat.model.StreetNameInfo;
import com.streetstat.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StreetServiceImpl implements StreetService {

    @Autowired
    private StreetDao streetDao;

    @Autowired
    private StreetConverter streetConverter;

    @Autowired
    private StreetNameInfoDao streetNameInfoDao;

    @Autowired
    private StreetNameInfoConverter streetNameInfoConverter;

    @Override
    public void saveStreet(StreetDto streetDto) {
        Street street = streetConverter.convertToStreet(streetDto);
        streetDao.saveOrUpdate(street);
    }

    @Override
    public StreetDto getStreetDtoById(long id) {
        Street street = (Street) streetDao.findById(id,"");
        StreetDto streetDto = streetConverter.convertToStreetDto(street);
        return streetDto;
    }

    @Override
    public List<StreetDto> getStreetsByCity(long id) {
        Set<Street> streets = streetDao.getStreetsForCityId(id);
        List<StreetDto> result = new ArrayList<StreetDto>(streets.size());
        for (Street street : streets) {
            StreetDto streetDto = streetConverter.convertToStreetDto(street);
            result.add(streetDto);
        }
        return result;
    }

    public void removeStreet(long id) {
        streetDao.deleteById(id);
    }

    @Override
    public void saveStreetNameInfo(StreetNameInfoDto streetNameInfoDto) {
        StreetNameInfo streetNameInfo = streetNameInfoConverter.convertToStreetNameInfo(streetNameInfoDto);
        streetNameInfoDao.saveOrUpdate(streetNameInfo);
    }

    @Override
    public StreetNameInfoDto getStreetNameInfoDtoById(long id) {
        StreetNameInfo streetNameInfo = (StreetNameInfo) streetNameInfoDao.findById(id,"");
        StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo);
        return streetNameInfoDto;
    }

    @Override
    public StreetNameInfo getStreetNameInfoById(long id) {
        return (StreetNameInfo) streetNameInfoDao.findById(id,"");
    }

    @Override
    public List<StreetNameInfoDto> getAllStreetNamesInfoDtos() {
        List<StreetNameInfo> streetNamesInfo = streetNameInfoDao.getStreetNameInfos(0,100);
        List<StreetNameInfoDto> result = new ArrayList<StreetNameInfoDto>(streetNamesInfo.size());
        for (StreetNameInfo streetNameInfo : streetNamesInfo) {
            StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo);
            result.add(streetNameInfoDto);
        }
        return result;
    }

    @Override
    public void removeStreetNameInfo(long id) {
        streetNameInfoDao.deleteById(id);
    }
}
