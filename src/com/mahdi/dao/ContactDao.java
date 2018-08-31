package com.mahdi.dao;

import com.mahdi.entity.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao extends Dao<Contact, Integer> {

    public ContactDao() throws Exception {

    }

    @Override
    public void create(Contact entity) throws SQLException {
        String sql = "INSERT INTO CONTACT(NAME,ADDRESS,PHONE,MOBILE,EMAIL) VALUES(?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getAddress());
        ps.setString(3, entity.getPhone());
        ps.setString(4, entity.getMobile());
        ps.setString(5, entity.getEmail());
        ps.executeUpdate();
    }

    @Override
    public Contact read(Integer contactId) throws SQLException {
        String sql = "SELECT * FROM CONTACT WHERE ID=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, contactId);
        Contact contact;
        try (ResultSet rs = ps.executeQuery()) {
            rs.next();
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String address = rs.getString("ADDRESS");
            String phone = rs.getString("PHONE");
            String mobile = rs.getString("MOBILE");
            String email = rs.getString("EMAIL");
            contact = new Contact(id, name, address, phone, mobile, email);
        }
        return contact;
    }

    @Override
    public void update(Contact entity) throws SQLException {
        String sql = "UPDATE CONTACT SET NAME=?,ADDRESS=?,PHONE=?,MOBILE=?,EMAIL=? WHERE ID=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getAddress());
        ps.setString(3, entity.getPhone());
        ps.setString(4, entity.getMobile());
        ps.setString(5, entity.getEmail());
        ps.setInt(6, entity.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM CONTACT WHERE ID=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Contact> readAll() throws SQLException {
        List<Contact> contactList = new ArrayList<>();
        String sql = "SELECT * FROM CONTACT";
        PreparedStatement ps = connection.prepareStatement(sql);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String address = rs.getString("ADDRESS");
                String phone = rs.getString("PHONE");
                String mobile = rs.getString("MOBILE");
                String email = rs.getString("EMAIL");
                contactList.add(new Contact(id, name, address, phone, mobile, email));
            }
        }
        return contactList;
    }

    @Override
    public void clear() throws SQLException {
        String sql = "DELETE FROM CONTACT";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }
}
