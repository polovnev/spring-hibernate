package com.streetstat.dao.impl;

import com.streetstat.dao.Dao;
import com.streetstat.dao.util.HibernateInitializer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public abstract class AbstractDaoImpl<T> implements Dao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public AbstractDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public T findById(Long id, String... properties) {
        T entity = (T) getSession().get(getPersistentClass(), id);
        HibernateInitializer.initializeEntities(entity, properties);
        return entity;
    }

    @Override
    @Transactional
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Session session = getSession();
        Object obj = session.get(getPersistentClass(), id);
        if (obj != null) {
            session.delete(obj);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T merge(T entity) {
        return (T) getSession().merge(entity);
    }

    @Override
    public Long add(T entity) {
        return (Long) getSession().save(entity);
    }

}
