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
            
            
            String sql = "Select * from MyJourney."+type+"_timeline where user_email = '"+email+"'";
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
    
    public boolean create_new_diary(String diary_name, FileItem file, String type,String user){
        
        try {
            String sql = "Select count(*) from Myjourney."+type+"_timeline where state_id=1";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            int dt_id=0;
            if(rs.next())
                dt_id = rs.getInt("Count(*)") + 1;
            sql = "Insert into MyJourney."+type+"_timeline values (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dt_id);
            preparedStatement.setInt(2,1);
            preparedStatement.setInt(3,1);
            preparedStatement.setString(4, diary_name);
            preparedStatement.setString(5, user);
            preparedStatement.setBinaryStream(6, file.getInputStream(), (int) file.getSize());;
            preparedStatement.setInt(7, 1);
            if(preparedStatement.executeUpdate()!=0)
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DiaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
