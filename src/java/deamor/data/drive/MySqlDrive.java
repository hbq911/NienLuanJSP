/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deamor.data.drive;
import deamor.utils.Constans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
/**
 *
 * @author ADMIN
 */
public class MySqlDrive {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Đảm bảo rằng driver đã được nạp
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Kết nối đến cơ sở dữ liệu
            connection = DriverManager.getConnection(
                Constans.DB_URL,
                Constans.USER,
                Constans.PASS
            );
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    

    
}
