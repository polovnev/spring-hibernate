package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.StreetDAO;
import com.springapp.mvc.entity.City;
import com.springapp.mvc.entity.Country;
import com.springapp.mvc.entity.Street;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public class StreetDAOImpl extends AbstractDAOImpl implements StreetDAO {

    @Transactional
    @Override
    public Set<Street> getStreetsForCityId(int idCity) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(City.class);
        City city = (City) criteria.add(Expression.eq("id", idCity)).uniqueResult();
        return city.getStreets();

    }

    @Transactional
    @Override
    public void add(Street street) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Transactional
    @Override
    public void update(Street street) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
