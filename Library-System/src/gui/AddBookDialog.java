/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import customclass.SearchBook;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oracledb.SQLCore;

/**
 *
 * @author aevan
 */
public class AddBookDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddBookDialog
     */
    public AddBookDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        registerPane = new javax.swing.JPanel();
        bookTitleLbl = new javax.swing.JPanel();
        shelfLbl = new javax.swing.JLabel();
        shelfFld = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        fNameLbl = new javax.swing.JLabel();
        isbnLbl = new javax.swing.JLabel();
        yearLbl = new javax.swing.JLabel();
        titleFld = new javax.swing.JTextField();
        yearFld = new javax.swing.JTextField();
        isbnFld = new javax.swing.JTextField();
        titlePane = new javax.swing.JPanel();
        exitBtn = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bookTitleLbl.setBackground(new java.awt.Color(196, 229, 56));

        shelfLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        shelfLbl.setForeground(new java.awt.Color(255, 255, 255));
        shelfLbl.setText("Shelf No:");

        shelfFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        addBtn.setBackground(new java.awt.Color(6, 82, 221));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add Book");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
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
        fNameLbl.setText("Title:");

        isbnLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        isbnLbl.setForeground(new java.awt.Color(255, 255, 255));
        isbnLbl.setText("ISBN");

        yearLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        yearLbl.setForeground(new java.awt.Color(255, 255, 255));
        yearLbl.setText("Year Publised:");

        titleFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        yearFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        isbnFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout bookTitleLblLayout = new javax.swing.GroupLayout(bookTitleLbl);
        bookTitleLbl.setLayout(bookTitleLblLayout);
        bookTitleLblLayout.setHorizontalGroup(
            bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookTitleLblLayout.createSequentialGroup()
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookTitleLblLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(fNameLbl))
                    .addComponent(shelfLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookTitleLblLayout.createSequentialGroup()
                        .addComponent(titleFld)
                        .addGap(39, 39, 39))
                    .addGroup(bookTitleLblLayout.createSequentialGroup()
                        .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bookTitleLblLayout.createSequentialGroup()
                                .addComponent(cancelBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addBtn))
                            .addComponent(shelfFld, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(bookTitleLblLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(isbnLbl)
                    .addComponent(yearLbl))
                .addGap(18, 18, 18)
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isbnFld)
                    .addComponent(yearFld))
                .addGap(40, 40, 40))
        );
        bookTitleLblLayout.setVerticalGroup(
            bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookTitleLblLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fNameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isbnFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbnLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearLbl))
                .addGap(18, 18, 18)
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shelfFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelfLbl))
                .addGap(18, 18, 18)
                .addGroup(bookTitleLblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
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
        titleLbl.setText("Add Book");
        titlePane.add(titleLbl);
        titleLbl.setBounds(20, 10, 190, 44);

        javax.swing.GroupLayout registerPaneLayout = new javax.swing.GroupLayout(registerPane);
        registerPane.setLayout(registerPaneLayout);
        registerPaneLayout.setHorizontalGroup(
            registerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePane, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bookTitleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        registerPaneLayout.setVerticalGroup(
            registerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPaneLayout.createSequentialGroup()
                .addComponent(titlePane, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bookTitleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(registerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try{
            if(emptyFields(shelfFld, titleFld, isbnFld, yearFld)){
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

        SearchBook book = new SearchBook(titleFld.getText(),
                isbnFld.getText(),
                Integer.parseInt(yearFld.getText()),
                Integer.parseInt(shelfFld.getText()));

        int x = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm",JOptionPane.YES_NO_OPTION);

        if(x==JOptionPane.NO_OPTION){
            return;
        }

        SQLCore.addBook(book);
        JOptionPane.showMessageDialog(this,
            "You have successfully added a book",
            "Success",
            JOptionPane.INFORMATION_MESSAGE);

        cancelBtn.doClick();
    }//GEN-LAST:event_addBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void exitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseClicked
        cancelBtn.doClick();
    }//GEN-LAST:event_exitBtnMouseClicked

    public boolean emptyFields(JTextField ... flds){
        for(JTextField item: flds){
            if(item.getText().isEmpty()){
                return true;
            }
        }
        
        return false;
    }
    
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
            java.util.logging.Logger.getLogger(AddBookDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBookDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBookDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBookDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddBookDialog dialog = new AddBookDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel bookTitleLbl;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JLabel fNameLbl;
    private javax.swing.JTextField isbnFld;
    private javax.swing.JLabel isbnLbl;
    private javax.swing.JPanel registerPane;
    private javax.swing.JTextField shelfFld;
    private javax.swing.JLabel shelfLbl;
    private javax.swing.JTextField titleFld;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JPanel titlePane;
    private javax.swing.JTextField yearFld;
    private javax.swing.JLabel yearLbl;
    // End of variables declaration//GEN-END:variables
}
