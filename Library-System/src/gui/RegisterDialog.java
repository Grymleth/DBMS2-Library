/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import customclass.LibUser;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oracledb.SQLCore;

/**
 *
 * @author aevan
 */
public class RegisterDialog extends javax.swing.JDialog {

    
    /**
     * Creates new form RegisterDialog
     */
    public RegisterDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerPane = new javax.swing.JPanel();
        contentPane = new javax.swing.JPanel();
        userLbl = new javax.swing.JLabel();
        passLbl = new javax.swing.JLabel();
        userFld = new javax.swing.JTextField();
        passFld = new javax.swing.JPasswordField();
        regBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        fNameLbl = new javax.swing.JLabel();
        lNameLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        confirmPassFld = new javax.swing.JPasswordField();
        confirmPassLbl = new javax.swing.JLabel();
        librarianCheck = new javax.swing.JCheckBox();
        fNameFld = new javax.swing.JTextField();
        addressFld = new javax.swing.JTextField();
        lNameFld = new javax.swing.JTextField();
        titlePane = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        contentPane.setBackground(new java.awt.Color(196, 229, 56));

        userLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userLbl.setForeground(new java.awt.Color(255, 255, 255));
        userLbl.setText("Username:");

        passLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passLbl.setForeground(new java.awt.Color(255, 255, 255));
        passLbl.setText("Password:");

        userFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFldActionPerformed(evt);
            }
        });

        regBtn.setBackground(new java.awt.Color(6, 82, 221));
        regBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        regBtn.setForeground(new java.awt.Color(255, 255, 255));
        regBtn.setText("Register");
        regBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(237, 76, 103));
        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        fNameLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        fNameLbl.setText("First Name:");

        lNameLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        lNameLbl.setText("Last Name:");

        addressLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addressLbl.setForeground(new java.awt.Color(255, 255, 255));
        addressLbl.setText("Address:");

        confirmPassFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confirmPassFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassFldActionPerformed(evt);
            }
        });

        confirmPassLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confirmPassLbl.setForeground(new java.awt.Color(255, 255, 255));
        confirmPassLbl.setText("Confirm Password:");

        librarianCheck.setBackground(new java.awt.Color(196, 229, 56));
        librarianCheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        librarianCheck.setForeground(new java.awt.Color(255, 255, 255));
        librarianCheck.setText("Librarian?");

        fNameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        addressFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lNameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(librarianCheck)
                .addGap(58, 58, 58))
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(fNameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fNameFld)
                        .addGap(39, 39, 39))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lNameLbl)
                            .addComponent(addressLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressFld)
                            .addComponent(lNameFld))
                        .addGap(40, 40, 40))))
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userLbl)
                    .addComponent(passLbl)
                    .addComponent(confirmPassLbl))
                .addGap(18, 18, 18)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addGap(50, 50, 50)
                        .addComponent(regBtn))
                    .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(userFld, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(confirmPassFld)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fNameLbl)
                    .addComponent(fNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lNameLbl)
                    .addComponent(lNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLbl))
                .addGap(47, 47, 47)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmPassLbl)
                    .addComponent(confirmPassFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(librarianCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

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

        titleLbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLbl.setForeground(new java.awt.Color(255, 255, 255));
        titleLbl.setText("Register");
        titlePane.add(titleLbl);
        titleLbl.setBounds(20, 10, 99, 44);

        javax.swing.GroupLayout registerPaneLayout = new javax.swing.GroupLayout(registerPane);
        registerPane.setLayout(registerPaneLayout);
        registerPaneLayout.setHorizontalGroup(
            registerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePane, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        registerPaneLayout.setVerticalGroup(
            registerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPaneLayout.createSequentialGroup()
                .addComponent(titlePane, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(registerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(registerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFldActionPerformed

    private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regBtnActionPerformed
        char librarian = librarianCheck.isSelected() ? 'Y' : 'N';

        try{
            if(emptyFields(userFld, fNameFld, lNameFld, addressFld)){
                throw new Exception("Empty Fields!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,
                "Some fields are empty",
                "Empty Fields",
                JOptionPane.ERROR_MESSAGE);
        }

        LibUser user = new LibUser(userFld.getText(),
            fNameFld.getText(), lNameFld.getText(),
            addressFld.getText(),
            librarian);

        SQLCore.insertUser(user, new String(passFld.getPassword()));
    }//GEN-LAST:event_regBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void confirmPassFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassFldActionPerformed

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitBtnMouseClicked

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
            java.util.logging.Logger.getLogger(RegisterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterDialog dialog = new RegisterDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    /**
     * Method that checks whether text fields are empty or not
     * @param flds JTextFields you want to check
     * @return true if at least one text field is empty
     */
    public boolean emptyFields(JTextField ... flds){
        for(JTextField item: flds){
            if(item.getText().isEmpty()){
                return true;
            }
        }
        
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressFld;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPasswordField confirmPassFld;
    private javax.swing.JLabel confirmPassLbl;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JTextField fNameFld;
    private javax.swing.JLabel fNameLbl;
    private javax.swing.JTextField lNameFld;
    private javax.swing.JLabel lNameLbl;
    private javax.swing.JCheckBox librarianCheck;
    private javax.swing.JPasswordField passFld;
    private javax.swing.JLabel passLbl;
    private javax.swing.JButton regBtn;
    private javax.swing.JPanel registerPane;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JPanel titlePane;
    private javax.swing.JTextField userFld;
    private javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables
}
