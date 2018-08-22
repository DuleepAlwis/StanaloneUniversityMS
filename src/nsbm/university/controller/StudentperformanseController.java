/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.university.controller;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Multipart;
import nsbm.university.db.DBConnection;
import nsbm.universityms.model.StudentPerformance;
import nsbm.universityms.model.StudentSubject;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author user
 */
public class StudentperformanseController {
    
    public ResultSet retrievestudent(StudentSubject studentsubject,int i) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql;
        
        if(i==1)
        {
            sql = "select admission as Admission,name as Name,email as Email from ustudent where batch=?;";
        }
        else 
        {
            sql = "select admission as Admission,name as Name,email as Email from pstudent where batch=?;";
        }
        
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,studentsubject.getBatch());
        return stm.executeQuery();
    }
    
    
    public ResultSet retrievesubject(StudentSubject studentsubject,int j) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql;
        
        if(j==1)
        {
            sql = "select ustudentgrade.subid as Subid,bsubject.name as Name,ustudentgrade.grade as Grade from ustudentgrade,bsubject where ustudentgrade.subid=bsubject.bsubid and ustudentgrade.uadmission=? and ustudentgrade.year=? and ustudentgrade.semester=? and ustudentgrade.attempts=?;";
        }
        else 
        {
            sql = "select pstudentgrade.subid as Subid,msubject.name as Name,pstudentgrade.grade as Grade from pstudentgrade,msubject where pstudentgrade.subid=msubject.subid and pstudentgrade.padmission=? and pstudentgrade.year=? and pstudentgrade.semester=? and pstudentgrade.attempts=?;";
        }
        
        String [] info = {studentsubject.getAdmission(),studentsubject.getYear(),studentsubject.getSemester(),studentsubject.getAttempt()};
        PreparedStatement stm = connection.prepareStatement(sql);
        int i=0;
        for(i=0;i<info.length;i++)
        {
            stm.setObject(i+1,info[i]);
        }
        
        
        
        return stm.executeQuery();
    }
    
    public boolean filecreate(StudentPerformance studentperformance,String [][] subjects)
    {
        
        File file = new File(studentperformance.getPath());
        System.out.println(studentperformance.getPath());
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getCause());
            }
        }
        else
        {
            System.out.println("File exists");
        }
        
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("\t\t\tYear: "+studentperformance.getYear()+System.lineSeparator());
            writer.write("\t\t\tSemester: "+studentperformance.getSemester()+System.lineSeparator());
            writer.write("\t\t\tAttempt: "+studentperformance.getAttempt()+System.lineSeparator());
            writer.write("\t\t\tBatch: "+studentperformance.getBatch()+System.lineSeparator()+System.lineSeparator());
            writer.write("\tAdmission number: "+studentperformance.getAdmission()+"\tName: "+studentperformance.getName()+System.lineSeparator()+System.lineSeparator());
           
            writer.write(String.format("%20s %20s %20s\r\n", "Subject Code", "Subject Name","Result"));
            
            int j=0;
            for(j=0;j<subjects.length;j++)
            {        
                writer.write(String.format("%20s %20s %20s\r\n", subjects[j][0], subjects[j][1],subjects[j][2]));
            }
            writer.close();
            
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean sendEmail(String [][] subjects,StudentPerformance stperformance) throws IOException, AddressException, javax.mail.MessagingException
    {
        if(!filecreate(stperformance,subjects))
        {
            return false;
        }
        final String username = stperformance.getUser();

	final String password = stperformance.getPassword();

	 final String remail = stperformance.getEmail();

        Properties props = new Properties();
        
	props.put("mail.smtp.host", "smtp.gmail.com");

	props.put("mail.smtp.socketFactory.port", "465");

        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

	                

	props.put("mail.smtp.auth", "true");

	props.put("mail.smtp.port", "465");

	 

	Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {

	                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

	                        return new javax.mail.PasswordAuthentication(stperformance.getUser(),stperformance.getPassword());
	                    }

	                });

	                
        try {

	        javax.mail.Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));

	        message.setRecipients(javax.mail.Message.RecipientType.TO,InternetAddress.parse(remail));

	       

	       
                
               
                Multipart multipart = new MimeMultipart();
                
                
                javax.mail.internet.MimeBodyPart attachPart = new javax.mail.internet.MimeBodyPart();

              
                attachPart.attachFile(stperformance.getPath());
                

                multipart.addBodyPart(attachPart);
                    
            
                message.setContent(multipart);
 
                
       

	        Transport.send(message);           

                System.out.println("Mail sent succesfully!");
                return true;
        
        }catch(javax.mail.MessagingException ex)
        {
            
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
