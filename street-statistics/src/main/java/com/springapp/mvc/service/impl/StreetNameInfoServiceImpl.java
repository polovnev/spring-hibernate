package com.springapp.mvc.service.impl;

import com.springapp.mvc.converter.StreetNameInfoConverter;
import com.springapp.mvc.dao.StreetNameInfoDao;
import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.model.StreetNameInfo;
import com.springapp.mvc.service.StreetNameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreetNameInfoServiceImpl implements StreetNameInfoService {

    @Autowired
    private StreetNameInfoDao streetNameInfoDao;

    @Autowired
    private StreetNameInfoConverter streetNameInfoConverter;

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
    public void removeStreetName(int id) {
        streetNameInfoDao.deleteById(id);
    }

}
