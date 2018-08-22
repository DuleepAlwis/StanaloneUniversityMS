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
public class PostgraduateStudent extends Student{
    
    private String qualification;
    private String ginstitute;
    private String gyear;

    /**
     * @return the qualification
     */
    
    
    
   
    
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @return the ginstitute
     */
    public String getGinstitute() {
        return ginstitute;
    }

    /**
     * @param ginstitute the ginstitute to set
     */
    public void setGinstitute(String ginstitute) {
        this.ginstitute = ginstitute;
    }

    /**
     * @return the gyear
     */
    public String getGyear() {
        return gyear;
    }

    /**
     * @param gyear the gyear to set
     */
    public void setGyear(String gyear) {
        this.gyear = gyear;
    }
    
    
}
