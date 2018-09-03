package com.mahdi.phonebook.dao;

import com.mahdi.phonebook.entity.Entity;
import com.mahdi.phonebook.util.Constans;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class Dao<T extends Entity<I>, I> implements Crud<T, I> {

    private static String url = "jdbc:mysql://" + Constans.KEY_SERVER_NAME + ":" + Constans.KEY_SERVER_PORT + "/" + Constans.KEY_DB_NAME + "?user=" + Constans.KEY_DB_USERNAME + "&password=" + Constans.KEY_DB_PASSWORD;
    protected static Connection connection = null;

    public Dao() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url);
    }

}
