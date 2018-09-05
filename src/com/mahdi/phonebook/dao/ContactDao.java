package com.mahdi.phonebook.dao;

import com.mahdi.phonebook.entity.ContactEntity;
import com.mahdi.phonebook.util.Constans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao extends Dao<ContactEntity, Integer> {

    public ContactDao() throws Exception {

    }

    @Override
    public void create(ContactEntity entity) throws SQLException {
        String sql = "INSERT INTO " + Constans.KEY_TABLE_NAME +
                "(" + Constans.KEY_COL_NAME +
                "," + Constans.KEY_COL_ADDRESS +
                "," + Constans.KEY_COL_PHONE +
                "," + Constans.KEY_COL_MOBILE +
                "," + Constans.KEY_COL_EMAIL +
                ") VALUES(?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getAddress());
        ps.setString(3, entity.getPhone());
        ps.setString(4, entity.getMobile());
        ps.setString(5, entity.getEmail());
        ps.executeUpdate();
    }

    @Override
    public ContactEntity read(Integer contactId) throws SQLException {
        String sql = "SELECT * FROM " + Constans.KEY_TABLE_NAME + " WHERE " + Constans.KEY_COL_ID + "=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, contactId);
        ContactEntity contactEntity = null;
        try (ResultSet rs = ps.executeQuery()) {
            rs.last();
            int size = rs.getRow();
            if (size > 0) {
                rs.beforeFirst();
                rs.next();
                int id = rs.getInt(Constans.KEY_COL_ID);
                String name = rs.getString(Constans.KEY_COL_NAME);
                String address = rs.getString(Constans.KEY_COL_ADDRESS);
                String phone = rs.getString(Constans.KEY_COL_PHONE);
                String mobile = rs.getString(Constans.KEY_COL_MOBILE);
                String email = rs.getString(Constans.KEY_COL_EMAIL);
                contactEntity = new ContactEntity(id, name, address, phone, mobile, email);
            }
        }
        return contactEntity;
    }

    @Override
    public void update(ContactEntity entity) throws SQLException {
        String sql = "UPDATE " +
                Constans.KEY_TABLE_NAME +
                " SET " + Constans.KEY_COL_NAME +
                "=?," + Constans.KEY_COL_ADDRESS +
                "=?," + Constans.KEY_COL_PHONE +
                "=?," + Constans.KEY_COL_MOBILE +
                "=?," + Constans.KEY_COL_EMAIL +
                "=? WHERE " + Constans.KEY_COL_ID + "=?;";
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
        String sql = "DELETE FROM " + Constans.KEY_TABLE_NAME + " WHERE " + Constans.KEY_COL_ID + "=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<ContactEntity> readAll() throws SQLException {
        List<ContactEntity> contactEntityList = new ArrayList<>();
        String sql = "SELECT * FROM " + Constans.KEY_TABLE_NAME;
        PreparedStatement ps = connection.prepareStatement(sql);
        try (ResultSet rs = ps.executeQuery()) {
            rs.last();
            int size = rs.getRow();
            if (size > 0) {
                rs.beforeFirst();
                while (rs.next()) {
                    int id = rs.getInt(Constans.KEY_COL_ID);
                    String name = rs.getString(Constans.KEY_COL_NAME);
                    String address = rs.getString(Constans.KEY_COL_ADDRESS);
                    String phone = rs.getString(Constans.KEY_COL_PHONE);
                    String mobile = rs.getString(Constans.KEY_COL_MOBILE);
                    String email = rs.getString(Constans.KEY_COL_EMAIL);
                    contactEntityList.add(new ContactEntity(id, name, address, phone, mobile, email));
                }
            }
        }
        return contactEntityList;
    }

    @Override
    public void clear() throws SQLException {
        String sql = "DELETE FROM " + Constans.KEY_TABLE_NAME;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }
}
