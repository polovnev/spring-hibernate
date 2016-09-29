package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.CountryDao;
import com.springapp.mvc.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CountryDaoImpl extends AbstractDaoImpl implements CountryDao {


    protected CountryDaoImpl() {
        super(Country.class);
    }




}
