package com.mahdi.phonebook.dao;

import com.mahdi.phonebook.entity.Entity;
import com.mahdi.phonebook.util.Constans;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public abstract class Dao<T extends Entity<I>, I> implements Crud<T, I> {

    private static String url = "jdbc:mysql://" + Constans.KEY_SERVER_NAME + ":" + Constans.KEY_SERVER_PORT + "/" + Constans.KEY_DB_NAME + "?user=" + Constans.KEY_DB_USERNAME + "&password=" + Constans.KEY_DB_PASSWORD;
    protected static Connection connection = null;

    private static final String ATTRIBUTE_NAME = "config";
    private Properties config = new Properties();

    public Dao() throws Exception {

        try {
            config.load(new FileInputStream("/home/mahdi/IdeaProjects/PhoneBook/web/WEB-INF/config.properties"));
        } catch (IOException err) {
            err.printStackTrace();
        }
        String property = config.getProperty("server");
        System.out.println("Log-------------" + property);

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(url);
    }

}
