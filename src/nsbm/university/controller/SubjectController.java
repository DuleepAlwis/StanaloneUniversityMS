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
import java.sql.Statement;
import nsbm.university.db.DBConnection;
import nsbm.universityms.model.Subject;

/**
 *
 * @author user
 */
public class SubjectController {
    
    public boolean addSubject(Subject subject,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(y==1)
        {
            sql = "insert into bsubject(bcourseid,bsubid,name,day,tfrom,tto,lecid,credits,price,type) values(?,?,?,?,?,?,?,?,?,?)";
        }
        else 
        {
            sql = "insert into msubject(mcourse,subid,name,day,tfrom,tto,lecid,credits,price,type) values(?,?,?,?,?,?,?,?,?,?)";
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {subject.getCourse(),subject.getSubid(),subject.getSubname(),subject.getDay(),subject.getFrom(),subject.getTo(),subject.getLecid(),subject.getCredits(),subject.getPrice(),subject.getType()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
  
    }
    
    public boolean updateSubject(Subject subject,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(y==1)
        {
            sql = "update bsubject set bcourseid=?,name=?,day=?,tfrom=?,tto=?,lecid=?,credits=?,price=?,type=? where bsubid=?";
        }
        else 
        {
            sql = "update msubject set mcourse=?,name=?,day=?,tfrom=?,tto=?,lecid=?,credits=?,price=?,type=? where msubid=?";
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {subject.getCourse(),subject.getSubname(),subject.getDay(),subject.getFrom(),subject.getTo(),subject.getLecid(),subject.getCredits(),subject.getPrice(),subject.getType(),subject.getSubid()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setString(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean removeSubject(Subject subject,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(y==1)
        {
            sql = "delete from bsubject where bsubid=?";
        }
        else 
        {
            sql = "delete from msubject where subid=?";
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,subject.getSubid());
        
        return ((stm.executeUpdate()>0));
    }
    
    
    
    public ResultSet retrieve(Subject subject,int y) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(y==1)
        {
            sql = "select bcourseid as Course,bsubid as Subject,name as Name,day,tfrom as Start,tto as end,lecid as Lecturer,credits as Credits,type as Type from bsubject where bcourseid='"+subject.getCourse()+"';";
        }
        else 
        {
           sql = "select mcourse as Course,subid as Subject,name as Name,day,tfrom as T_from,tto as T_to,lecid as Lecturer,credits as Credits,type as Type from msubject where mcourse='"+subject.getCourse()+"';"; 
        }
        Statement stm = connection.createStatement();
        return stm.executeQuery(sql);
  
    }
}
