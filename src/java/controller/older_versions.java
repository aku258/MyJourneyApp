/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class older_versions extends HttpServlet {

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
            int dt_id = Integer.parseInt(request.getParameter("dt_id"));
            List<Blogmodel> bloglist = new ArrayList<>();
            Map<Blogmodel,String> content = new HashMap<>();
            if(diaryname.equals("") ){
                DiaryDAO dd = new DiaryDAO();
                bloglist =dd.olderVersions(dt_id,type);
                
            }else{
                BlogDAO bd = new BlogDAO();
                 bloglist = bd.olderVersions(dt_id,type);
                
            }
            request.setAttribute("bloglist", bloglist); 
            
            for(int i = 0; i < bloglist.size(); i++){
                byte[] bdata = bloglist.get(i).getWritten_obj().getBytes(1,(int) bloglist.get(i).getWritten_obj().length());
                String s = new String(bdata);
                content.put(bloglist.get(i),s);
            }
            request.setAttribute("content", content); 
            request.getRequestDispatcher("older_versions_"+type+".jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(older_versions.class.getName()).log(Level.SEVERE, null, ex);
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
