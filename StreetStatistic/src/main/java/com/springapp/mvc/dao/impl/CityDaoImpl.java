package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.CityDao;
import com.springapp.mvc.entity.City;
import com.springapp.mvc.entity.Country;
import com.springapp.mvc.entity.Street;
import com.springapp.mvc.entity.StreetName;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class CityDaoImpl extends AbstractDAOImpl implements CityDao {

    @Transactional
    @Override
    public Set<City> getAllCityForCountry(int idCountry) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Country.class);
        Country country = (Country) criteria.add(Expression.eq("id", idCountry)).uniqueResult();
        return country.getCitys();
    }

    @Transactional
    @Override
    public List<City> getAllCityByStreetName(int idStreetName) {
        List<City> result = new ArrayList<City>();
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(StreetName.class);
        StreetName streetName = (StreetName) criteria.add(Expression.eq("id", idStreetName)).uniqueResult();
        Set<Street> streets = streetName.getStreets();

        for (Street street : streets) {
            result.add(street.getCity());
        }
        return result;
    }


}
