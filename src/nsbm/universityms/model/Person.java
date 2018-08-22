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
public class Person {

    private String id;
    private String name;
    private String address;
    private String mobile;
    private String email;
    private String dob;
    private String gender;
    
    
    public Person()
    {
        
    }
    
    
    
    public void setPerson(String id,String name,String address,String mobile,String dob,String gender)
    {
        this.setId(id);
        this.setName(name);
        this.setDob(dob);
        this.setAddress(address);
        this.setMobile(mobile);
        this.setGender(gender);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
}
