package com.streetstat.dao.impl;

import com.streetstat.dao.StreetNameInfoDao;
import com.streetstat.model.StreetNameInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StreetNameInfoDaoImpl extends AbstractDaoImpl implements StreetNameInfoDao {

    protected StreetNameInfoDaoImpl() {
        super(StreetNameInfo.class);
    }
}
