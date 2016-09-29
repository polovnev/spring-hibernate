package com.springapp.mvc.dao;



import java.util.List;


public interface AbstractDao<T> {
    public void saveOrUpdate(Object o);

    public void deleteById(int id);

    public T getById(int id);

    public List<T> getAll();
}
