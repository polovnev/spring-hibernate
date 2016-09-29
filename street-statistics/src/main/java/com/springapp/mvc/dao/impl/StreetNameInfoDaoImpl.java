package com.springapp.mvc.dao.impl;

import com.springapp.mvc.dao.StreetNameInfoDao;
import com.springapp.mvc.model.StreetNameInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StreetNameInfoDaoImpl extends AbstractDaoImpl implements StreetNameInfoDao {

    protected StreetNameInfoDaoImpl() {
        super(StreetNameInfo.class);
    }
}
