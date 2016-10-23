package com.streetstat.service.impl;

import com.streetstat.facade.converter.StreetConverter;
import com.streetstat.facade.converter.StreetNameInfoConverter;
import com.streetstat.dao.StreetDao;
import com.streetstat.dao.StreetNameInfoDao;
import com.streetstat.facade.dto.StreetDto;
import com.streetstat.facade.dto.StreetNameInfoDto;
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
    private StreetNameInfoDao streetNameInfoDao;


    @Override
    public void saveStreet(Street street) {
        streetDao.saveOrUpdate(street);
    }

    @Override
    public Street getStreetById(long id) {
        Street street = (Street) streetDao.findById(id, "");
        return street;
    }

    @Override
    public Set<Street> getStreetsByCity(long id) {
        return streetDao.getStreetsForCityId(id);
    }

    public void removeStreet(long id) {
        streetDao.deleteById(id);
    }

    @Override
    public void saveStreetNameInfo(StreetNameInfo streetNameInfo) {
        streetNameInfoDao.saveOrUpdate(streetNameInfo);
    }

    @Override
    public StreetNameInfo getStreetNameInfoById(long id) {
        return (StreetNameInfo) streetNameInfoDao.findById(id, "");
    }

    @Override
    public List<StreetNameInfo> getAllStreetNamesInfos() {
        return streetNameInfoDao.getStreetNameInfos(0, 100);
    }

    @Override
    public void removeStreetNameInfo(long id) {
        streetNameInfoDao.deleteById(id);
    }
}
