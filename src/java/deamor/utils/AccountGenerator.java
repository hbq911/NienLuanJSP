package deamor.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.util.Random;

import java.sql.Connection;
import java.sql.*;

public class AccountGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String EMAIL_DOMAINS = "@example.com";

    public static void main(String[] args) {
        String name = generateRandomString(8);
        String email = name.toLowerCase() + EMAIL_DOMAINS;
        String phone = generateRandomPhoneNumber();
        String password = generateRandomString(10);
        String repassword = password;

        System.out.println("Creating account with the following details:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Password: " + password);
        System.out.println("Repassword: " + repassword);

        // Lưu thông tin tài khoản vào cơ sở dữ liệu
        saveAccountToDatabase(name, email, phone, password, repassword);
    }

    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    private static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("0"); // Bắt đầu số điện thoại với số 0
        for (int i = 0; i < 9; i++) {
            sb.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return sb.toString();
    }

    private static void saveAccountToDatabase(String name, String email, String phone, String password, String repassword) {
    String url = "jdbc:mysql://localhost:3306/shopping1"; // Thay đổi URL cơ sở dữ liệu của bạn
    String user = "root"; // Thay đổi tên người dùng của bạn
    String pass = ""; // Thay đổi mật khẩu của bạn

    String sql = "INSERT INTO users (name, email, phone, password, role, image) VALUES (?, ?, ?, ?, 'user', ?)";

    try (Connection con = DriverManager.getConnection(url, user, pass); PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, name);
        pst.setString(2, email);
        pst.setString(3, phone);
        pst.setString(4, hashPassword(password)); // Mã hóa mật khẩu trước khi lưu

        // Chọn ảnh ngẫu nhiên từ cơ sở dữ liệu
        String selectSql = "SELECT image FROM avatars ORDER BY RAND() LIMIT 1";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(selectSql)) {
            if (rs.next()) {
                byte[] defaultImage = rs.getBytes("image");
                pst.setBytes(5, defaultImage);
            } else {
                System.out.println("No avatars found in the database.");
                return;
            }
        }

        pst.executeUpdate();
        System.out.println("Account saved to database successfully.");

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error saving account to database: " + e.getMessage());
    }
}



    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
