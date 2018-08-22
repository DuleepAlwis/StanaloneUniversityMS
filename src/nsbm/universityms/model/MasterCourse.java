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
public class MasterCourse extends Course{
    
    private String credits;
    private String year;

    /**
     * @return the credits
     */
    public String getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(String credits) {
        this.credits = credits;
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
    
    
}
