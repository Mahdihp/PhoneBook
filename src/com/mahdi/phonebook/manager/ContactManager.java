package com.mahdi.phonebook.manager;

import com.mahdi.phonebook.dao.ContactDao;
import com.mahdi.phonebook.entity.Contact;

public class ContactManager extends Manager<Contact, Integer> {

    public ContactManager() throws Exception {
        dao = new ContactDao();
    }


}
