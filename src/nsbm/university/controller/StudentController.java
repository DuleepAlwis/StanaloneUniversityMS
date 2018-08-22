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
import nsbm.universityms.model.BachelorStudent;
import nsbm.universityms.model.PostgraduateStudent;

/**
 *
 * @author user
 */
public class StudentController {
    
    public boolean addStudent(BachelorStudent student) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "insert into ustudent(admission,Name,courseid,dob,joindate,stream,sub1,sub2,sub3,address,batch,gender,email) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {student.getId(),student.getName(),student.getCourse(),student.getDob(),student.getJdate(),student.getStream(),student.getSub1(),student.getSub2(),student.getSub3(),student.getAddress(),student.getBatch(),student.getGender(),student.getEmail()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
  
    }
    
    public boolean addStudent(PostgraduateStudent student) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "insert into pstudent(admission,name,courseid,dob,joindate,qualification,institute,gyear,address,batch,gender,email) values(?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {student.getId(),student.getName(),student.getCourse(),student.getDob(),student.getJdate(),student.getQualification(),student.getGinstitute(),student.getGyear(),student.getAddress(),student.getBatch(),student.getGender(),student.getEmail()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1, info[i]);
        }
        
        return ((stm.executeUpdate()>0));
  
    }
    
    public ResultSet retrieve(BachelorStudent student) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql ="select admission as Admission,Name,courseid as Course,email as Email,address as Address,dob as DOB,joindate as JDate,stream,sub1,sub2,sub3,gender as Gender from ustudent where batch=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, student.getBatch());
        System.out.println(student.getBatch());
        return stm.executeQuery();
        
            
        
    }
    
    public ResultSet retrieve(PostgraduateStudent student) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select admission as Admission,name as Name,courseid as Course,email as Email,address as Address,dob as DOB,joindate as JDate,qualification as Qualification,institute as Institute,gyear as GraduatedY,gender as Gender from pstudent where batch=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, student.getBatch());
        return stm.executeQuery();
        
            
        
    }
    
    public boolean update(BachelorStudent student) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "update ustudent set Name=?,courseid=?,email=?,address=? where admission=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {student.getName(),student.getCourse(),student.getEmail(),student.getAddress(),student.getId()};
        int i = 0 ;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1, info[i]);
        }
        
        return stm.execute();
    
    }
    public boolean update(PostgraduateStudent student) throws SQLException, ClassNotFoundException
    {
       Connection connection = DBConnection.getInstance().getConnection();
        String sql = "update pstudent set Name=?,courseid=?,email=?,address=? where admission=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {student.getName(),student.getCourse(),student.getEmail(),student.getAddress(),student.getId()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1, info[i]);
        }
        
        return stm.executeUpdate()>0;
    }
    
    
    public boolean remove(BachelorStudent student) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "delete from ustudent where admission=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,student.getId());
        return stm.executeUpdate()>0;
    }
    
    public boolean remove(PostgraduateStudent student) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "delete from pstudent where admission=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,student.getId());
        return stm.executeUpdate()>0;
    }
    
}
