/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm.universityms.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import nsbm.university.controller.StudentsubController;
import nsbm.universityms.model.StudentSubject;




/**
 *
 * @author Dulip
 */
public class AssignmentGrades extends javax.swing.JInternalFrame {

    /**
     * Creates new form assignmentgr
     */
    int i; //i=1 ugraduate i=2 pgraduate
    StudentSubject studentsubject = new StudentSubject();
    StudentsubController stsubcontrol = new StudentsubController();
    public AssignmentGrades() {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        student = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        ugraduate = new javax.swing.JCheckBox();
        pgraduate = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        year = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        semester = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        subject = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        asgnumber = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        marks = new javax.swing.JSpinner();
        save = new javax.swing.JButton();
        change = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        attempt = new javax.swing.JSpinner();
        show = new javax.swing.JButton();
        admission = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        caption = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Assignment grades");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "", ""
            }
        ));
        student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(student);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ugraduate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ugraduate.setText("Undergraduate");
        ugraduate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ugraduateActionPerformed(evt);
            }
        });

        pgraduate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pgraduate.setText("Postgraduate");
        pgraduate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pgraduateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Year");

        year.setModel(new javax.swing.SpinnerListModel(new String[] {"2013", "2014", "2015", "2016", "2017"}));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Semester");

        semester.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Subject");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Admission number");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Assignment number");

        asgnumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Marks");

        marks.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        save.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        change.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        change.setText("Change");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Attempt");

        attempt.setModel(new javax.swing.SpinnerNumberModel(1, 1, 13, 1));

        show.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        show.setText("Show");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ugraduate))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(pgraduate))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel8)
                                .addGap(59, 59, 59)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                        .addComponent(attempt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(asgnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(marks, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(admission, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(change)
                .addGap(88, 88, 88)
                .addComponent(cancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ugraduate)
                    .addComponent(pgraduate))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(semester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(attempt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asgnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(marks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(change)
                    .addComponent(cancel))
                .addGap(117, 117, 117))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(405, 405, 405))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(caption, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(384, 384, 384))))
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(caption)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        
        studentsubject.setAdmission(admission.getText());
        studentsubject.setSubid(subject.getText());
        studentsubject.setAssignment(asgnumber.getSelectedItem().toString());
        studentsubject.setAttempt(attempt.getValue().toString());
        studentsubject.setMarks(marks.getValue().toString());
        try
        {
            
            if(stsubcontrol.updateAssignmentmarks(studentsubject, i))
            {
                JOptionPane.showMessageDialog(rootPane,"Data updated successfully");
            }
            else 
            {
                JOptionPane.showMessageDialog(rootPane,"Data updated unsuccess");
            }
         
        }
        catch (SQLException ex) {
            Logger.getLogger(StudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AssignmentGrades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
        
    }//GEN-LAST:event_changeActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
        studentsubject.setAdmission(admission.getText());
        studentsubject.setSubid(subject.getText());
        studentsubject.setAssignment(asgnumber.getSelectedItem().toString());
        studentsubject.setAttempt(attempt.getValue().toString());
        studentsubject.setMarks(marks.getValue().toString());
        try
        {
            
            if(stsubcontrol.addAssignmentmarks(studentsubject, i))
            {
                JOptionPane.showMessageDialog(rootPane,"Data inserted successfully");
            }
             else 
            {
                JOptionPane.showMessageDialog(rootPane,"Data inserted unsuccess");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentSubject.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AssignmentGrades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
        
            
    }//GEN-LAST:event_saveActionPerformed

    private void ugraduateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ugraduateActionPerformed
        i=1;
        pgraduate.setSelected(false);
    }//GEN-LAST:event_ugraduateActionPerformed

    private void pgraduateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pgraduateActionPerformed
        i=2;
        ugraduate.setSelected(false);
    }//GEN-LAST:event_pgraduateActionPerformed

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        
        tableload();
    }//GEN-LAST:event_showActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
       
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentMouseClicked
        int r = student.getSelectedRow();
        admission.setText(student.getValueAt(r, 0).toString());
    }//GEN-LAST:event_studentMouseClicked

    private void tableload() 
    {
        
        
        studentsubject.setAttempt(attempt.getValue().toString());
        
        studentsubject.setYear(year.getValue().toString());
        studentsubject.setSemester(semester.getValue().toString());
        studentsubject.setSubid(subject.getText());
        caption.setText(subject.getText());
        
        try
        {
            
            
            ResultSet result = stsubcontrol.retrieveAssignmentmarks(studentsubject, i);
            if(result!=null)
            {
               student.setModel(DbUtils.resultSetToTableModel(result));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StGrades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AssignmentGrades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,ex.getMessage());
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField admission;
    private javax.swing.JComboBox<String> asgnumber;
    private javax.swing.JSpinner attempt;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel caption;
    private javax.swing.JButton change;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner marks;
    private javax.swing.JCheckBox pgraduate;
    private javax.swing.JButton save;
    private javax.swing.JSpinner semester;
    private javax.swing.JButton show;
    private javax.swing.JTable student;
    private javax.swing.JTextField subject;
    private javax.swing.JCheckBox ugraduate;
    private javax.swing.JSpinner year;
    // End of variables declaration//GEN-END:variables
}
