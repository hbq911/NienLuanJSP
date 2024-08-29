/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package deamor.data.dao.Web;

import deamor.data.dao.implement.GioHang;
import deamor.model.user;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.catalina.User;

/**
 *
 * @author ADMIN
 */
public class addCartServlet extends HttpServlet {

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
            out.println("<title>Servlet addCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addCartServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession ss = request.getSession();
        // id_product`, `name`, `image`, `price`, `quantity`, `status`, `id_category`, `id_user`, `order_status
        int idProduct = 0;
    String name = "";
    String image = "";
    double price = 0.0;
    int quantity = 0;
    int status = 0;
    int idCategory = 0;
    int idUser = 0;
    String orderStatus = "";

    // Lấy tham số từ request và kiểm tra null hoặc rỗng
    String idProductStr = request.getParameter("id_product");
    if (idProductStr != null && !idProductStr.isEmpty()) {
        idProduct = Integer.parseInt(idProductStr);
    }

    name = request.getParameter("name");
    image = request.getParameter("image");

    String priceStr = request.getParameter("price");
    if (priceStr != null && !priceStr.isEmpty()) {
        price = Double.parseDouble(priceStr);
    }

    String quantityStr = request.getParameter("quantity");
    if (quantityStr != null && !quantityStr.isEmpty()) {
        quantity = Integer.parseInt(quantityStr);
    }

    String statusStr = request.getParameter("status");
    if (statusStr != null && !statusStr.isEmpty()) {
        status = Integer.parseInt(statusStr);
    }

    String idCategoryStr = request.getParameter("id_category");
    if (idCategoryStr != null && !idCategoryStr.isEmpty()) {
        idCategory = Integer.parseInt(idCategoryStr);
    }
    
        user user = (user)ss.getAttribute("u");
        
    GioHang gh = new GioHang();
        try {
            gh.themVaoGioHang(idProduct, name, image, price, quantity, status, idCategory, user.getId());
        } catch (SQLException ex) {
            Logger.getLogger(addCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    response.sendRedirect("Home");
        

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
