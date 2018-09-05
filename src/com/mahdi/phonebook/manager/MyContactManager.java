package com.mahdi.phonebook.manager;

import com.mahdi.phonebook.dao.ContactDao;
import com.mahdi.phonebook.entity.ContactEntity;

import java.sql.SQLException;

public class MyContactManager {

    private ContactDao dao = new ContactDao();

    public MyContactManager() throws Exception {
    }

    public void create(ContactEntity contactEntity) throws SQLException {
        dao.create(contactEntity);
    }

    public ContactEntity read(Integer id) throws SQLException {
        return dao.read(id);
    }

}
