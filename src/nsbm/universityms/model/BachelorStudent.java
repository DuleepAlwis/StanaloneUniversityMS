/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.universityms.model;


/**
 *
 * @author Dulip
 */
public class BachelorStudent extends Student{
    
    private String stream;
    private String sub1;
    private String sub2;
    private String sub3;
    
    
    public BachelorStudent()
    {
        
    }
 
    /**
     * @return the stream
     */
    public String getStream() {
        return stream;
    }

    /**
     * @param stream the stream to set
     */
    public void setStream(String stream) {
        this.stream = stream;
    }

    /**
     * @return the sub1
     */
    public String getSub1() {
        return sub1;
    }

    /**
     * @param sub1 the sub1 to set
     */
    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    /**
     * @return the sub2
     */
    public String getSub2() {
        return sub2;
    }

    /**
     * @param sub2 the sub2 to set
     */
    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }

    /**
     * @return the sub3
     */
    public String getSub3() {
        return sub3;
    }

    /**
     * @param sub3 the sub3 to set
     */
    public void setSub3(String sub3) {
        this.sub3 = sub3;
    }
    
    
    
    
    
}
