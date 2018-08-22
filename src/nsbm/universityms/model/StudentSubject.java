/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.universityms.model;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class StudentSubject {
    
    private String admission;
    private String subid;
    private String attempt;
    private String grade;
    private String marks;
    private String year;
    private String semester;
    private String batch;
    private String [] subarry = new String[6];
    private String assignment;
    
    
    /**
     * @return the admission
     */
    public String getAdmission() {
        return admission;
    }

    /**
     * @param admission the admission to set
     */
    public void setAdmission(String admission) {
        this.admission = admission;
    }

    /**
     * @return the subid
     */
    public String getSubid() {
        return subid;
    }

    /**
     * @param subid the subid to set
     */
    public void setSubid(String subid) {
        this.subid = subid;
    }

    /**
     * @return the attempts
     */
    

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the marks
     */
    public String getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(String marks) {
        this.marks = marks;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    /**
     * @return the attempt
     */
    public String getAttempt() {
        return attempt;
    }

    /**
     * @param attempt the attempt to set
     */
    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }
    
    public String[] getSubarry() {
        return subarry;
    }

    /**
     * @param subarry the subarry to set
     */
    public void setSubarry(String[] subarry) {
        this.subarry=subarry;
    }
    
    /**
     * @return the assignment
     */
    public String getAssignment() {
        return assignment;
    }

    /**
     * @param assignment the assignment to set
     */
    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
    
    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }
    /*public ResultSet getUstudent(DBconnect db) throws SQLException
    {
        String sql = "select number,bsubject.name as name,ustudentgrade.subid as subid,bsubject.credits as credits from ustudentgrade,bsubject where ustudentgrade.subid=bsubject.bsubid and ustudentgrade.uadmission='"+getAdmission()+"' and ustudentgrade.attempts='"+getAttempt()+"' and ustudentgrade.year='"+getYear()+"' and ustudentgrade.semester='"+getSemester()+"';";
        return db.fetch(sql);
    }
    
    public ResultSet getPstudent(DBconnect db) throws SQLException
    {
        String sql = "select number,msubject.name as name,pstudentgrade.subid as subid,msubject.credits as credits from pstudentgrade,msubject where pstudentgrade.subid=msubject.subid and pstudentgrade.padmission='"+getAdmission()+"' and pstudentgrade.attempts='"+getAttempt()+"' and pstudentgrade.year='"+getYear()+"' and pstudentgrade.semester='"+getSemester()+"';";
        return db.fetch(sql);
    }

    
    /**
     * @return the subarry
     */
    
    
    /*public boolean saveUsub(DBconnect db) throws SQLException
    {
        String sql = "insert into ustudentgrade(uadmission,subid,year,semester,attempts) values('"+getAdmission()+"','"+getSubarry()[0]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),('"+getAdmission()+"','"+getSubarry()[1]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),('"+getAdmission()+"','"+getSubarry()[2]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),"
                    + "('"+getAdmission()+"','"+getSubarry()[3]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),('"+getAdmission()+"','"+getSubarry()[4]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),('"+getAdmission()+"','"+getSubarry()[5]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"');";
        if(db.query(sql))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public boolean savePsub(DBconnect db) throws SQLException
    {
        String sql = "insert into pstudentgrade(padmission,subid,year,semester,attempts) values('"+getAdmission()+"','"+getSubarry()[0]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),('"+getAdmission()+"','"+getSubarry()[1]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),('"+getAdmission()+"','"+getSubarry()[2]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),"
                    + "('"+getAdmission()+"','"+getSubarry()[3]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),('"+getAdmission()+"','"+getSubarry()[4]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"'),('"+getAdmission()+"','"+getSubarry()[5]+"','"+getYear()+"','"+getSemester()+"','"+getAttempt()+"');";
        if(db.query(sql))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public boolean updateu(DBconnect db,int [] num) throws SQLException
    {
        int i=0;
        for(i=0;i<num.length;i++)
        {
            String sql = "update ustudentgrade set subid='"+subarry[i]+"',attempts='"+getAttempt().trim()+"' where number='"+num[i]+"';";
            if(!db.query(sql))
            {
                return false;
            }
        }
        
        return true;
   
    }
    
    public boolean updatep(DBconnect db,int [] num) throws SQLException
    {
        int i=0;
        for(i=0;i<num.length;i++)
        {
            String sql = "update pstudentgrade set subid='"+subarry[i]+"',attempts='"+getAttempt().trim()+"' where number='"+num[i]+"';";
            if(!db.query(sql))
            {
                return false;
            }
        }
        
        return true;
        
        
    }

   //Related to stgrades interface
    /*public ResultSet showUstudent(DBconnect db) throws SQLException
    {
        String sql = "select uadmission as Admission,attempts as Attempt,marks as Marks from ustudentgrade where subid='"+getSubid()+"' and attempts='"+getAttempt()+"' and year='"+getYear()+"' and semester='"+getSemester()+"';";
        //System.out.println(db.fetch(sql).getString("uadmission"));
        return db.fetch(sql);
    }
    
    public ResultSet showPstudent(DBconnect db) throws SQLException
    {
        String sql = "select padmission as Admission,attempts as Attempt,marks as Marks from pstudentgrade where subid='"+getSubid()+"' and attempts='"+getAttempt()+"' and year='"+getYear()+"' and semester='"+getSemester()+"';";
        return db.fetch(sql);
    }
    
    public boolean resultsave(DBconnect db,int i) throws SQLException
    {
        String sql;
        if(i==1)
        {
            sql = "update ustudentgrade set marks='"+getMarks()+"' where subid='"+getSubid()+"' and uadmission='"+getAdmission()+"' and year='"+getYear()+"' and semester='"+getSemester()+"' and attempts='"+getAttempt()+"';";
        }
        else 
        {
            sql = "update pstudentgrade set marks='"+getMarks()+"' where subid='"+getSubid()+"' and padmission='"+getAdmission()+"' and year='"+getYear()+"' and semester='"+getSemester()+"' and attempts='"+getAttempt()+"';";
        }
        return db.query(sql);
        
    }*/
    
    
    
    /*
    public String count(DBconnect db,int i) throws SQLException
    {
        String sql;
        if(i==1)
        {
            sql = "select count(uadmission) as countn from ustudentgrade where subid='"+getSubid()+"' and year='"+getYear()+"' and semester='"+getSemester()+"';";
        }
        else 
        {
            sql = "select count(padmission) as countn from pstudentgrade where subid='"+getSubid()+"' and year='"+getYear()+"' and semester='"+getSemester()+"';";
            
            
        }
        ResultSet result = db.fetch(sql);
        if(result!=null)
        {
            while(result.next())
            {
                
                return String.valueOf(result.getString("countn"));
            }
        }
        return null;
        
    }
    */

    

    
}
