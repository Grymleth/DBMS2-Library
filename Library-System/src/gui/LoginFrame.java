package gui;

import oracledb.SQLCore;
import customclass.LibUser;
import java.awt.Frame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aevan
 */
public class LoginFrame extends javax.swing.JFrame {
    LoginFrame thisInstance = this;
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        
        // set position to middle
        this.setLocationRelativeTo(null);
        // set close operation close
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPane = new javax.swing.JPanel();
        titlePane = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        miniBtn = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();
        userLbl = new javax.swing.JLabel();
        passLbl = new javax.swing.JLabel();
        userFld = new javax.swing.JTextField();
        passFld = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        titlePane.setBackground(new java.awt.Color(18, 203, 196));
        titlePane.setLayout(null);

        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setText("X");
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtnMouseClicked(evt);
            }
        });
        titlePane.add(exitBtn);
        exitBtn.setBounds(427, 13, 25, 44);

        miniBtn.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        miniBtn.setForeground(new java.awt.Color(255, 255, 255));
        miniBtn.setText("-");
        miniBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniBtnMouseClicked(evt);
            }
        });
        titlePane.add(miniBtn);
        miniBtn.setBounds(393, 13, 16, 44);

        titleLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(255, 255, 255));
        titleLbl.setText("Samgyupsalibrary");
        titlePane.add(titleLbl);
        titleLbl.setBounds(20, 10, 214, 44);

        contentPane.setBackground(new java.awt.Color(196, 229, 56));

        userLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userLbl.setForeground(new java.awt.Color(255, 255, 255));
        userLbl.setText("Username:");

        passLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passLbl.setForeground(new java.awt.Color(255, 255, 255));
        passLbl.setText("Password:");

        userFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userFldKeyPressed(evt);
            }
        });

        passFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFldActionPerformed(evt);
            }
        });
        passFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passFldKeyPressed(evt);
            }
        });

        loginBtn.setBackground(new java.awt.Color(6, 82, 221));
        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        registerBtn.setBackground(new java.awt.Color(237, 76, 103));
        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("Sign Up");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(registerBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLbl)
                    .addComponent(userFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLbl)
                    .addComponent(passFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
        loginPane.setLayout(loginPaneLayout);
        loginPaneLayout.setHorizontalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePane, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loginPaneLayout.setVerticalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addComponent(titlePane, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFldActionPerformed

    private void miniBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniBtnMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_miniBtnMouseClicked

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitBtnMouseClicked

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String username = userFld.getText();
        String password = new String(passFld.getPassword());
        
        LibUser theUser;
        theUser = SQLCore.authenticateUser(username, password);
        if(theUser != null){
            JOptionPane.showMessageDialog(this, "Login Successful", "Noice!", JOptionPane.INFORMATION_MESSAGE);
            printUser(theUser);
        }
        else{
            JOptionPane.showMessageDialog(this, "ERP", "not noice!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        PatronFrame patronWindow = new PatronFrame(theUser);
        patronWindow.setVisible(true);
        
        this.setVisible(false);
        
        patronWindow.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                thisInstance.setVisible(true);
            }
        });
    }//GEN-LAST:event_loginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        RegisterDialog regDialog = new RegisterDialog(this, true);
        regDialog.setVisible(true);
        regDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                
            }
        });
    }//GEN-LAST:event_registerBtnActionPerformed

    private void passFldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passFldKeyPressed
        if(evt.getKeyChar() == '\n'){
            loginBtn.doClick();
        }
    }//GEN-LAST:event_passFldKeyPressed

    private void userFldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userFldKeyPressed

    }//GEN-LAST:event_userFldKeyPressed

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
    
    public static void printUser(LibUser user){
        System.out.printf("%d, %s, %s, %s, %s, %c, %d\n",
                user.userId,
                user.loginid,
                user.fName,
                user.lName,
                user.address,
                user.librarian,
                user.fines);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPane;
    private javax.swing.JLabel miniBtn;
    private javax.swing.JPasswordField passFld;
    private javax.swing.JLabel passLbl;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JPanel titlePane;
    private javax.swing.JTextField userFld;
    private javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables
}
