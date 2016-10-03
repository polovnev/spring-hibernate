package com.springapp.mvc.service.impl;

import com.springapp.mvc.converter.StreetConverter;
import com.springapp.mvc.dao.StreetDao;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.model.Street;
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
}
