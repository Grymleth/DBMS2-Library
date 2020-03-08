/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import customclass.LibUser;
import customclass.LibUserView;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oracledb.SQLCore;

/**
 *
 * @author aevan
 */
public class EditUserDialog extends javax.swing.JDialog {
    private LibUser user;
    private LibUserView userList;
    /**
     * Creates new form EditUserDialog
     */
    public EditUserDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    public EditUserDialog(java.awt.Frame parent, boolean modal, LibUser user){
        this(parent, modal);
        this.user = user;
        this.userList = new LibUserView();
        this.userList.fill();
        initFields();
    };

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
        userFld = new javax.swing.JTextField();
        regBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        fNameLbl = new javax.swing.JLabel();
        lNameLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        librarianCheck = new javax.swing.JCheckBox();
        fNameFld = new javax.swing.JTextField();
        addressFld = new javax.swing.JTextField();
        lNameFld = new javax.swing.JTextField();
        changeFirstNameBtn = new javax.swing.JButton();
        changeLastNameBtn = new javax.swing.JButton();
        changeAddressBtn = new javax.swing.JButton();
        changeUsernameBtn = new javax.swing.JButton();
        titlePane = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        registerPane.setPreferredSize(new java.awt.Dimension(480, 530));
        registerPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentPane.setBackground(new java.awt.Color(196, 229, 56));

        userLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userLbl.setForeground(new java.awt.Color(255, 255, 255));
        userLbl.setText("Username:");

        userFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userFld.setEnabled(false);

        regBtn.setBackground(new java.awt.Color(6, 82, 221));
        regBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        regBtn.setForeground(new java.awt.Color(255, 255, 255));
        regBtn.setText("Apply");
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

        librarianCheck.setBackground(new java.awt.Color(196, 229, 56));
        librarianCheck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        librarianCheck.setForeground(new java.awt.Color(255, 255, 255));
        librarianCheck.setText("Librarian?");

        fNameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fNameFld.setEnabled(false);

        addressFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addressFld.setEnabled(false);

        lNameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lNameFld.setEnabled(false);

        changeFirstNameBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        changeFirstNameBtn.setText("Change");
        changeFirstNameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFirstNameBtnActionPerformed(evt);
            }
        });

        changeLastNameBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        changeLastNameBtn.setText("Change");
        changeLastNameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLastNameBtnActionPerformed(evt);
            }
        });

        changeAddressBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        changeAddressBtn.setText("Change");
        changeAddressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAddressBtnActionPerformed(evt);
            }
        });

        changeUsernameBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        changeUsernameBtn.setText("Change");
        changeUsernameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUsernameBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fNameLbl)
                    .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addressLbl)
                        .addComponent(lNameLbl)
                        .addComponent(userLbl)))
                .addGap(18, 18, 18)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(addressFld, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changeAddressBtn))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(fNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changeFirstNameBtn))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(lNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changeLastNameBtn))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(cancelBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(regBtn))
                            .addComponent(librarianCheck)
                            .addComponent(userFld, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changeUsernameBtn)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fNameLbl)
                    .addComponent(changeFirstNameBtn))
                .addGap(8, 8, 8)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(changeLastNameBtn)
                        .addGap(18, 18, 18)
                        .addComponent(addressLbl)
                        .addGap(53, 53, 53))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lNameLbl)
                            .addComponent(lNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeAddressBtn))
                        .addGap(55, 55, 55)))
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLbl)
                    .addComponent(changeUsernameBtn))
                .addGap(18, 18, 18)
                .addComponent(librarianCheck)
                .addGap(18, 18, 18)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );

        registerPane.add(contentPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 480, 460));

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
        titleLbl.setText("Edit User");
        titlePane.add(titleLbl);
        titleLbl.setBounds(20, 10, 190, 44);

        registerPane.add(titlePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

            return;
        }

        LibUser user = userList.findUserByLoginId(userFld.getText());
        if(user != null){
            JOptionPane.showMessageDialog(this, 
                    "Username already exists",
                    "Invalid Username",
                    JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        
        int x = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm",JOptionPane.YES_NO_OPTION);

        if(x==JOptionPane.NO_OPTION){
            return;
        }
        String[] details = {Integer.toString(user.userId), 
            fNameFld.getText(), 
            lNameFld.getText(), 
            addressFld.getText(),
            userFld.getText(),
            Character.toString(librarian)};
        SQLCore.editUser(details);
        
        JOptionPane.showMessageDialog(this,
            "You have successfully edited",
            "Success",
            JOptionPane.INFORMATION_MESSAGE);

        cancelBtn.doClick();
    }//GEN-LAST:event_regBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        cancelBtn.doClick();
    }//GEN-LAST:event_exitBtnMouseClicked

    private void changeFirstNameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFirstNameBtnActionPerformed
        fNameFld.setEnabled(true);
    }//GEN-LAST:event_changeFirstNameBtnActionPerformed

    private void changeLastNameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeLastNameBtnActionPerformed
        lNameFld.setEnabled(true);
    }//GEN-LAST:event_changeLastNameBtnActionPerformed

    private void changeAddressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAddressBtnActionPerformed
        addressFld.setEnabled(true);
    }//GEN-LAST:event_changeAddressBtnActionPerformed

    private void changeUsernameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUsernameBtnActionPerformed
        userFld.setEnabled(true);
    }//GEN-LAST:event_changeUsernameBtnActionPerformed

    
    public boolean emptyFields(JTextField ... flds){
        for(JTextField item: flds){
            if(item.getText().isEmpty()){
                return true;
            }
        }
        
        return false;
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
            java.util.logging.Logger.getLogger(EditUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditUserDialog dialog = new EditUserDialog(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressFld;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton changeAddressBtn;
    private javax.swing.JButton changeFirstNameBtn;
    private javax.swing.JButton changeLastNameBtn;
    private javax.swing.JButton changeUsernameBtn;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JTextField fNameFld;
    private javax.swing.JLabel fNameLbl;
    private javax.swing.JTextField lNameFld;
    private javax.swing.JLabel lNameLbl;
    private javax.swing.JCheckBox librarianCheck;
    private javax.swing.JButton regBtn;
    private javax.swing.JPanel registerPane;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JPanel titlePane;
    private javax.swing.JTextField userFld;
    private javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables

    private void initFields() {
        System.out.print("User editting: ");
        System.out.println(user);
        userFld.setText(user.loginid);
        fNameFld.setText(user.fName);
        lNameFld.setText(user.lName);
        addressFld.setText(user.address);
        if(user.librarian == 'Y'){
            librarianCheck.doClick();
        }
        
    }
}
