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
import nsbm.universityms.model.BatchelorCourse;
import nsbm.universityms.model.MasterCourse;

/**
 *
 * @author user
 */
public class CourseController {
    
    public boolean addCourse(BatchelorCourse course) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "insert into bachelor(cid,cname,gyears,credits,syear) values(?,?,?,?,?);";
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {course.getCid(),course.getCname(),course.getGyears(),course.getCredits(),course.getSyear()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean addCourse(MasterCourse course) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "insert into masterc(cid,cname,credits,year) values(?,?,?,?);";
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {course.getCid(),course.getCname(),course.getCredits(),course.getYear()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean updateCourse(BatchelorCourse course) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "update bachelor set cname=?,gyears=?,credits=?,syear=? where cid=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {course.getCname(),course.getGyears(),course.getCredits(),course.getSyear(),course.getCid()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean updateCourse(MasterCourse course) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "update masterc set cname=?,credits=?,year=? where cid=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {course.getCname(),course.getCredits(),course.getYear(),course.getCid()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean removeCourse(BatchelorCourse course) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "delete from bachelor where cid=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        
        stm.setObject(1,course.getCid());
        
       
        return ((stm.executeUpdate()>0));
    }
    
    public boolean removeCourse(MasterCourse course) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "delete from masterc where cid=?;";
        PreparedStatement stm = connection.prepareStatement(sql);        
        stm.setObject(1,course.getCid()); 
        return ((stm.executeUpdate()>0));
    }
    
    public ResultSet retrieve(int i) throws SQLException, ClassNotFoundException
    {
        //i==1 Batchelor coursre     i==2  MasterCourse
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(i==1)
        {
            sql = "select cid as code,cname as course,gyears as generalY,credits as Credits,syear as specialY from bachelor;"; 
        }
        else 
        {
            sql = "select cid as code,cname as course,credits,year as Years from masterc;"; 
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        return stm.executeQuery(sql);
    }
    
    
}
