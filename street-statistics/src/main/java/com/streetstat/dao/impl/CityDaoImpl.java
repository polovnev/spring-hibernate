package com.streetstat.dao.impl;

import com.streetstat.dao.CityDao;
import com.streetstat.model.City;
import com.streetstat.model.Country;
import com.streetstat.model.Street;
import com.streetstat.model.StreetNameInfo;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class CityDaoImpl extends AbstractDaoImpl implements CityDao {

    protected CityDaoImpl() {
        super(City.class);
    }

    @Override
    public Set<City> getAllCityForCountry(int idCountry) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Country.class);
        Country country = (Country) criteria.add(Expression.eq("id", idCountry)).uniqueResult();
        Hibernate.initialize(country.getCities());
        return country.getCities();
    }

    @Override
    public List<City> getAllCityByStreetName(int idStreetName) {
        Session session = getSession();
        List<City> result = new ArrayList<City>();
        Criteria criteria = session.createCriteria(StreetNameInfo.class);
        StreetNameInfo streetName = (StreetNameInfo) criteria.add(Expression.eq("id", idStreetName)).uniqueResult();
        Set<Street> streets = streetName.getStreets();

        for (Street street : streets) {
            result.add(street.getCity());
        }
        return result;
    }

    @Override
    public City showCityThisSumLongestStreet(int countryId) {
        String hql = "SELECT S.city FROM Street S WHERE S.city.country.id = :countryId GROUP BY S.city ORDER BY sum(S.length) DESC";
        Query query = getSession().createQuery(hql);
        query.setParameter("countryId", countryId);
        List<City> list = query.list();
        return list.get(0);
    }

    @Override
    public City showCityThisBiggerstPopulation(int countryId) {
        String hql = "SELECT C FROM City C WHERE C.country.id = :countryId ORDER BY C.population DESC";
        Query query = getSession().createQuery(hql);
        query.setParameter("countryId", countryId);
        List<City> list = query.list();
        return list.get(0);
    }

    @Override
    public City showCityThisSmallestPopulation(int countryId) {
        String hql = "SELECT C FROM City C WHERE C.country.id = :countryId ORDER BY C.population";
        Query query = getSession().createQuery(hql);
        query.setParameter("countryId", countryId);
        List<City> list = query.list();
        return list.get(0);
    }




}