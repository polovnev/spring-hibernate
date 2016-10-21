package com.streetstat.dao.impl;

import com.streetstat.dao.CountryDao;
import com.streetstat.model.Country;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CountryDaoImpl extends AbstractDaoImpl implements CountryDao {


    protected CountryDaoImpl() {
        super(Country.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Country> getCountries(int page, int pageSize) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.setFirstResult(page * pageSize);
        criteria.setMaxResults(pageSize);
        criteria.addOrder(Order.asc("name"));
        return (List<Country>) criteria.list();
    }





}
