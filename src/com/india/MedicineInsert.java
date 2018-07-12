/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.india;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class MedicineInsert extends javax.swing.JFrame {

    /**
     * Creates new form MedicineInsert
     */
    public MedicineInsert() {
        initComponents();
        String sql="Select m_name from manufacturer";
        try{
        ResultSet rs=DBConnection.executeQuery(sql);
        while(rs.next())
        {
        cbManufacturer.addItem(rs.getString(2));
        }
        }
        catch(Exception e)
        {
            System.out.println(""+e.getMessage());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        up = new javax.swing.JTextField();
        txtManufacturer_id = new javax.swing.JTextField();
        remark = new javax.swing.JTextField();
        ss = new javax.swing.JSpinner();
        txtmname = new javax.swing.JTextField();
        cmbMedicineType = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbManufacturer = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtFormula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Medicines Frame");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel2.setText("Medicine Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setText("Formula");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel4.setText("Manufacturer_Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel5.setText("Unit Price");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel6.setText("Medicine Type");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel8.setText("Strip Size");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel9.setText("Remarks");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 60, 30));
        getContentPane().add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 110, -1));
        getContentPane().add(txtManufacturer_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 110, -1));
        getContentPane().add(remark, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 110, -1));
        getContentPane().add(ss, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 50, -1));
        getContentPane().add(txtmname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 110, -1));

        cmbMedicineType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tablet", "Capsule", "Syrup", "Others" }));
        getContentPane().add(cmbMedicineType, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 110, -1));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jButton2.setText("Cancel");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        jButton3.setText("Back");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, -1, -1));

        cbManufacturer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbManufacturerItemStateChanged(evt);
            }
        });
        getContentPane().add(cbManufacturer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 110, -1));

        jLabel1.setText("Manufacturer_id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));
        getContentPane().add(txtFormula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 //  String id=mid.getText();
 String sql="";
   String mname = txtmname.getText().trim();
        String formula = txtFormula.getText().trim();
        String mid=txtManufacturer_id.getText();
        String price = up.getText().trim();
        String mtype=cmbMedicineType.getSelectedItem().toString();
        String strip=ss.getValue().toString();
        String remarks = remark.getText().trim();
 sql = String.format("insert into medicine(medicine_name,m_id,formula,unitprice,medicine_type,strip_seze,remarks) values ('%s', '%s' , '%s' , '%s' , '%s' , '%s','%s')",mname, mid,formula, price, mtype,strip,remarks);
 try
 {
            JOptionPane.showMessageDialog(null, sql);
            int result = DBConnection.executeUpdate(sql);
            if (result > 0) {
                DBConnection.commit();
               // rs1 = DBConnection.executeQuery("Select * from Medicine order by medicine_id");
                JOptionPane.showMessageDialog(null, "Record Saved Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Sorry Fail to Save Record");
            }
 }
 catch(Exception e)
 {
     System.out.println(""+e.getMessage());
 }
 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbManufacturerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbManufacturerItemStateChanged

        // TODO add your handling code here:
        String sql="Select m_id from manufacturer where m_name='"+cbManufacturer.getSelectedItem()+"'";
        int m;
        try{
        ResultSet rs=DBConnection.executeQuery(sql);
        while(rs.next())
        {
        m=rs.getInt("m_id");
        txtManufacturer_id.setText(""+m);
        }
        }
        catch(Exception e)
        {
            System.out.println(""+e.getMessage());
        }
        
    }//GEN-LAST:event_cbManufacturerItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MedicineInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicineInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicineInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicineInsert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicineInsert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbManufacturer;
    private javax.swing.JComboBox<String> cmbMedicineType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField remark;
    private javax.swing.JSpinner ss;
    private javax.swing.JTextField txtFormula;
    private javax.swing.JTextField txtManufacturer_id;
    private javax.swing.JTextField txtmname;
    private javax.swing.JTextField up;
    // End of variables declaration//GEN-END:variables
}
