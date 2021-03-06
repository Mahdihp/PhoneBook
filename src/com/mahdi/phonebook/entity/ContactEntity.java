package com.mahdi.phonebook.entity;

public class ContactEntity extends Entity<Integer> {

    private String name;
    private String address;
    private String phone;
    private String mobile;
    private String email;

    public ContactEntity() {
    }

    public ContactEntity(Integer id, String name, String address, String phone, String mobile, String email) {
        super(id);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
