package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.ComplexQueryDao;
import com.springapp.mvc.model.City;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ComplexQueryDaoImpl extends AbstractDaoImpl implements ComplexQueryDao {


    protected ComplexQueryDaoImpl() {
        super(null);
    }

    @Override
    public City showCityThisSumLongestStreet(int countryId) {
        String hql = "SELECT S.city FROM Street S WHERE S.city.country.id = :countryId GROUP BY S.city ORDER BY sum(S.length) DESC";
        Query query = getSession().createQuery(hql);
        query.setParameter("countryId", countryId);
        List<City> list = query.list();
        return list.get(0);
    }

}