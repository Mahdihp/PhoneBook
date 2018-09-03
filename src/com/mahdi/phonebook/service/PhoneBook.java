package com.mahdi.phonebook.service;


import com.mahdi.phonebook.entity.Contact;
import com.mahdi.phonebook.entity.MessageBody;
import com.mahdi.phonebook.manager.ContactManager;
import com.mahdi.phonebook.util.Constans;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/" + Constans.KEY_RESOURCE)
public class PhoneBook {

    ContactManager contactManager;

    public PhoneBook() {
        try {
            this.contactManager = new ContactManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @POST
    @Path("/" + Constans.KEY_RESOURCE_ADD)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MessageBody add(Contact contact) {
        try {
            contactManager.add(contact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MessageBody(200, "Insert Contact Success.");
    }

    @GET
    @Path("/" + Constans.KEY_RESOURCE_CONTACTS)
    @Produces(MediaType.APPLICATION_JSON)
    public MessageBody readAll() {
        try {
            return new MessageBody(200, "Insert Contact Success.", contactManager.readAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @POST
    @Path("/" + Constans.KEY_RESOURCE_UPDATE)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MessageBody update(Contact contact) {
        try {
            contactManager.update(contact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MessageBody(200, "Update Contact Success.");

    }

    @POST
    @Path("/" + Constans.KEY_RESOURCE_DELETE + "/{" + Constans.KEY_RESOURCE_PARAMS + "}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageBody delete(@PathParam(Constans.KEY_RESOURCE_PARAMS) Integer id) {
        try {
            contactManager.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MessageBody(200, "Delete Contact Success.");

    }

    @GET
    @Path("/" + Constans.KEY_RESOURCE_CONTACT)
    @Produces(MediaType.APPLICATION_JSON)
    public MessageBody findById(@QueryParam("id") String id) {
        try {
            int contactId = Integer.valueOf(id);
            return new MessageBody(200, "Info Contact.",
                    contactManager.read(contactId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
