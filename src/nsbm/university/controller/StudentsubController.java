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

import nsbm.universityms.model.StudentSubject;

/**
 *
 * @author user
 */
public class StudentsubController {
    
    public boolean saveSubjects(StudentSubject stsub,int y) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql;
        if(y==1)
        {
            sql = "insert into ustudentgrade(uadmission,subid,year,semester,attempts) values('"+stsub.getAdmission()+"','"+stsub.getSubarry()[0]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),('"+stsub.getAdmission()+"','"+stsub.getSubarry()[1]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),('"+stsub.getAdmission()+"','"+stsub.getSubarry()[2]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),"
                    + "('"+stsub.getAdmission()+"','"+stsub.getSubarry()[3]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),('"+stsub.getAdmission()+"','"+stsub.getSubarry()[4]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),('"+stsub.getAdmission()+"','"+stsub.getSubarry()[5]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"');";
        }
        else 
        {
            sql = "insert into pstudentgrade(padmission,subid,year,semester,attempts) values('"+stsub.getAdmission()+"','"+stsub.getSubarry()[0]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),('"+stsub.getAdmission()+"','"+stsub.getSubarry()[1]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),('"+stsub.getAdmission()+"','"+stsub.getSubarry()[2]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),"
                    + "('"+stsub.getAdmission()+"','"+stsub.getSubarry()[3]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),('"+stsub.getAdmission()+"','"+stsub.getSubarry()[4]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"'),('"+stsub.getAdmission()+"','"+stsub.getSubarry()[5]+"','"+stsub.getYear()+"','"+stsub.getSemester()+"','"+stsub.getAttempt()+"');";
        }
        Statement stm = connection.createStatement();
        return stm.executeUpdate(sql)>0;
    }
    
    public boolean updateSubjects(StudentSubject stsub,int y,int [] num) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql;
        Statement stm = connection.createStatement();
        if(y==1)
        {
            int i=0;
            for(i=0;i<num.length;i++)
            {
                sql = "update ustudentgrade set subid='"+stsub.getSubarry()[i]+"',attempts='"+stsub.getAttempt().trim()+"' where number='"+num[i]+"';";
                if(stm.executeUpdate(sql)<0)
                {
                    return false;
                }
            }
        }
        else 
        {
            int i=0;
            for(i=0;i<num.length;i++)
            {
                sql = "update pstudentgrade set subid='"+stsub.getSubarry()[i]+"',attempts='"+stsub.getAttempt().trim()+"' where number='"+num[i]+"';";
                if(stm.executeUpdate(sql)<0)
                {
                    return false;
                }
            }
        }
        return true;
        
        
    }
    
    public ResultSet retrieveSubjects(StudentSubject studentsubject,int y) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        Statement stm = connection.createStatement();
        if(y==1)
        {
            sql = "select number,bsubject.name as name,ustudentgrade.subid as subid,bsubject.credits as credits,bsubject.type as Type from ustudentgrade,bsubject where ustudentgrade.subid=bsubject.bsubid and ustudentgrade.uadmission='"+studentsubject.getAdmission()+"' and ustudentgrade.attempts='"+studentsubject.getAttempt()+"' and ustudentgrade.year='"+studentsubject.getYear()+"' and ustudentgrade.semester='"+studentsubject.getSemester()+"';";
        }
        else
        {
            sql = "select number,msubject.name as name,pstudentgrade.subid as subid,msubject.credits as credits,bsubject.type as Type Sfrom pstudentgrade,msubject where pstudentgrade.subid=msubject.subid and pstudentgrade.padmission='"+studentsubject.getAdmission()+"' and pstudentgrade.attempts='"+studentsubject.getAttempt()+"' and pstudentgrade.year='"+studentsubject.getYear()+"' and pstudentgrade.semester='"+studentsubject.getSemester()+"';";
        }
        return stm.executeQuery(sql);
    }
    
    public ResultSet getAvailablesubjects(String course,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        Statement stm = connection.createStatement();
        if(y==1)
        {
            sql = "select name as Subject,bsubid as Code,credits as Credits,type as Type from bsubject where bcourseid='"+course+"';";
        }
        else
        {
            sql = "select subid as Code,name as Name,credits as Credits from msubject where mcourse='"+course+"';";
        }
        return stm.executeQuery(sql);
    }
    public ResultSet getStudentMarks(StudentSubject stsub,int y) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql;
        Statement stm = connection.createStatement();
        if(y==1)
        {
            sql = "select uadmission as Admission,attempts as Attempt,marks as Marks from ustudentgrade where subid='"+stsub.getSubid()+"' and attempts='"+stsub.getAttempt()+"' and year='"+stsub.getYear()+"' and semester='"+stsub.getSemester()+"';";
        }
        else 
        {
            sql = "select padmission as Admission,attempts as Attempt,marks as Marks from pstudentgrade where subid='"+stsub.getSubid()+"' and attempts='"+stsub.getAttempt()+"' and year='"+stsub.getYear()+"' and semester='"+stsub.getSemester()+"';";
        }
        return stm.executeQuery(sql);
        
    }
    
    public boolean savesubMarks(StudentSubject stsub,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();       
        String sql;
        Statement stm = connection.createStatement();
        if(y==1)
        {
            sql = "update ustudentgrade set marks='"+stsub.getMarks()+"' where subid='"+stsub.getSubid()+"' and uadmission='"+stsub.getAdmission()+"' and year='"+stsub.getYear()+"' and semester='"+stsub.getSemester()+"' and attempts='"+stsub.getAttempt()+"';";
        }
        else 
        {
            sql = "update pstudentgrade set marks='"+stsub.getMarks()+"' where subid='"+stsub.getSubid()+"' and padmission='"+stsub.getAdmission()+"' and year='"+stsub.getYear()+"' and semester='"+stsub.getSemester()+"' and attempts='"+stsub.getAttempt()+"';";
        }
        return stm.executeUpdate(sql)>0;
    }

    public boolean addAssignmentmarks(StudentSubject studentsubject,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(y==1)
        {
            sql = "insert into uagrade(uadmission,subid,asgnumber,marks,attempt) values(?,?,?,?,?);";
        }
        else 
        {
            sql = "insert into pagrade(padmission,subid,asgnumber,marks,attempt) values(?,?,?,?,?);"; 
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {studentsubject.getAdmission(),studentsubject.getSubid(),studentsubject.getAssignment(),studentsubject.getMarks(),studentsubject.getAttempt()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
        
    }
    
    public ResultSet retrieveAssignmentmarks(StudentSubject studentsubject,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(y==1)
        {
            sql = "select uadmission as Admission,attempts as Attempt from ustudentgrade where subid=? and attempts=? and year=? and semester=?;";
        }
        else 
        {
            sql = "select padmission as Admission,attempts as Attempt from pstudentgrade where subid=? and attempts=? and year=? and semester=?;";
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {studentsubject.getSubid(),studentsubject.getAttempt(),studentsubject.getYear(),studentsubject.getSemester()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return stm.executeQuery();
        
    }
    
    public boolean updateAssignmentmarks(StudentSubject studentsubject,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(y==1)
        {
            sql = "update uagrade set marks=? where uadmission=? and subid=? and attempt=? and asgnumber=?;";
        }
        else 
        {
            sql = "update pagrade set marks=? where uadmission=? and subid=? and attempt=? and asgnumber=?;";
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {studentsubject.getMarks(),studentsubject.getAdmission(),studentsubject.getSubid(),studentsubject.getAttempt(),studentsubject.getAssignment()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return ((stm.executeUpdate()>0));
        
    }
    
    public ResultSet getAdmission(StudentSubject studentsubject,int y) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql;
        if(y==1)
        {
            sql = "select uadmission as Admission from ustudentgrade where ustudentgrade.subid=? and ustudentgrade.attempts=? and ustudentgrade.year=? and ustudentgrade.semester=?;";
        }
        else 
        {
            sql = "select padmission as Admission from pstudentgrade where pstudentgrade.subid=? and pstudentgrade.attempts=? and pstudentgrade.year=? and pstudentgrade.semester=?;";
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {studentsubject.getSubid(),studentsubject.getAttempt(),studentsubject.getYear(),studentsubject.getSemester()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return stm.executeQuery();
        
    }
    
    public String calculateGrades(StudentSubject studentsubject,int i) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();       
        
        Statement stm = connection.createStatement();
        double avg = assignmentCalculate(studentsubject,i);
        int marks=0;
        double gra=0;
        String grade;
        String sql;
        if(i==1)
        {
            sql = "select marks from ustudentgrade where ustudentgrade.subid='"+studentsubject.getSubid()+ "' and ustudentgrade.attempts='"+studentsubject.getAttempt()+"' and ustudentgrade.year='"+studentsubject.getYear()+"' and ustudentgrade.semester='"+studentsubject.getSemester()+"';";
        }
        else 
        {
            sql = "select marks from pstudentgrade where pstudentgrade.subid='"+studentsubject.getSubid()+ "' and pstudentgrade.attempts='"+studentsubject.getAttempt()+"' and pstudentgrade.year='"+studentsubject.getYear()+"' and pstudentgrade.semester='"+studentsubject.getSemester()+"';";
        }
        
        
        
        ResultSet result = stm.executeQuery(sql);
        if(result!=null)
        {
            while(result.next())
            {
                marks = Integer.parseInt(result.getString("marks"));
            }
                
            gra = (avg+(double)marks)/2;
            if(gra>=75.0)
            {
                grade = "A";
            }
            else if(gra>=65.0)
            {
                grade = "B";
            }
            else if(gra>=50.0)
            {
                grade = "C";
            }
            else
            {
                grade = "F";
            }
            return grade;
            
        }
        
        
        return null;
        
    
    }
    
    public double assignmentCalculate(StudentSubject studentsubject,int i) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();       
        
        Statement stm = connection.createStatement();
        String sql;
        if(i==1)
        {
            sql = "select sum(marks) as total,count(asgnumber) as number from uagrade where uadmission='"+studentsubject.getAdmission()+"' and subid='"+studentsubject.getSubid()+"' and attempt='"+studentsubject.getAttempt()+"';";
        }
        else
        {
            sql = "select sum(marks) as total,count(asgnumber) as number from pagrade where padmission='"+studentsubject.getAdmission()+"' and subid='"+studentsubject.getSubid()+"' and attempt='"+studentsubject.getAttempt()+"';";
        }
        double avg;
        ResultSet result = stm.executeQuery(sql);
        if(result!=null)
        {
            while(result.next())
            {
                //System.out.println(getAdmission()+" "+result.getString("total")+" "+result.getString("number"));
                avg = Double.parseDouble(result.getString("total"))/Double.parseDouble(result.getString("number"));
                return avg;
            }
        }
        return 0;
        
    }
    
    public boolean gradeSave(StudentSubject studentsubject,int j) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql;
        if(j==1)
        {            
            sql = "update ustudentgrade set grade=? where uadmission=? and subid=? and attempts=? and year=? and semester=?;";
        }
        else 
        {
            sql = "update pstudentgrade set grade=? where padmission=? and subid=? and attempts=? and year=? and semester=?;";
        }
        PreparedStatement stm = connection.prepareStatement(sql);
        String [] info = {studentsubject.getGrade(),studentsubject.getAdmission(),studentsubject.getSubid(),studentsubject.getAttempt(),studentsubject.getYear(),studentsubject.getSemester()};
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        return stm.executeUpdate()>0;
        
    }
}
