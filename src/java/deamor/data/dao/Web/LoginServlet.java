/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package deamor.data.dao.Web;

import deamor.data.dao.Database;
import deamor.model.user;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<user> listU = Database.getUserDao().FinAll();
        request.setAttribute("listU", listU);
        request.setAttribute("title", "Login Page");
        request.getRequestDispatcher("./view/Login.jsp").forward(request, response);
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
        String emp = request.getParameter("emailphone");
        String pass = request.getParameter("password");
        user u = Database.getUserDao().findUser(emp, pass);
        if (u == null) {
            request.getSession().setAttribute("er", "Thông tin đăng nhập sai!!!!");
            System.out.println("dang nhap that bai");
            response.sendRedirect("login");
        } else {
            if (u.getRole().equals("admin")) {
                System.out.println("xin chao admin");
                response.sendRedirect("admin");
            } else {
                request.getSession().setAttribute("u", u);
                request.getSession().removeAttribute("er");
                response.sendRedirect("Home");
            }
        }


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}

