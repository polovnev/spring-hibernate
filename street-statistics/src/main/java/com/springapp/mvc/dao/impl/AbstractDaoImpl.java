package com.springapp.mvc.dao.impl;


import com.springapp.mvc.dao.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
abstract class AbstractDaoImpl<T> implements AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> persistentClass;

    protected AbstractDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Transactional
    @Override
    public void saveOrUpdate(Object o) {
        getSession().saveOrUpdate(o);
    }


    @Transactional
    @Override
    public void deleteById(int id) {
        T removeObject = getById(id);
        getSession().delete(removeObject);

    }

    @Transactional
    @Override
    public T getById(int id) {
        T objectFromDB = (T) getSession().load(persistentClass, id);
        Hibernate.initialize(objectFromDB);
        return objectFromDB;
    }

    @Transactional
    @Override
    public List<T> getAll() {
        Session session = getSession();
        Criteria criteria = session.createCriteria(persistentClass);
        List<T> list = (List<T>) criteria.list();
        return list;
    }
}
