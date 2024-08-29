/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deamor.data.dao.implement;

import deamor.data.dao.CategoryDao;
import deamor.data.drive.MySqlDrive;
import static deamor.data.drive.MySqlDrive.getConnection;
import deamor.model.Category;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CategoryImpl implements CategoryDao {

    Connection con = MySqlDrive.getConnection();

    @Override
    public List<Category> finAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM categories;";
        PreparedStatement st;
        try {
            st = getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"),
                        rs.getString("name"));
                list.add(c);
                System.out.println(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public boolean insert(Category category) {

        String sql = "SELECT * FROM shopping.categories;INSERT INTO `shopping`.`categories`\n"
                + "(`id`,\n"
                + "`name`)\n"
                + "VALUES\n"
                + "?,\n"
                + "?;";
        return true;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public Category update(int id) {
        return null;
    }

}
