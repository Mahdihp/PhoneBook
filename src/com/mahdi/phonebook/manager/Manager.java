package com.mahdi.phonebook.manager;

import com.mahdi.phonebook.dao.Dao;
import com.mahdi.phonebook.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public abstract class Manager<T extends Entity<I>, I> {

    protected Dao<T, I> dao;

    public void add(T entity) throws SQLException {
        dao.create(entity);
    }

    public T read(I id) throws SQLException {
        return dao.read(id);
    }

    public void update(T entity) throws SQLException {
        dao.update(entity);
    }

    public void delete(I id) throws SQLException {
        dao.delete(id);
    }

    public List<T> readAll() throws SQLException {
        return dao.readAll();
    }

    public void clear() throws SQLException {
        dao.clear();
    }
}
