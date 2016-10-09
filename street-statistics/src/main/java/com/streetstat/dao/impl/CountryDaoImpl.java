package com.streetstat.dao.impl;

import com.streetstat.dao.CountryDao;
import com.streetstat.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CountryDaoImpl extends AbstractDaoImpl implements CountryDao {


    protected CountryDaoImpl() {
        super(Country.class);
    }




}
