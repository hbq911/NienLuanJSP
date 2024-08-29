/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deamor.data.dao.implement;

import java.sql.Connection;
import java.sql.*;
import deamor.data.dao.ProductDao;
import deamor.data.drive.MySqlDrive;
import deamor.model.Product;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ProductImpl implements ProductDao {

    Connection con = MySqlDrive.getConnection();

    @Override
    public List<Product> FinAll() {

        List<Product> listP = new ArrayList<>();
        String sql = "SELECT * FROM `products`  ";
        PreparedStatement st;
        try {
            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("id"),
                        rs.getInt("id_category"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getBoolean("status"));
                listP.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(sql);
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listP;

    }

    public void insertProduct(InputStream is, String id_category, String name, String image, String price, String quantity ) {
        String sql = "INSERT INTO products ( name, image, price, quantity, id_category) VALUES (?,?,?,?,?)";
        try (PreparedStatement rs = con.prepareStatement(sql)) {
            int result = 0;
            rs.setString(1, name);
            rs.setBlob(2, is);
            rs.setString(3, price);
            rs.setString(4, quantity);
            
            rs.setString(5, id_category);
            int rowsInserted = rs.executeUpdate();
            System.err.println("tthem thanh cong");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("them that bai");
        }
    }

    //tim product khi co id
    public Product getProductByName(String name) {

        List<Product> listP = new ArrayList<>();
        String sql = "SELECT * FROM `products` WHERE name=?";
        PreparedStatement st;
        try {
            st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getInt("id"),
                        rs.getInt("id_category"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getBoolean("status"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public Product findProduct(int id_product) {
        String sql = "select * from products where id=" + id_product;
        try {
            PreparedStatement sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return new Product(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean deleteProductById(int id) {
        String sql = "DELETE FROM `products` WHERE id=?";
        PreparedStatement st;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    @Override
    public void updateProduct(InputStream is, String id, String id_category, String name, String price, String quantity) {
    String sql = "UPDATE products SET name = ?, image = ?, price = ?, quantity = ?, status = ?, id_category = ? WHERE id = ?";
    try (PreparedStatement rs = con.prepareStatement(sql)) {
        rs.setString(1, name);
        rs.setBlob(2, is); // Cập nhật hình ảnh
        rs.setString(3, price);
        rs.setString(4, quantity);
        
        rs.setString(5, id_category);
        rs.setString(6, id); // Điều kiện WHERE để xác định sản phẩm cần cập nhật
        int rowsUpdated = rs.executeUpdate();
        if (rowsUpdated > 0) {
            System.err.println("Cập nhật thành công");
        } else {
            System.err.println("Không tìm thấy sản phẩm để cập nhật");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Cập nhật thất bại");
    }
}


}
