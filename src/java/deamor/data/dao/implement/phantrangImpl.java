/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deamor.data.dao.implement;
import deamor.data.drive.MySqlDrive;
import deamor.model.Product;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ADMIN
 */
public class phantrangImpl{
    Connection con = MySqlDrive.getConnection();
    
    public ArrayList<Product> phanTrang(int trang) throws SQLException{
        ArrayList<Product> ds = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY id LIMIT 6 OFFSET ?";
        PreparedStatement cmd = con.prepareStatement(sql);
        cmd.setInt(1, 6*trang-6);
        ResultSet rs = cmd.executeQuery();
        while(rs.next()){
            Product p = new Product(rs.getInt("id"),
                        rs.getInt("id_category"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getBoolean("status"));
               ds.add(p);
        }
        return ds;
    }
    
    public ArrayList<Product> phanTrangByCategory(int trang, int id) throws SQLException{
        ArrayList<Product> ds = new ArrayList<>();
        String sql = "SELECT * FROM products \n" +
                    "WHERE id_category = ? \n" +
                    "ORDER BY id \n" +
                    "LIMIT 6 OFFSET ?;";
        PreparedStatement cmd = con.prepareStatement(sql);
        cmd.setInt(1, id);
        cmd.setInt(2, 6*trang-6);
        ResultSet rs = cmd.executeQuery();
        while(rs.next()){
            Product p = new Product(rs.getInt("id"),
                        rs.getInt("id_category"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getBoolean("status"));
               ds.add(p);
        }
        return ds;
    }
}
