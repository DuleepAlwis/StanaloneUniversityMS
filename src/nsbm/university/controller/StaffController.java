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
import nsbm.universityms.model.Staff;

/**
 *
 * @author user
 */
public class StaffController {
    
    
    
    public boolean addStaff(Staff staff,int k) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm;
        if(k==1)
        {
            String sql = "insert into lecturer(staffid,name,dob,contact,address,gender,office) values(?,?,?,?,?,?,?);";
            stm = connection.prepareStatement(sql);
            String [] info = {staff.getId(),staff.getName(),staff.getDob(),staff.getEmail(),staff.getAddress(),staff.getGender(),staff.getOffice()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
        }
        else 
        {
            String sql = "insert into instructer(staffid,name,dob,contact,address,gender) values(?,?,?,?,?,?);";
            stm = connection.prepareStatement(sql);
            String [] info = {staff.getId(),staff.getName(),staff.getDob(),staff.getEmail(),staff.getAddress(),staff.getGender(),staff.getOffice()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
        }
        
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean updateStaff(Staff staff,int k) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm;
        if(k==1)
        {        
            String sql = "update lecturer set name=?,contact=?,address=?,office=? where staffid=?;";
            stm = connection.prepareStatement(sql);
            String [] info = {staff.getName(),staff.getMobile(),staff.getAddress(),staff.getOffice(),staff.getId()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
        }
        else 
        {
            String sql = sql = "update instructer set name=?,contact=?,address=? where staffid=?;";
            stm = connection.prepareStatement(sql);
            String [] info = {staff.getName(),staff.getMobile(),staff.getAddress(),staff.getId()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
        }
        
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean removeStaff(Staff staff,int k) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm;
        if(k==1)
        {        
            String sql = "delete from lecturer where staffid=?;";
            stm = connection.prepareStatement(sql);
            stm.setObject(1, staff.getId());
        }
        else 
        {
            String sql = "delete from instructer where staffid=?;";
            stm = connection.prepareStatement(sql);
            stm.setObject(1, staff.getId());
        }
        
        
        return ((stm.executeUpdate()>0));
    }
    
    public ResultSet retrieve(int k) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm;
        if(k==1)
        {        
            String sql = "select staffid as Staffid,name as Name,dob as DOB,contact as ContactN,address as Address,gender as Gender,office as Office from lecturer;";
            stm = connection.prepareStatement(sql);
            
        }
        else 
        {
            String sql = "select staffid as Staffid,name as Name,dob as DOB,contact as ContactN,address as Address,gender as Gender from instructer;";
            stm = connection.prepareStatement(sql);         
        }
    
        return ((stm.executeQuery()));
    }
    
    
    
}
