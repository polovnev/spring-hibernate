package com.streetstat.dao.impl;

import com.streetstat.dao.StreetDao;
import com.streetstat.dao.util.HibernateInitializer;
import com.streetstat.model.City;
import com.streetstat.model.Street;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
public class StreetDaoImpl extends AbstractDaoImpl implements StreetDao {


    protected StreetDaoImpl() {
        super(Street.class);
    }

    @Override
    public Set<Street> getStreetsForCityId(long idCity) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(City.class);
        City city = (City) criteria.add(Expression.eq("id", idCity)).uniqueResult();
        HibernateInitializer.initializeEntities(city,"streets");
        return city.getStreets();
    }





}
