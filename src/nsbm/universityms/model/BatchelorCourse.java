/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.universityms.model;


 /**
 * @author user
 */
public class BatchelorCourse extends Course{
    
    private String gyears;
    private String credits;
    private String syear;
    
    /**
     * @return the gyears
     */
    public String getGyears() {
        return gyears;
    }

    /**
     * @param gyears the gyears to set
     */
    public void setGyears(String gyears) {
        this.gyears = gyears;
    }

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
     * @return the syear
     */
    public String getSyear() {
        return syear;
    }

    /**
     * @param syear the syear to set
     */
    public void setSyear(String syear) {
        this.syear = syear;
    }
    
}