/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.university.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import nsbm.university.db.DBConnection;
import nsbm.universityms.model.Login;

/**
 *
 * @author user
 */
public class LoginController {
    public String Login(Login login) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select uname,password from lusers where uname=? and password=?;";
       
        PreparedStatement stm = connection.prepareStatement(sql);
        
        
        stm.setObject(1,login.getUsername());
        stm.setObject(2, login.getPassword());
        ResultSet result = stm.executeQuery();
        while(result.next())
        {
            System.out.println(result.getString("password"));
            return result.getString("Password");
        }
        return null;
    }
}
