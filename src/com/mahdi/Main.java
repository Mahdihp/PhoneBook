package com.mahdi;

import com.mahdi.manager.ContactManager;

public class Main {

    ContactManager contactManager;

    {
        try {
            contactManager = new ContactManager();
//            contactManager.add();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
