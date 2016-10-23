package com.streetstat.dao;

public interface Dao<T> {

    T findById(Long id, String... properties);

    void saveOrUpdate(T entity);

    void delete(T entity);

    void deleteById(Long id);

    T merge(T entity);

    Long add(T entity);

}
