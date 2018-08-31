package com.mahdi.manager;

import com.mahdi.dao.Dao;
import com.mahdi.entity.Contact;
import com.mahdi.entity.Entity;

import java.sql.SQLException;

public abstract class Manager<T extends Entity<I>, I> {

    protected Dao<T, I> dao;

    public void add(T entity) throws SQLException {
        dao.create(entity);
    }

    public T read(I id) throws SQLException {
        return dao.read(id);
    }
}
