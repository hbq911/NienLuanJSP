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
public class GioHang {

    Connection con = MySqlDrive.getConnection();

    // INSERT INTO `oder`(`id`, `id_product`, `name`, `image`, `price`, `quantity`, `status`, `id_category`, `id_user`, `order_status`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]','[value-8]','[value-9]','[value-10]')
    public boolean themVaoGioHang(int id_product, String name, String image, Double price, int quantity, int status, int id_category, int id_user) throws SQLException {
        String sql = "INSERT INTO `oder`(`id_product`, `name`, `image`, `price`, `quantity`, `status`, `id_category`, `id_user`, `order_status`) VALUES (?,?,?,?,?,?,?,?,'themvaogio')";
        PreparedStatement cmd = con.prepareStatement(sql);
        cmd.setInt(1, id_product);
        cmd.setString(2, name);
        cmd.setString(3, image);
        cmd.setDouble(4, price);
        cmd.setInt(5, quantity);
        cmd.setInt(6, status);
        cmd.setInt(7, id_category);
        cmd.setInt(8, id_user);
        cmd.executeUpdate();
        return true;
    }
    
    public ArrayList<Product> getGioHang(int id_user) throws Exception{
        ArrayList<Product> ds = new ArrayList<>();
        String sql = "SELECT * FROM `oder` WHERE id_user = ?";
        PreparedStatement cmd = con.prepareStatement(sql);
        cmd.setInt(1, id_user);
        ResultSet rs = cmd.executeQuery();
        while(rs.next()){
            boolean stt = true;
             Product p = new Product(
                        rs.getInt("id_product"),
                        rs.getInt("id_category"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        stt);
                        
               ds.add(p);
        } 
        return ds;
    } 

}
