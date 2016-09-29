package com.springapp.mvc.service.impl;


import com.springapp.mvc.dao.CityDao;
import com.springapp.mvc.dao.CountryDao;
import com.springapp.mvc.dao.StreetDao;
import com.springapp.mvc.dao.StreetNameInfoDao;
import com.springapp.mvc.service.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RemoveServiceImpl implements RemoveService{

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private StreetNameInfoDao streetNameInfoDao;

    @Autowired
    private StreetDao streetDao;

    public void removeCountry(int id) {
        countryDao.deleteById(id);
    }

    public void removeCity(int id) {
        cityDao.deleteById(id);
    }

    public void removeStreet(int id) {
        streetDao.deleteById(id);
    }

    public void removeStreetName(int id) {
        streetNameInfoDao.deleteById(id);
    }

/*    public City showCityThisSumLongestStreet(int idCountry) {
        return complexQueryDAO.showCityThisSumLongestStreet(idCountry);
    }
    */

}
