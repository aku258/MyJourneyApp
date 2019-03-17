/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hp
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;

public class DiaryDAO extends BaseDAO{
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet rs;

    public DiaryDAO() {
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
    
    public List getDiaryNames(String email,String type){
       List<Diarymodel> diarynames = new ArrayList<Diarymodel>();
        try {
            
            
            String sql = "Select * from MyJourney."+type+"_timeline where user_email = '"+email+"' and state_id=1";
            System.out.println(sql);
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Diarymodel temp_diary = new Diarymodel();
                temp_diary.setDiary_id(rs.getInt("DT_ID"));
                temp_diary.setVersion_id(rs.getInt("VERSION_ID"));
                temp_diary.setState_id(rs.getInt("STATE_ID"));
                
                temp_diary.setIs_diary(rs.getInt("IS_DIARY"));
                temp_diary.setDiaryname(rs.getString("DIARY_NAME"));
                
                temp_diary.setWritten_obj(rs.getBlob("WRITTEN_OBJ"));
                if(temp_diary.getWritten_obj()!=null){
                    byte[] imgData = rs.getBytes("WRITTEN_OBJ"); // blob field
                    String encode = Base64.getEncoder().encodeToString(imgData);
                    temp_diary.setImage(encode);
                }
                else{
                    temp_diary.setImage(null);
                }
        
                System.out.println(temp_diary.getDiaryname());
                diarynames.add(temp_diary);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diarynames;
    }
    
    public boolean create_new_diary(String diary_name, FileItem file, String type,String user,int isDiary,String mode){
        int version_id =1;
        
        try {
            String sql = "Select count(*) from Myjourney."+type+"_timeline where state_id=1";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            int dt_id=0;
            if(rs.next())
                dt_id = rs.getInt("Count(*)") + 1;
            if(isDiary ==0 && mode.equals("edit")){
                Blogmodel blog = new Blogmodel();
                blog = getBlogdetails(diary_name,user,type);
                dt_id = blog.getDiary_id();
                version_id = blog.getVersion_id() + 1;
                delete(dt_id,version_id,type);
            }
            sql = "Insert into MyJourney."+type+"_timeline values (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dt_id);
            preparedStatement.setInt(2,version_id);
            preparedStatement.setInt(3,1);
            preparedStatement.setString(4, diary_name);
            preparedStatement.setString(5, user);
            preparedStatement.setBinaryStream(6, file.getInputStream(), (int) file.getSize());;
            preparedStatement.setInt(7, isDiary);
            if(preparedStatement.executeUpdate()!=0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean itisDiary(String dname,String user,String type){
        try {
            String sql = "Select is_diary from MyJourney."+type+"_timeline where diary_name = '"+dname+"' and user_email = '"+user+"' and state_id = 1";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                int count = rs.getInt("is_diary");
                if(count==1)
                    return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Blogmodel getBlogdetails(String dname,String user,String type){
        Blogmodel bm = new Blogmodel();
        try {
            
            String sql = "Select * from MyJourney."+type+"_timeline where diary_name = '"+dname+"' and user_email = '"+user+"' and state_id = 1";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                bm.setBlogname(rs.getString("diary_name"));
                bm.setDiaryname("");
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
    
    public boolean delete(int dt_id,int version_id,String type){
        try {
            String sql = "UPDATE MyJourney."+type+"_timeline SET state_id = 0 WHERE dt_id="+dt_id+"and version_id="+version_id;
            System.out.println(sql);
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
            
            String sql = "Select * from MyJourney."+type+"_timeline where dt_id="+dt_id+" and state_id=0 sort by version_id";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                Blogmodel bm = new Blogmodel();
                bm.setBlogname(rs.getString("diary_name"));
                bm.setDiaryname(rs.getString(""));
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
