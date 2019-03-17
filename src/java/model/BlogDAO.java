/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author hp
 */
public class BlogDAO extends BaseDAO{
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet rs;

    public BlogDAO() {
        try {
            connection = getConnection();
            System.out.println("Akash");
        } catch (ClassNotFoundException ex) {
            System.out.println("not connected");
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("not connected 2" + ex);
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public boolean create_new_blog(String diary_name,String blog_name, FileItem file, String type,String user,String mode){
        int version_id = 1;
        try {
            String sql = "Select count(*) from Myjourney."+type+"_blogs where state_id=1";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            int dt_id=0;
            if(rs.next())
                dt_id = rs.getInt("Count(*)") + 1;
            if(mode.equals("edit")){
                Blogmodel blog = new Blogmodel();
                blog = getBlogdetails(diary_name,user,type,blog_name);
                dt_id = blog.getDiary_id();
                version_id = blog.getVersion_id() + 1;
                delete_blog(dt_id,version_id-1,type);
            }
            sql = "Insert into MyJourney."+type+"_blogs values (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dt_id);
            preparedStatement.setInt(2,version_id);
            preparedStatement.setInt(3,1);
            preparedStatement.setString(4, blog_name);
            preparedStatement.setString(5, diary_name);
            preparedStatement.setString(6, user);
            preparedStatement.setBinaryStream(7, file.getInputStream(), (int) file.getSize());;
            if(preparedStatement.executeUpdate()!=0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<String> showbloglist(String dname,String user,String type){
        List<String> bloglist= new ArrayList<String>();
        
        String sql = "Select * from MyJourney."+type+"_blogs where diary_name='"+dname+"' and user_email='"+user+"' and state_id = 1";
        try {
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                String name = rs.getString("blog_name");
                bloglist.add(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bloglist;
    }
    
    public Blogmodel getBlogdetails(String dname,String user,String type,String blog){
        Blogmodel bm = new Blogmodel();
        try {
            
            String sql = "Select * from MyJourney."+type+"_blogs where blog_name = '"+blog+"' and diary_name = '"+dname+"' and user_email = '"+user+"' and state_id = 1";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                bm.setBlogname(rs.getString("blog_name"));
                bm.setDiaryname(dname);
                bm.setDiary_id(rs.getInt("dt_id"));
                bm.setVersion_id(rs.getInt("version_id"));
                bm.setState_id(rs.getInt("state_id"));
                bm.setWritten_obj(rs.getBlob("written_obj"));                        
            }
            return bm;
            
        } catch (SQLException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bm;
    }
    
    public boolean delete_blog(int dt_id,int version_id, String type){
        try {
            String sql = "UPDATE MyJourney."+type+"_blogs SET state_id = 0 WHERE dt_id="+dt_id+"and version_id="+version_id;
            preparedStatement = connection.prepareStatement(sql);
            int val = preparedStatement.executeUpdate();
            if(val >0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
            return false;
    }
    
    public List<Blogmodel> olderVersions(int dt_id,String type){
        List<Blogmodel> bloglist = new ArrayList<>();
        try {
            
            String sql = "Select * from MyJourney."+type+"_blogs where dt_id="+dt_id+" and state_id=0 order by version_id";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                Blogmodel bm = new Blogmodel();
                bm.setBlogname(rs.getString("blog_name"));
                bm.setDiaryname(rs.getString("diary_name"));
                bm.setDiary_id(rs.getInt("dt_id"));
                bm.setVersion_id(rs.getInt("version_id"));
                bm.setState_id(rs.getInt("state_id"));
                bm.setWritten_obj(rs.getBlob("written_obj"));
                bloglist.add(bm);
            }
                
            }catch (SQLException ex) {
            Logger.getLogger(BlogDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return bloglist;
        }
}
