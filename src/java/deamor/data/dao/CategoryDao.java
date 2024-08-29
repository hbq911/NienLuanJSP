/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deamor.data.dao;

import deamor.data.drive.MySqlDrive;
import static deamor.data.drive.MySqlDrive.getConnection;
import deamor.model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author ADMIN
 */
public interface CategoryDao {
//    public static List<Category> findAll() {
//    
//        List<Category> list = new ArrayList<>();
//        String sql = "SELECT * FROM shopping.categories;";
//        try {
//            PreparedStatement st = getConnection().prepareStatement(sql);
//
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Category c = new Category(rs.getInt("id"),
//                        rs.getString("name"));
//                list.add(c);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }
//    
//    public static void main(String[] args) {
//        CategoryDao c = new CategoryDao();
//        List<Category> list = c.findAll();
//        System.out.println(list.get(0).getName());
//    }
//
//    
//    
//    }
//    
    public List<Category> finAll();
    public  boolean insert(Category category);
    public boolean delete(int id);
    public Category update(int id);
}
    

