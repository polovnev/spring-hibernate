package com.springapp.mvc.service.impl;

import com.springapp.mvc.converter.StreetConverter;
import com.springapp.mvc.converter.StreetNameInfoConverter;
import com.springapp.mvc.dao.StreetDao;
import com.springapp.mvc.dao.StreetNameInfoDao;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.model.Street;
import com.springapp.mvc.model.StreetNameInfo;
import com.springapp.mvc.service.StreetService;
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
    public StreetDto getStreetDtoById(int id) {
        Street street = (Street) streetDao.getById(id);
        StreetDto streetDto = streetConverter.convertToStreetDto(street);
        return streetDto;
    }

    @Override
    public List<StreetDto> getStreetsByCity(int id) {
        Set<Street> streets = streetDao.getStreetsForCityId(id);
        List<StreetDto> result = new ArrayList<StreetDto>(streets.size());
        for (Street street : streets) {
            StreetDto streetDto = streetConverter.convertToStreetDto(street);
            result.add(streetDto);
        }
        return result;
    }

    public void removeStreet(int id) {
        streetDao.deleteById(id);
    }

    @Override
    public void saveStreetNameInfo(StreetNameInfoDto streetNameInfoDto) {
        StreetNameInfo streetNameInfo = streetNameInfoConverter.convertToStreetNameInfo(streetNameInfoDto);
        streetNameInfoDao.saveOrUpdate(streetNameInfo);
    }

    @Override
    public StreetNameInfoDto getStreetNameInfoById(int id) {
        StreetNameInfo streetNameInfo = (StreetNameInfo) streetNameInfoDao.getById(id);
        StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo,true);
        return streetNameInfoDto;
    }

    @Override
    public List<StreetNameInfoDto> getAllStreetNamesInfoDtos() {
        List<StreetNameInfo> streetNamesInfo = streetNameInfoDao.getAll();
        List<StreetNameInfoDto> result = new ArrayList<StreetNameInfoDto>(streetNamesInfo.size());
        for (StreetNameInfo streetNameInfo : streetNamesInfo) {
            StreetNameInfoDto streetNameInfoDto = streetNameInfoConverter.convertToStreetNameInfoDto(streetNameInfo,false);
            result.add(streetNameInfoDto);
        }
        return result;
    }

    @Override
    public void removeStreetNameInfo(int id) {
        streetNameInfoDao.deleteById(id);
    }
}
