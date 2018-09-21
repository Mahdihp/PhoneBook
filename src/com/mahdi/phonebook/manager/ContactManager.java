package com.mahdi.phonebook.manager;

import com.mahdi.phonebook.dao.ContactDao;
import com.mahdi.phonebook.entity.ContactEntity;
import com.mahdi.phonebook.util.Constans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactManager extends Manager<ContactEntity, Integer> {

    public ContactManager() throws Exception {
        dao = new ContactDao();
    }
    public List<ContactEntity> findByName(String name) throws SQLException{
       return  ((ContactDao) dao).findByName(name);
    }



}
