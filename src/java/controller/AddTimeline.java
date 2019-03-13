/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DiaryDAO;
import model.Diarymodel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author hp
 */
public class AddTimeline extends HttpServlet {

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
            //String diary_name = request.getParameter("d_name");
             // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);

            if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
                return;
            }

            // parse request
            List items;
                items = sfu.parseRequest(request);
            
            FileItem  id = (FileItem) items.get(0);
            String diary_name =  id.getString();

            // get uploaded file
            FileItem file = (FileItem) items.get(1);
            
            DiaryDAO dd = new DiaryDAO();
            List<Diarymodel> diarynames = new ArrayList<Diarymodel>();
            HttpSession session = request.getSession();
            String type= session.getAttribute("type").toString();
            String user= session.getAttribute("user").toString();
            String url="";
                            switch(type){
                    case("diary"):
                        url="written_diary.jsp";
                        break;
                    case("travel"):
                        url = "travel_diary.jsp";
                        break;
                    case("food"):
                        url = "food_diary.jsp";
                        break;
                }
            if(dd.create_new_diary(diary_name, file, type, user)){
                diarynames = dd.getDiaryNames(user,type);
                request.setAttribute("diarynames", diarynames);
                request.getRequestDispatcher(url).forward(request, response);
            }
            else{
                response.sendRedirect(url);
            }
            
        }catch (FileUploadException ex) {
                Logger.getLogger(AddTimeline.class.getName()).log(Level.SEVERE, null, ex);
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
