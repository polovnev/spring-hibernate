package com.springapp.mvc.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAOImpl {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
