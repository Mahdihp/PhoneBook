package com.mahdi.manager;

import com.mahdi.dao.ContactDao;
import com.mahdi.entity.Contact;

import java.sql.SQLException;

public class ContactManager extends Manager<Contact, Integer> {

    public ContactManager() throws Exception {
        dao = new ContactDao();
    }



}
