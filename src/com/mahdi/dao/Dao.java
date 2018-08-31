package com.mahdi.dao;

import com.mahdi.entity.Entity;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Dao<T extends Entity<I> ,I> implements Crud<T,I>{

    private static String url = "jdbc:mysql://localhost:3306/phonebook?user=root&password=";
    protected static Connection connection = null;

    public Dao() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url);

    }
}
