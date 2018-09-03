package com.mahdi.phonebook.entity;

import com.google.gson.Gson;
import com.sun.istack.internal.Nullable;

import java.util.List;

public class MessageBody {

    private int statusCode;
    private String message;
    private List<Contact> data;
    private Contact contactData;
    public MessageBody() {
    }

    public MessageBody(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public MessageBody(int statusCode, String message, List<Contact> data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public MessageBody(int statusCode, String message, Contact contactData) {
        this.statusCode = statusCode;
        this.message = message;
        this.contactData = contactData;
    }

    public String toJson(){
        Gson gson=new Gson();
        return gson.toJson(this);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Contact> getData() {
        return data;
    }

    public void setData(List<Contact> data) {
        this.data = data;
    }

    public Contact getContactData() {
        return contactData;
    }

    public void setContactData(Contact contactData) {
        this.contactData = contactData;
    }

    @Override
    public String toString() {
        return "MessageBody{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", contactData=" + contactData +
                '}';
    }
}
