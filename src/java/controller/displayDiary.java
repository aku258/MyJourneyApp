/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class displayDiary extends HttpServlet {

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
            String dname = request.getParameter("dname");
            HttpSession session = request.getSession();
            String type= session.getAttribute("type").toString();
            String user= session.getAttribute("user").toString();
            session.setAttribute("diary_name", dname);
            out.println(dname);
            DiaryDAO dd = new DiaryDAO();
            BlogDAO bd = new BlogDAO();
            Blogmodel bm = new Blogmodel();
            List<String> bloglist = new ArrayList<>();
            if(dname.equals("")){
                request.getRequestDispatcher("load_data.do?type="+type).forward(request, response);
            }
            if(dd.itisDiary(dname,user,type)){
               bloglist = bd.showbloglist(dname,user,type);
               request.setAttribute("bloglist", bloglist);
               request.getRequestDispatcher("display_diary.jsp").forward(request, response);
            }else{
                bm = dd.getBlogdetails(dname,user,type);
                session.setAttribute("diary_name", "");
                request.setAttribute("bm", bm);
                request.getRequestDispatcher("displayBlog.do").forward(request, response);
            }
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
