/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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

/**
 *
 * @author hp
 */
public class LoginDAO extends BaseDAO{
        Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    ResultSet rs;

    public LoginDAO() {
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
    
    public boolean checklogin(String username,String password){
        String sql = "Select password from MyJourney.Login_details where email = '"+username+"'";
        
            try {
                preparedStatement = connection.prepareStatement(sql);
                rs = preparedStatement.executeQuery();
                
                if(rs.next()){
                    System.out.println(rs.getString("password"));
                    if(rs.getString("password").equals(password))
                        return true;
                    else
                        return false;
                }
                else
                    return false;
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
     return false;  
    }
    
    public boolean register(RegDet reg){
        String sql = "Insert into MyJourney.Login_details values (?,?,?,?)";
            int s=0;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, reg.getName());
                preparedStatement.setString(2, reg.getEmail());
                preparedStatement.setString(3,reg.getMobile());
                preparedStatement.setString(4,reg.getPassword());
                s = preparedStatement.executeUpdate();
                if(s != 0) 
                    return true;
                else
                    return false;
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;        
    }
}
