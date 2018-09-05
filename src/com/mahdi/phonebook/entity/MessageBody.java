package com.mahdi.phonebook.entity;

import com.google.gson.Gson;

import java.util.List;

public class MessageBody {

    private int statusCode;
    private String message;
    private List<ContactEntity> data;
    private ContactEntity contactEntityData;
    public MessageBody() {
    }

    public MessageBody(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public MessageBody(int statusCode, String message, List<ContactEntity> data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public MessageBody(int statusCode, String message, ContactEntity contactEntityData) {
        this.statusCode = statusCode;
        this.message = message;
        this.contactEntityData = contactEntityData;
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

    public List<ContactEntity> getData() {
        return data;
    }

    public void setData(List<ContactEntity> data) {
        this.data = data;
    }

    public ContactEntity getContactEntityData() {
        return contactEntityData;
    }

    public void setContactEntityData(ContactEntity contactEntityData) {
        this.contactEntityData = contactEntityData;
    }

    @Override
    public String toString() {
        return "MessageBody{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", contactEntityData=" + contactEntityData +
                '}';
    }
}
