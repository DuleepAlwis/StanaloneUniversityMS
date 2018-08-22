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
import nsbm.universityms.model.Lab;
import nsbm.universityms.model.Staff;
import nsbm.universityms.model.Student;
import nsbm.universityms.model.StudentSubject;
import nsbm.universityms.model.Subject;

/**
 *
 * @author user
 */
public class LabController {
    
    public boolean addLab(Lab lab) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "insert into lab(labid,venue,capacity) values(?,?,?);";
        
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {lab.getLabid(),lab.getVenue(),lab.getCapacity()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean updateLab(Lab lab) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "update lab set venue=?,capacity=?;";
        
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {lab.getVenue(),lab.getCapacity()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
    }
    
    public boolean removeLab(Lab lab) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "delete from lab where labid=?;";
        
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, lab.getLabid());
        
        return ((stm.executeUpdate()>0));
    }
    
    public ResultSet getLabs() throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql = "select labid as Labid,venue as Venue,capacity as Capacity from lab;";
        PreparedStatement stm = connection.prepareStatement(sql);
        
        
        return ((stm.executeQuery()));
    }
    
    public boolean allocateLab(Lab lab,Staff staff,Subject subject,int k) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(k==1)
        {
            sql = "insert into laballocate(staffid,labid,msubid,day,tfrom,tto,bsubid) values(?,?,?,?,?,?,?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            String [] info = {staff.getId(),lab.getLabid(),null,lab.getDay(),lab.getFrom(),lab.getTo(),subject.getSubid()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
            return ((stm.executeUpdate()>0));
        }
        else 
        {
            sql = "insert into laballocate(staffid,labid,msubid,day,tfrom,tto,bsubid) values(?,?,?,?,?,?,?);";
            PreparedStatement stm = connection.prepareStatement(sql);
            String [] info = {staff.getId(),lab.getLabid(),subject.getSubid(),lab.getDay(),lab.getFrom(),lab.getTo(),null};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
            return ((stm.executeUpdate()>0));
        }
 
    }
    
    public boolean allocateUpdate(Lab lab,Staff staff,Subject subject,int k) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(k==1)
        {
            sql = "update laballocate set tfrom=?,tto=?,day=? where bsubid=? and staffid=? and labid=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            String [] info = {lab.getFrom(),lab.getTo(),lab.getDay(),subject.getSubid(),staff.getId(),lab.getLabid()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
            return ((stm.executeUpdate()>0));
        }
        else 
        {
            sql = "update laballocate set tfrom=?,tto=?,day=? where msubid=? and staffid=? and labid=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            String [] info = {lab.getFrom(),lab.getTo(),lab.getDay(),subject.getSubid(),staff.getId(),lab.getLabid()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
            return ((stm.executeUpdate()>0));
        }
 
    }
    
    public boolean allocateRemove(Lab lab,Staff staff,Subject subject,int k) throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(k==1)
        {
            sql = "delete from laballocate where bsubid=? and staffid=? and labid=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            String [] info = {subject.getSubid(),staff.getId(),lab.getLabid()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
            return ((stm.executeUpdate()>0));
        }
        else 
        {
            sql = "delete from laballocate where msubid=? and staffid=? and labid=?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            String [] info = {subject.getSubid(),staff.getId(),lab.getLabid()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
            return ((stm.executeUpdate()>0));
        }
 
    }
    
    public ResultSet getAllocation() throws SQLException, ClassNotFoundException
    {
        
        Connection connection = DBConnection.getInstance().getConnection();
        
        
        String sql = "select staffid as Incharge,labid as Lab,bsubid as Bac_Subject,msubid as Master_Subject,day as Day,tfrom as sTime,tto as eTime from laballocate;";
        PreparedStatement stm = connection.prepareStatement(sql);
            
        return stm.executeQuery();
    }
    
    public String count(StudentSubject studentsub,int j) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm;
        String sql;
        if(j==1)
        {
            sql = "select count(uadmission) as countn from ustudentgrade where subid=? and year=? and semester=?;";
            stm = connection.prepareStatement(sql);
            String [] info = {studentsub.getSubid(),studentsub.getYear(),studentsub.getSemester()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
        }
        else 
        {
            sql = "select count(padmission) as countn from pstudentgrade where subid=? and year=? and semester=?;";
            stm = connection.prepareStatement(sql);
            String [] info = {studentsub.getSubid(),studentsub.getYear(),studentsub.getSemester()};
            int i=0;
            for(i=0;i<info.length;i++)
            {
                stm.setObject(i+1,info[i]);
            }
   
        }
        ResultSet result = stm.executeQuery();
        if(result!=null)
        {
            while(result.next())
            {
                
                return String.valueOf(result.getString("countn"));
            }
        }
        return null;
        
    }
    
    
    
}
