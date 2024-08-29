package deamor.model;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class user {
    
    int id;
    String name, email, phone, password;
    private Blob image;
    private Timestamp create_at;
    private String role;

    // Constructor mặc định
    public user() {
    }

    // Constructor với ResultSet
    public user(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.email = rs.getString("email");
        this.phone = rs.getString("phone");
        this.password = rs.getString("password");
        this.role = rs.getString("role");
        this.image = rs.getBlob("image"); // Sửa lại để lấy Blob
        this.create_at = rs.getTimestamp("create_at"); // Sửa lại để lấy Timestamp
    }

    // Constructor với các tham số
    public user(int id, String name, String email, String phone, String password, Blob image, Timestamp create_at, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.image = image;
        this.create_at = create_at;
        this.role = role;
    }

    // Các getter và setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password + ", image=" + image + ", create_at=" + create_at + ", role=" + role + '}';
    }
}
