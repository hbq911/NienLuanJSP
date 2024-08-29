/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package deamor.data.dao.Web;

import deamor.data.dao.Database;
import deamor.model.user;
import deamor.utils.API;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class RegisterServlet extends HttpServlet {

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
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("title", "register");
        request.getRequestDispatcher("./view/register.jsp").forward(request, response);
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
    String err_email = "", err_phone = "", err_repassword = "";
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String password = request.getParameter("password");
    String repassword = request.getParameter("repassword");
    String Email_Regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    String Phone_Regex = "^\\d{10}$";
    boolean err = false;

    // Kiểm tra email hợp lệ
    if (!email.matches(Email_Regex)) {
        err_email = "Email is invalid!";
        request.getSession().setAttribute("err_email", err_email);
        err = true;
    } else {
        err_email = "";
        request.getSession().removeAttribute("err_email");
    }

    // Kiểm tra số điện thoại hợp lệ
    if (!phone.matches(Phone_Regex)) {
        err_phone = "Phone must have 10 digits";
        request.getSession().setAttribute("err_phone", err_phone);
        err = true;
    } else {
        err_phone = "";
        request.getSession().removeAttribute("err_phone");
    }

    // Kiểm tra mật khẩu trùng khớp
    if (!repassword.equals(password)) {
        err_repassword = "Passwords do not match!";
        request.getSession().setAttribute("err_repassword", err_repassword);
        err = true;
    } else {
        err_repassword = "";
        request.getSession().removeAttribute("err_repassword");
    }

    // Nếu có lỗi, quay lại trang đăng ký
    if (err) {
        response.sendRedirect("register");
    } else {
        // Kiểm tra xem người dùng đã tồn tại hay chưa
        if (Database.getUserDao().findUser(email) != null || Database.getUserDao().findUser(phone) != null) {
            request.getSession().setAttribute("exist_user", "User already exists in the database!");
            response.sendRedirect("register");
        } else {
            // Chèn người dùng với ảnh mặc định
            Database.getUserDao().insertUser(name, email, phone, API.getMd5(password));
            user user = Database.getUserDao().findUser(email);
            request.getSession().setAttribute("u", user);
            request.getSession().removeAttribute("exist_user");
            response.sendRedirect("Home");
        }
    }
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
