package com.mahdi;

import com.mahdi.manager.ContactManager;

public class Main {

    public static void main(String[] args) {
        ContactManager contactManager;

        {
            try {
                contactManager = new ContactManager();
                System.out.println(contactManager.readAll());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
