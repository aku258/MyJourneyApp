/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BlogDAO;
import model.Blogmodel;
import model.DiaryDAO;

/**
 *
 * @author hp
 */
public class displayBlog extends HttpServlet {

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
            HttpSession session = request.getSession();
            String type= session.getAttribute("type").toString();
            String user= session.getAttribute("user").toString();
            String diaryname= session.getAttribute("diary_name").toString();
            String mode= session.getAttribute("mode").toString();
            Blogmodel blog = new Blogmodel();
            
            String url="";
            if(mode.equals("edit")){
            if(diaryname.equals("")){
              //it is single blog not a diary blog
              DiaryDAO bd = new DiaryDAO();
                String blog_name = request.getParameter("blogn");
               blog = bd.getBlogdetails(blog_name, user, type);
              request.setAttribute("blog", blog);
            }
            else{
                BlogDAO bd = new BlogDAO();
                String blog_name = request.getParameter("blogn");
               blog = bd.getBlogdetails(diaryname, user, type, blog_name);
               request.setAttribute("blog", blog);
            }
                switch(type){
                        case("diary"):
                            System.out.println(blog.getBlogname());
                            byte[] bdata = blog.getWritten_obj().getBytes(1,(int) blog.getWritten_obj().length());
                            String s = new String(bdata);
                            System.out.println(s);
                            request.setAttribute("contents", s);
                            url="edit_diary_blog.jsp";
                            break;
                        case("travel"):
                            url = "edit_food_blog.jsp";
                            break;
                        case("food"):
                            url = "edit_travel_blog.jsp";
                            break;
                }
            }
            else{
                if(diaryname.equals("")){
              //it is single blog not a diary blog
              blog = (Blogmodel)request.getAttribute("bm");
              request.setAttribute("blog", blog);
            }
            else{
                BlogDAO bd = new BlogDAO();
                String blog_name = request.getParameter("blogn");
               blog = bd.getBlogdetails(diaryname, user, type, blog_name);
               System.out.println("testing:" +blog.getWritten_obj());
               request.setAttribute("blog", blog);
            }
                switch(type){
                        case("diary"):
                            System.out.println(blog.getBlogname());
                            byte[] bdata = blog.getWritten_obj().getBytes(1,(int) blog.getWritten_obj().length());
                            String s = new String(bdata);
                            System.out.println(s);
                            request.setAttribute("contents", s);
                            url="display_diary_blog.jsp";
                            break;
                        case("travel"):
                            url = "display_food_blog.jsp";
                            break;
                        case("food"):
                            url = "display_travel_blog.jsp";
                            break;
                }
            }
            request.getRequestDispatcher(url).forward(request, response);
                            
        } catch (SQLException ex) {
            Logger.getLogger(displayBlog.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
