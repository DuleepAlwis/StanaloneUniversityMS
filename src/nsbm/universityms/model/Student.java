/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.universityms.model;


/**
 *
 * @author user
 */
public class Student extends Person{
    
    private String course;
    private String batch;
    private String jdate;
    
    public Student()
    {
    }

   
    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
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

    /**
     * @return the jdate
     */
    public String getJdate() {
        return jdate;
    }

    /**
     * @param jdate the jdate to set
     */
    public void setJdate(String jdate) {
        this.jdate = jdate;
    }
    
    
    
}
