/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package deamor.data.dao.Web;

import deamor.data.dao.CategoryDao;
import deamor.data.dao.Database;
import deamor.data.dao.implement.phantrangImpl;
import deamor.model.Category;
import deamor.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HomeServlet extends HttpServlet {

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
            out.println("<title>Servlet HomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        List<Category> list = Database.getCategoryDao().finAll();
        request.setAttribute("list", list);
        String id_cate = request.getParameter("id_cate");     
        int trang = 0;
        String trangtam = request.getParameter("trang");
        System.out.print("id category: " + id_cate + "\n");
        System.out.print("trang: " + trangtam + "\n");
        if(trangtam==null){
            trang = 1;
        }
        else{
            trang = Integer.parseInt(trangtam);
        }
//        List<Product> listP = Database.getProductDao().FinAll();
          phantrangImpl ip = new phantrangImpl();
          List<Product> listP = null;
        if(id_cate==null){
            try {
                listP = ip.phanTrang(trang);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else{
            int id_category = Integer.parseInt(id_cate);
            try {
                listP = ip.phanTrangByCategory(trang, id_category);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        for(Product s:listP){
            System.out.println(s.getId());
        }
        request.setAttribute("id_cate_by_pr", id_cate);
        request.setAttribute("listP", listP);
        request.setAttribute("title", "Home Page");
        request.setAttribute("soT", trangtam);
        request.getRequestDispatcher("./view/Home.jsp").forward(request, response);
        
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
    void addProductToCart(HttpServletRequest request){
      int id_product;
      try{
         id_product = Integer.parseInt(request.getParameter("id_product"));
      
      }catch(Exception e){
      id_product=0;
      }
      List<Product> cart = (List<Product>) request.getSession().getAttribute("cart");
      if(cart==null) cart = new ArrayList<>();
      if(id_product>0){
      Product product = Database.getProductDao().findProduct(id_product);
      boolean isProductInCart=false;
       for(Product pro: cart)
           if(pro.getId()==id_product){
             pro.setQuantity(pro.getQuantity()+1);
             isProductInCart=true;
           }
       if(!isProductInCart) cart.add(product);
      }
      request.getSession().setAttribute("cart", cart);
      }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
