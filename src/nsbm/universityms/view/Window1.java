/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.universityms.view;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Dulip
 */
public class Window1 extends javax.swing.JFrame {

    /**
     * Creates new form window1
     */
    public Window1() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAddstudent = new javax.swing.JMenuItem();
        menuUpdatestudent = new javax.swing.JMenuItem();
        menuStudentsubject = new javax.swing.JMenuItem();
        menuStudentperformance = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuSubjectdetails = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuLabdetails = new javax.swing.JMenuItem();
        menuLabshedule = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuCoursedetails = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menuCalculategrades = new javax.swing.JMenuItem();
        menuAssignmentmarks = new javax.swing.JMenuItem();
        menuSubjectmarks = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuPayment = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 768));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1461, 868));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1094, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 855, Short.MAX_VALUE)
        );

        jMenu1.setText("Student");

        menuAddstudent.setText(" Add student");
        menuAddstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddstudentActionPerformed(evt);
            }
        });
        jMenu1.add(menuAddstudent);

        menuUpdatestudent.setText("Update student");
        menuUpdatestudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUpdatestudentActionPerformed(evt);
            }
        });
        jMenu1.add(menuUpdatestudent);

        menuStudentsubject.setText("Student subjects");
        menuStudentsubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStudentsubjectActionPerformed(evt);
            }
        });
        jMenu1.add(menuStudentsubject);

        menuStudentperformance.setText("Student Performance");
        menuStudentperformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStudentperformanceActionPerformed(evt);
            }
        });
        jMenu1.add(menuStudentperformance);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Subject");

        menuSubjectdetails.setText("Subject Details");
        menuSubjectdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSubjectdetailsActionPerformed(evt);
            }
        });
        jMenu3.add(menuSubjectdetails);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Lab");

        menuLabdetails.setText("Lab Details");
        menuLabdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLabdetailsActionPerformed(evt);
            }
        });
        jMenu4.add(menuLabdetails);

        menuLabshedule.setText("Lab shedule");
        menuLabshedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLabsheduleActionPerformed(evt);
            }
        });
        jMenu4.add(menuLabshedule);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Courses");

        menuCoursedetails.setText("Course details");
        menuCoursedetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCoursedetailsActionPerformed(evt);
            }
        });
        jMenu5.add(menuCoursedetails);

        jMenuBar1.add(jMenu5);

        jMenu8.setText("Grades");

        menuCalculategrades.setText("Calculate Grades");
        menuCalculategrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCalculategradesActionPerformed(evt);
            }
        });
        jMenu8.add(menuCalculategrades);

        menuAssignmentmarks.setText("Assignment Marks");
        menuAssignmentmarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAssignmentmarksActionPerformed(evt);
            }
        });
        jMenu8.add(menuAssignmentmarks);

        menuSubjectmarks.setText("Subject Marks");
        menuSubjectmarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSubjectmarksActionPerformed(evt);
            }
        });
        jMenu8.add(menuSubjectmarks);

        jMenuBar1.add(jMenu8);

        jMenu6.setText("Payment");

        menuPayment.setText("Payment");
        menuPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPaymentActionPerformed(evt);
            }
        });
        jMenu6.add(menuPayment);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuUpdatestudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUpdatestudentActionPerformed
        jDesktopPane1.removeAll();
        UpdateStudent stupdate = new UpdateStudent();
        stupdate.setSize(1370, 868);
        
        jDesktopPane1.add(stupdate).setVisible(true);
        try {
            stupdate.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuUpdatestudentActionPerformed

    private void menuSubjectdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSubjectdetailsActionPerformed
        jDesktopPane1.removeAll();
        AddSubject subject = new AddSubject();
        subject.setSize(1370, 868);
        
        jDesktopPane1.add(subject).setVisible(true);
        try {
            subject.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuSubjectdetailsActionPerformed

    private void menuAddstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddstudentActionPerformed
        jDesktopPane1.removeAll();
        AddStudent astudent = new AddStudent();
        astudent.setSize(1370, 868);
        jDesktopPane1.add(astudent).setVisible(true);
        try {
            astudent.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_menuAddstudentActionPerformed

    private void menuLabsheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLabsheduleActionPerformed
        jDesktopPane1.removeAll();
        LabAllocate lab = new LabAllocate();
        lab.setSize(1370, 868);
        
        jDesktopPane1.add(lab).setVisible(true);
        try {
            lab.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuLabsheduleActionPerformed

    private void menuStudentsubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuStudentsubjectActionPerformed
        jDesktopPane1.removeAll();
        StudentSubjectview stsubject = new StudentSubjectview();
        stsubject.setSize(1370, 868);
        
        jDesktopPane1.add(stsubject).setVisible(true);
        try {
            stsubject.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuStudentsubjectActionPerformed

    private void menuLabdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLabdetailsActionPerformed
        jDesktopPane1.removeAll();
       Labview lab = new Labview();
        lab.setSize(1370, 868);
        
        jDesktopPane1.add(lab).setVisible(true);
        try {
            lab.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuLabdetailsActionPerformed

    private void menuCoursedetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCoursedetailsActionPerformed
        jDesktopPane1.removeAll();
       CourseDetails course = new CourseDetails();
        course.setSize(1370, 868);
        
        jDesktopPane1.add(course).setVisible(true);
        try {
            course.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuCoursedetailsActionPerformed

    private void menuCalculategradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCalculategradesActionPerformed
        jDesktopPane1.removeAll();
        CalculateGrade cal = new CalculateGrade();
        cal.setSize(1370, 868);
        
        jDesktopPane1.add(cal).setVisible(true);
        try {
            cal.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuCalculategradesActionPerformed

    private void menuAssignmentmarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAssignmentmarksActionPerformed
        jDesktopPane1.removeAll();
        AssignmentGrades stassignment = new AssignmentGrades();
        stassignment.setSize(1370, 868);
        
        jDesktopPane1.add(stassignment).setVisible(true);
        try {
            stassignment.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuAssignmentmarksActionPerformed

    private void menuSubjectmarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSubjectmarksActionPerformed
        jDesktopPane1.removeAll();
        StGrades stgrades = new StGrades();
        stgrades.setSize(1370, 868);
        
        jDesktopPane1.add(stgrades).setVisible(true);
        try {
            stgrades.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuSubjectmarksActionPerformed

    private void menuStudentperformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuStudentperformanceActionPerformed
        jDesktopPane1.removeAll();
        StPerformance student = new StPerformance();
        student.setSize(1370, 868);
        
        jDesktopPane1.add(student).setVisible(true);
        try {
            student.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuStudentperformanceActionPerformed

    private void menuPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPaymentActionPerformed
        jDesktopPane1.removeAll();
        Paymentform payment = new Paymentform();
        payment.setSize(1370, 868);
        
        jDesktopPane1.add(payment).setVisible(true);
        try {
            payment.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Window1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuPaymentActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuAddstudent;
    private javax.swing.JMenuItem menuAssignmentmarks;
    private javax.swing.JMenuItem menuCalculategrades;
    private javax.swing.JMenuItem menuCoursedetails;
    private javax.swing.JMenuItem menuLabdetails;
    private javax.swing.JMenuItem menuLabshedule;
    private javax.swing.JMenuItem menuPayment;
    private javax.swing.JMenuItem menuStudentperformance;
    private javax.swing.JMenuItem menuStudentsubject;
    private javax.swing.JMenuItem menuSubjectdetails;
    private javax.swing.JMenuItem menuSubjectmarks;
    private javax.swing.JMenuItem menuUpdatestudent;
    // End of variables declaration//GEN-END:variables
}
