/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deamor.data.dao.implement;

import deamor.data.dao.UserDao;
import deamor.data.drive.MySqlDrive;
import deamor.model.Product;
import deamor.model.user;
import deamor.utils.API;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class UserImpl implements UserDao {

    Connection con = MySqlDrive.getConnection();

    public List<user> FinAll() {
        List<user> listU = new ArrayList<>();
        String sql = "SELECT * FROM `users`"; // Đảm bảo tên bảng là `users`
        PreparedStatement st;
        try {
            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user u = new user(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("password"),
                        rs.getBlob("image"), // Sử dụng getBlob cho cột kiểu BLOB
                        rs.getTimestamp("create_at"), // Sử dụng getTimestamp cho cột kiểu TIMESTAMP
                        rs.getString("role")
                );
                listU.add(u);

                // In thông tin user ra console
                System.out.println("ID: " + u.getId()
                        + ", Name: " + u.getName()
                        + ", Email: " + u.getEmail()
                        + ", Phone: " + u.getPhone()
                        + ", Password: " + u.getPassword()
                        + ", Image: " + u.getImage()
                        + ", Created At: " + u.getCreate_at()
                        + ", Role: " + u.getRole());
            }
            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println(sql);
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listU;
    }

    public user findUser(String emailphone, String password) {
        String sql;
        if (emailphone.contains("@")) {
            sql = "select * from users where email='" + emailphone + "' and password='" + API.getMd5(password) + "'";
        } else {
            sql = "select * from users where phone='" + emailphone + "' and password='" + API.getMd5(password) + "'";
        }
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new user(rs);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public user findUser(String emailname) {
        String sql;
        if (emailname.contains("@")) {
            sql = "select * from users where email = '" + emailname + "'";
        } else {
            sql = "select * from users where name = '" + emailname + "'";
        }
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return new user(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override

    public void insertUser(String name, String email, String phone, String password) {
    String sql = "INSERT INTO users(name, email, phone, password, role, create_at, image) VALUES(?, ?, ?, ?, 'user', NOW(), ?)";
    try (PreparedStatement sttm = con.prepareStatement(sql)) {
        sttm.setString(1, name);
        sttm.setString(2, email);
        sttm.setString(3, phone);
        sttm.setString(4, password);

        // Chọn ảnh ngẫu nhiên từ cơ sở dữ liệu
        String selectSql = "SELECT image FROM avatars ORDER BY RAND() LIMIT 1";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql)) {
            if (rs.next()) {
                byte[] defaultImage = rs.getBytes("image");
                sttm.setBytes(5, defaultImage);
                System.out.println(sql);
            } else {
                System.out.println("No avatars found in the database.");
                return;
            }
        }

        // Chèn user vào cơ sở dữ liệu
        sttm.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error inserting user: " + e.getMessage());
    }
}


}
