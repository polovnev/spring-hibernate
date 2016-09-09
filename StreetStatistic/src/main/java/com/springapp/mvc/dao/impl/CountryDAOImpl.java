package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.CountryDAO;
import com.springapp.mvc.entity.Country;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class CountryDAOImpl extends AbstractDAOImpl implements CountryDAO {


    @Transactional
    @Override
    public List<Country> getAllCountry() {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Country.class);
        return criteria.list();
    }
}
