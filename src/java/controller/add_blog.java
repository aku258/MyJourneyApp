/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import model.BlogDAO;
import model.Blogmodel;
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
public class add_blog extends HttpServlet {

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
            //get http session and read session values
            HttpSession session = request.getSession();
            String type= session.getAttribute("type").toString();
            String user= session.getAttribute("user").toString();
            String diary_name = session.getAttribute("diary_name").toString();
            String mode= session.getAttribute("mode").toString();
            // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);
            // parse request
            List items = null;
            try {
                items = sfu.parseRequest(request);
            } catch (FileUploadException ex) {
                Logger.getLogger(add_blog.class.getName()).log(Level.SEVERE, null, ex);
            }                            
                FileItem  id = (FileItem) items.get(0);
                String blog_name =  id.getString();
                // get contents
                FileItem file = (FileItem) items.get(1);
                String content = file.getString();
                
            //create DAO object
            if(diary_name.equals("")){
                DiaryDAO dd = new DiaryDAO();
                List<Diarymodel> diarynames = new ArrayList<Diarymodel>();
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
                if(dd.create_new_diary(blog_name, file, type, user,0,mode))
                {
                    diarynames = dd.getDiaryNames(user,type);
                    request.setAttribute("diarynames", diarynames);
                    session.setAttribute("mode", "add");
                    request.getRequestDispatcher(url).forward(request, response);
                }else{
                    out.println("failed");
                }
            }
            else{
                BlogDAO bd = new BlogDAO();
                System.out.println(diary_name);
                if(bd.create_new_blog(diary_name,blog_name, file, type, user,mode)){
                    session.setAttribute("mode", "add");
                    request.getRequestDispatcher("displayDiary.do?dname="+diary_name).forward(request, response);
                    
                }else{
                    out.println("failed");
                }
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
