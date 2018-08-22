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
import nsbm.universityms.model.Payment;

/**
 *
 * @author user
 */
public class PaymentController {
    
    public boolean addPayment(Payment payment,int j) throws SQLException, ClassNotFoundException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql1,sql2;
        if(j==1)
        {
            sql1 = "insert into payment(paymentid,year,semester,amount,date) values(?,?,?,?,?);";
            sql2 = "insert into bpayment(paymentid,anumber) values(?,?);";
        }
        else 
        {
            sql1 = "insert into payment(paymentid,year,semester,amount,date) values(?,?,?,?,?);";
            sql2 = "insert into mpayment(paymentid,anumber) values(?,?);";
        }
        
        String [] info = {payment.getPaymentid(),payment.getYear(),payment.getSemester(),payment.getAmount(),payment.getDate()};
        PreparedStatement stm1 = connection.prepareStatement(sql1);
        PreparedStatement stm2 = connection.prepareStatement(sql2);
        int i=0;
        for (i = 0; i < info.length; i++) {
            stm1.setObject(i+1,info[i]);
        }
        stm2.setObject(1, payment.getPaymentid());
        stm2.setObject(2, payment.getAnumber());
        return stm1.executeUpdate()>0 && stm1.executeUpdate()>0;
    }
    public ResultSet retrieveSubjects(Payment payment,int i) throws ClassNotFoundException, SQLException
    {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String sql;              
        if(i==1)
        {
            sql = "select ustudentgrade.subid as Subject,bsubject.name as Name,bsubject.price as Price from ustudentgrade,bsubject where ustudentgrade.subid=bsubject.bsubid and ustudentgrade.uadmission=?;";   
        }
        else 
        {
            sql = "select pstudentgrade.subid as Subject,msubject.name as Name,msubject.price as Price from pstudentgrade,msubject where pstudentgrade.subid=msubject.subid and pstudentgrade.padmission=?;";
        }
        
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1,payment.getAnumber());
        return stm.executeQuery();
    }
}
