package com.mahdi.phonebook.manager;

import com.mahdi.phonebook.dao.ContactDao;
import com.mahdi.phonebook.entity.ContactEntity;

public class ContactManager extends Manager<ContactEntity, Integer> {

    public ContactManager() throws Exception {
        dao = new ContactDao();
    }


}
