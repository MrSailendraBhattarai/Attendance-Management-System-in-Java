/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancems_with_prepared22;

import java.awt.Color;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Iqbal-Asi
 */
public class NewTeacherInternalFrame extends javax.swing.JInternalFrame {
ConnectClass c;
Validation v;
    /**
     * Creates new form TeacherInternalFrame
     */
    public NewTeacherInternalFrame() {
        initComponents();
        c =new ConnectClass();
        v = new Validation();
        setTitle("New Teacher");
        
        // Calling Auto ID Generating Method
        getID();
                
        //Showing Data in jTable
        getTeacherData();
        
        jTable1Teacher.setSelectionForeground(Color.WHITE);
        
        //Filling Combo
        statusCombo();
        
    }
    
    /**
     * Auto Generating ID
     */
    public void getID (){
        try {
            ResultSet rs = c.st.executeQuery("select max(teacher_id) from tbl_teacher");
            if(rs.next()) {
                int stdID = Integer.parseInt(rs.getString(1))+1;
                jLabel7.setText(String.valueOf(stdID));
            }
            
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    /**
     * Teacher's with true status 
     */
    public void getTeacherData() {
        try {
            DefaultTableModel dt = (DefaultTableModel)jTable1Teacher.getModel();
            
            
            ResultSet rs = c.st.executeQuery("select teacher_id as 'Teacher Id', user_name as 'User Name', teacher_name as 'Teacher Name', teacher_pass as 'Teacher Password', teacher_status as 'Teacher Status', added_on as 'Added On' from tbl_teacher where teacher_status = 'true'");
            while (rs.next()) {
                dt.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
            jTable1Teacher.setModel(dt);
            
                    
            
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Teacher Data
     */
    public void getWholeTeacherData() {
        try {
            DefaultTableModel dt = (DefaultTableModel)jTable1Teacher.getModel();
            
            
            ResultSet rs = c.st.executeQuery("select teacher_id as 'Teacher Id', user_name as 'User Name', teacher_name as 'Teacher Name', teacher_pass as 'Teacher Password', teacher_status as 'Teacher Status', added_on as 'Added On' from tbl_teacher");
            while (rs.next()) {
                dt.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
            jTable1Teacher.setModel(dt);
            
                    
            
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
   
    /**
     * Clearing Rows from jTable1
     */
    public void clearingTabel(){
        try {
            /**
             * Clearing Rows from jTable1
             */
            DefaultTableModel dm = (DefaultTableModel) jTable1Teacher.getModel();
            int rowCount = dm.getRowCount();
            //Remove rows one by one from the end of the table
            for (int i = rowCount - 1; i >= 0; i--) {
                dm.removeRow(i);
            }   
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    /**
    * Clearing the Text fields
    */
    public void clearing(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBoxStatus.setSelectedIndex(0);
        jDateChooser1.setCalendar(null);
        getID();
    }
    
    /**
     * Status ComboBox
     */
    public void statusCombo(){
        jComboBoxStatus.addItem("true");
        jComboBoxStatus.addItem("false");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1Teacher = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(990, 550));
        setMinimumSize(new java.awt.Dimension(990, 550));
        setPreferredSize(new java.awt.Dimension(990, 550));
        setRequestFocusEnabled(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Teacher ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 60, 100, 30);

        jLabel2.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Teacher Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(550, 60, 100, 30);

        jLabel3.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 100, 100, 30);

        jLabel4.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(550, 100, 100, 30);

        jTextField1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 100, 170, 30);

        jTextField2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jTextField2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField2CaretUpdate(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(660, 60, 180, 30);

        jTextField3.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jTextField3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField3CaretUpdate(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(660, 100, 180, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancems_with_prepared22/Project_Images/add.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 240, 110, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancems_with_prepared22/Project_Images/remove.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 240, 110, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancems_with_prepared22/Project_Images/viewAll.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(640, 240, 110, 30);

        jTable1Teacher.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jTable1Teacher.setForeground(new java.awt.Color(255, 255, 255));
        jTable1Teacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher Id", "User Name", "Teacher Name", "Teacher Password", "Teacher Status", "Added On"
            }
        ));
        jTable1Teacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1TeacherMouseClicked(evt);
            }
        });
        jTable1Teacher.setOpaque(false);
        ((DefaultTableCellRenderer)jTable1Teacher.getDefaultRenderer(Object.class)).setOpaque(false);

        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        jTable1Teacher.setShowGrid(false);
        jScrollPane1.setViewportView(jTable1Teacher);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 310, 800, 160);

        jLabel5.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teacher Status");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 140, 100, 30);

        jLabel6.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(550, 140, 100, 30);

        jLabel7.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(210, 50, 170, 30);

        jDateChooser1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        getContentPane().add(jDateChooser1);
        jDateChooser1.setBounds(660, 140, 180, 30);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(390, 100, 70, 30);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(860, 60, 70, 30);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(860, 100, 70, 30);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancems_with_prepared22/Project_Images/clear.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(510, 240, 110, 30);

        jComboBoxStatus.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        getContentPane().add(jComboBoxStatus);
        jComboBoxStatus.setBounds(210, 140, 170, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancems_with_prepared22/Project_Images/update.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(380, 240, 110, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/attendancems_with_prepared22/Project_Images/FrameBG.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 990, 520);

        setBounds(0, 0, 990, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String d = sdf.format(jDateChooser1.getDate());
            int a = c.st.executeUpdate("insert into tbl_teacher values ("+jLabel7.getText()+",'"+jTextField1.getText().trim() +"','"+jTextField2.getText().trim()+"','"+jTextField3.getText().trim()+ "','"+jComboBoxStatus.getSelectedItem()+"','"+d.trim()+"')");
            
            JOptionPane.showMessageDialog(null, "New Teacher is Added");
            clearing();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        getID();
        clearing();
        clearingTabel();
        getTeacherData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            c.st.executeUpdate("update tbl_teacher set teacher_status = 'false' where teacher_id = '"+jLabel7.getText()+"'");
            clearing();
            
            JOptionPane.showMessageDialog(null, "Teacher is Removed");
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        clearingTabel();
        getWholeTeacherData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clearingTabel();
        getWholeTeacherData();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1TeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1TeacherMouseClicked
        // TODO add your handling code here:
        int i = jTable1Teacher.getSelectedRow();
        jLabel7.setText(jTable1Teacher.getValueAt(i, 0).toString());
        jTextField1.setText(jTable1Teacher.getValueAt(i, 1).toString().trim());
        jTextField2.setText(jTable1Teacher.getValueAt(i, 2).toString().trim());
        jTextField3.setText(jTable1Teacher.getValueAt(i, 3).toString().trim());
        jComboBoxStatus.setSelectedItem(jTable1Teacher.getValueAt(i, 4).toString().trim());
        
        
    }//GEN-LAST:event_jTable1TeacherMouseClicked

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        // TODO add your handling code here:
        jLabel8.setText(v.validateData("[a-z0-9]{3,30}", jTextField1.getText()));
        if (jLabel8.getText().equals("Valid")) {
            jLabel8.setForeground(Color.green);
        }
        else {
            jLabel8.setForeground(Color.red);
        }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTextField2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField2CaretUpdate
        // TODO add your handling code here:
         jLabel10.setText(v.validateData("[A-Z a-z]{3,30}", jTextField2.getText()));
        if (jLabel10.getText().equals("Valid")) {
            jLabel10.setForeground(Color.green);
        }
        else {
            jLabel10.setForeground(Color.red);
        }
    }//GEN-LAST:event_jTextField2CaretUpdate

    private void jTextField3CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField3CaretUpdate
        // TODO add your handling code here:
         jLabel11.setText(v.validateData("[a-z0-9]{3,30}", jTextField3.getText()));
        if (jLabel11.getText().equals("Valid")) {
            jLabel11.setForeground(Color.green);
        }
        else {
            jLabel11.setForeground(Color.red);
        }
    }//GEN-LAST:event_jTextField3CaretUpdate

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        clearing();
         
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        
        /**
         * Restricting Using from Marking Attendance on future date
         */
        try{
            //JDateChooser Format
            SimpleDateFormat comparedate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String finaldate = comparedate.format(jDateChooser1.getDate());
            
            //Current Date Formats
            DateFormat dateFormatcurrrent = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            String matchdate = dateFormatcurrrent.format(date);
            
            if(finaldate.compareTo(matchdate) > 0){
                JOptionPane.showMessageDialog(null, "Your can't Add future date", "Future Date", JOptionPane.WARNING_MESSAGE);
                jButton1.setEnabled(false);
            }
            else {
                jButton1.setEnabled(true);
            }
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String d = sdf.format(jDateChooser1.getDate());
            
            //c.st.executeUpdate("update tbl_teacher set  user_name = '"+jTextField1.getText()+"', teacher_name = '"+jTextField2.getText()+"', teacher_pass = '"+jTextField3.getText()+"', teacher_status = '"+jComboBoxStatus.getSelectedItem()+"', added_on = '"+d+"' where teacher_id = ?");
            
            PreparedStatement pst = c.xc.prepareStatement("update tbl_teacher set  user_name = ?, teacher_name = ?, teacher_pass = ?, teacher_status = ?, added_on = ? where teacher_id = ?");
            pst.setString(1, jTextField1.getText().trim());
            pst.setString(2, jTextField2.getText().trim());
            pst.setString(3, jTextField3.getText().trim());
            pst.setString(4, jComboBoxStatus.getSelectedItem().toString());
            pst.setString(5, d.trim());
            pst.setString(6, jLabel7.getText());
            
            pst.executeUpdate();
            
            clearing();
            
            JOptionPane.showMessageDialog(null, "Teacher is Updated");
        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        clearingTabel();
        getWholeTeacherData();
        
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1Teacher;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables



}