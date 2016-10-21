package com.streetstat.dao.impl;

import com.streetstat.dao.StreetNameInfoDao;
import com.streetstat.model.StreetNameInfo;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StreetNameInfoDaoImpl extends AbstractDaoImpl implements StreetNameInfoDao {

    protected StreetNameInfoDaoImpl() {
        super(StreetNameInfo.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StreetNameInfo> getStreetNameInfos(int page, int pageSize) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.setFirstResult(page * pageSize);
        criteria.setMaxResults(pageSize);
        criteria.addOrder(Order.asc("name"));
        return (List<StreetNameInfo>) criteria.list();

    }
}
