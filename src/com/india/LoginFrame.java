package com.india;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class LoginFrame extends javax.swing.JFrame {
    public LoginFrame() {
        initComponents();
       // checkVersion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoginWindow = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLoginWindow.setText("Login Window");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/india/lock.png"))); // NOI18N

        lblUserName.setLabelFor(txtUserName);
        lblUserName.setText("UserName");

        lblPassword.setLabelFor(txtPassword);
        lblPassword.setText("Password");

        txtUserName.setToolTipText("Enter Username");

        txtPassword.setToolTipText("Enter Password");

        btnRegister.setText("Register");
        btnRegister.setToolTipText("New User Registration");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.setToolTipText("For Existing Users");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegister)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPassword)
                                    .addComponent(lblUserName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblLoginWindow)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLoginWindow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserName)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegister)
                            .addComponent(btnLogin))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtUserName.getAccessibleContext().setAccessibleDescription("Please Enter User Name Here");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
  //Step I: Collect UI Datat into Local Variable
  String u=txtUserName.getText().trim();
  //String p=txtPassword.getText();
  //Converting char[ ] int String using valueOf
  String p=String.valueOf(txtPassword.getPassword());
  //Step II: Validation Check
  if(u.length()<3 || p.length()<3)
  {
      JOptionPane.showMessageDialog(this,"Invalid or Empty User/Password. Try Again ");
      return;     //Terminate Fn
  }
  //Otherwise, Generate Embeded SQL Query
  //Using String.format fn introduced in Jdk1.5
  //Similar to printf but assign it to String
  String sql=String.format("Select * From Users Where Username='%s' and Password='%s' " , u,p) ;
  //JOptionPane.showMessageDialog(this,sql);
  
  //  JOptionPane.showMessageDialog(this,sql);
 //Step IV: Send this Query to DBConnection class
 try{
        ResultSet rs=DBConnection.executeQuery(sql);
        if(rs.next())   //Means User found
        {
         //   checkVersion();  //06-Oct-2017
         new SplashFrame(u,p).setVisible(true); //Open new Frame
             this.dispose();  //To close this Frame
        }
        else   //User Not Found
        {
          sql="Update installation_info set failed_login=failed_login+1";
          DBConnection.executeUpdate(sql);
          DBConnection.commit();
          JOptionPane.showMessageDialog(this, "User/Password Not Found");
        }
     }catch(SQLException e) { JOptionPane.showMessageDialog(this, e.toString());  }        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
       // checkVersion();
    }//GEN-LAST:event_btnRegisterActionPerformed
    private void checkVersion()
    {
        String s="Select version,failed_login,last_accessed, trial_days,(sysdate - install_date) as days, (sysdate-last_accessed) as diff from installation_info";
        
        try(ResultSet rs3=DBConnection.executeQuery(s)) {
            
            if(rs3.next())
            {
                if(Math.round(rs3.getInt("diff"))<=0)
                {
                    JOptionPane.showMessageDialog(null, "Cannot Use Older System Date");
                    System.exit(0);
                }
                int days=rs3.getInt("days");
                int trial=rs3.getInt("trial_days");
                if(days>trial)
                {
                    JOptionPane.showMessageDialog(null, "Trial Expired. Buy Full Version");
                    System.exit(1);
                }
                if(rs3.getInt("failed_login")>=10)
                {
                    JOptionPane.showMessageDialog(null, "Sorry!!! Too many Failed Login");
                    System.exit(2);
                }
                s="Update installation_info set last_accessed=sysdate";
                DBConnection.executeUpdate(s);
                DBConnection.commit();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You are Using Software for the First Time");
                s="Insert into installation_info values('Trial',sysdate, '30',sysdate,0)";
                DBConnection.executeUpdate(s);
                DBConnection.commit();
            }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Trial Expired. Buy Full Version"); 
        }
    }
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLoginWindow;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}