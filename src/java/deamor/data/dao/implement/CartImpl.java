package deamor.data.dao.implement;

import deamor.data.dao.CartDao;
import deamor.data.drive.MySqlDrive;
import deamor.model.Cart;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartImpl implements CartDao {
    Connection con = MySqlDrive.getConnection();

    @Override
    public List<Cart> FindAll(int IDuser) {
        List<Cart> ListCart = new ArrayList<>();
        String sql = "SELECT * FROM `cart` WHERE IDuser = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, IDuser);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart(rs.getInt("ID"),
                                     rs.getInt("IDproduct"),
                                     rs.getString("Image"),
                                     rs.getString("Name"),
                                     rs.getDouble("Price"),
                                     rs.getInt("Quantity"),
                                     rs.getDouble("total"),
                                     rs.getInt("Status"),
                                     rs.getInt("IDuser"));
                ListCart.add(cart);  // Thêm sản phẩm vào danh sách
            }
        } catch (SQLException e) {
            Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return ListCart;
    }

    @Override
    public void insertCart(InputStream is, int IDproduct, String Image, String Name, double Price, int Quantity, double total, int IDuser) {
        String sql = "INSERT INTO `cart` (IDproduct, Image, Name, Price, Quantity, total, IDuser) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement rs = con.prepareStatement(sql)) {
            rs.setInt(1, IDproduct);
            rs.setBlob(2, is);  // Chuyển đổi ảnh thành Blob
            rs.setString(3, Name);
            rs.setDouble(4, Price);
            rs.setInt(5, Quantity);
            rs.setDouble(6, total);
            rs.setInt(7, IDuser);
            int rowsInserted = rs.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm vào giỏ hàng thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Thêm vào giỏ hàng thất bại");
        }
    }

    @Override
    public boolean checkCartExist(int idUser, int idProduct) {
        String sql = "SELECT COUNT(*) FROM cart WHERE IDuser = ? AND IDproduct = ?";
        boolean exists = false;
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idUser);
            pstmt.setInt(2, idProduct);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    exists = rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return exists;
    }

    // Cập nhật sản phẩm trong giỏ hàng
    @Override
    public void updateCart(int IDuser, int IDproduct, int Quantity) {
        String sql = "UPDATE cart SET Quantity = ?, total = Price * ? WHERE IDuser = ? AND IDproduct = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, Quantity);
            st.setInt(2, Quantity);
            st.setInt(3, IDuser);
            st.setInt(4, IDproduct);
            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật giỏ hàng thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Cập nhật giỏ hàng thất bại");
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    @Override
    public void deleteCart(int IDuser, int IDproduct) {
        String sql = "DELETE FROM cart WHERE IDuser = ? AND IDproduct = ?";
        try (PreparedStatement st = con.prepareStatement(sql)) {
            st.setInt(1, IDuser);
            st.setInt(2, IDproduct);
            int rowsDeleted = st.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Xóa sản phẩm khỏi giỏ hàng thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Xóa sản phẩm khỏi giỏ hàng thất bại");
        }
    }
}
