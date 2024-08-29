/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package deamor.data.dao.Web;

import deamor.data.dao.Database;
import deamor.data.drive.MySqlDrive;
import deamor.model.Category;
import deamor.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
@MultipartConfig(maxFileSize = 16177215)
public class AdminServlet extends HttpServlet {

    Connection con = MySqlDrive.getConnection();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            action = action.trim();
        }
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            deleteProductById(id);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("productId"));
            Product product = Database.getProductDao().findProduct(id);
            request.setAttribute("product", product);
            request.getRequestDispatcher("./view/update.jsp").forward(request, response);
            return;
        }

        // Mã tải lại danh sách sản phẩm và chuyển hướng về trang admin
        List<Category> list = Database.getCategoryDao().finAll();
        request.setAttribute("list", list);
        List<Product> listP = Database.getProductDao().FinAll();
        request.setAttribute("listP", listP);
        request.setAttribute("title", "Admin Page");
        request.getRequestDispatcher("./view/admin.jsp").forward(request, response);
    }

    private void deleteProductById(int id) {
        boolean isDeleted = Database.getProductDao().deleteProductById(id);

        if (isDeleted) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Failed to delete the product.");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void updateProduct(int id, String name, InputStream is, double price, int quantity, int id_category) {
        String sql = "UPDATE `products` SET `name`=?, `image`=?, `price`=?, `quantity`=?, `id_category`=? WHERE `id`=?";
        try (PreparedStatement rs = con.prepareStatement(sql)) {
            rs.setString(1, name);
            rs.setBlob(2, is); // Cập nhật hình ảnh
            rs.setDouble(3, price);
            rs.setInt(4, quantity);
            rs.setInt(5, id_category);
            rs.setInt(6, id); // Điều kiện WHERE để xác định sản phẩm cần cập nhật

            int rowsUpdated = rs.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Không tìm thấy sản phẩm để cập nhật");
            }
        } catch (SQLException e) {
            System.out.println("Executing SQL: " + sql);
            System.out.println("Cập nhật thất bại");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("update".equals(action)) {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                request.setAttribute("error", "ID sản phẩm không hợp lệ");
                request.getRequestDispatcher("./view/error.jsp").forward(request, response);
                return;
            }

            int productId = Integer.parseInt(idParam);
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int idCategory = Integer.parseInt(request.getParameter("id_category"));

            Part filePart = request.getPart("image");
            InputStream inputStream = filePart.getInputStream();

            updateProduct(productId, name, inputStream, price, quantity, idCategory);

            response.sendRedirect("admin");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
