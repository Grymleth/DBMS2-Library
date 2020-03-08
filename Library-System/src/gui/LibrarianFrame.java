package gui;


import customclass.LibUser;
import customclass.LibUserView;
import customclass.PendingLoan;
import customclass.PendingLoanView;
import customclass.SearchBook;
import customclass.SearchBookView;
import java.awt.CardLayout;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oracledb.SQLCore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei
 */
public class LibrarianFrame extends javax.swing.JFrame {
    LibrarianFrame thisInstance = this;
    LibUser user;
    
    private LibUserView userList;
    private PendingLoanView pendingList;
    private SearchBookView manageBookList;
    
    private DefaultTableModel userModel;
    private DefaultTableModel pendingLoanModel;
    private DefaultTableModel manageBookModel;
    
    /**
     * Creates new form LibrarianWindow
     */
   CardLayout cardLayout;
    public LibrarianFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        cardLayout = (CardLayout)(panelCards.getLayout());
        
        refreshTables();
    }
    
    public LibrarianFrame(LibUser user){
        this();
        
        this.user = user;
        greetingNameLbl.setText(user.fName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        LibrarianWindowJLabel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        manageUsersButton = new javax.swing.JButton();
        manageBooksButton = new javax.swing.JButton();
        manageLoansButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        greetingLbl = new javax.swing.JLabel();
        greetingNameLbl = new javax.swing.JLabel();
        manageLoansButton1 = new javax.swing.JButton();
        panelCards = new javax.swing.JPanel();
        manageUserPanelCard = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        editButtonManageUsers = new javax.swing.JButton();
        addButtonManageUsers = new javax.swing.JButton();
        deleteButtonManageUsers = new javax.swing.JButton();
        manageBooksPanelCard = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        manageBookTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        addBtnManageBooks = new javax.swing.JButton();
        editBtnManageBooks = new javax.swing.JButton();
        deleteBtnManageBooks = new javax.swing.JButton();
        manageAuthorBtnManageBooks = new javax.swing.JButton();
        manageCopiesBtnManageBooks = new javax.swing.JButton();
        manageLoansPanelCard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pendingLoanTable = new javax.swing.JTable();
        loanBtnPendingLoans = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1129, 593));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LibrarianWindowJLabel.setBackground(new java.awt.Color(18, 203, 196));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Librarian Window");

        manageUsersButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        manageUsersButton.setForeground(new java.awt.Color(255, 255, 255));
        manageUsersButton.setText("Manage Users");
        manageUsersButton.setBorderPainted(false);
        manageUsersButton.setContentAreaFilled(false);
        manageUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUsersButtonActionPerformed(evt);
            }
        });

        manageBooksButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        manageBooksButton.setForeground(new java.awt.Color(255, 255, 255));
        manageBooksButton.setText("Manage Books");
        manageBooksButton.setBorderPainted(false);
        manageBooksButton.setContentAreaFilled(false);
        manageBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBooksButtonActionPerformed(evt);
            }
        });

        manageLoansButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        manageLoansButton.setForeground(new java.awt.Color(255, 255, 255));
        manageLoansButton.setText("Pending Loans");
        manageLoansButton.setBorderPainted(false);
        manageLoansButton.setContentAreaFilled(false);
        manageLoansButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLoansButtonActionPerformed(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        greetingLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        greetingLbl.setForeground(new java.awt.Color(255, 255, 255));
        greetingLbl.setText("Hello, ");

        greetingNameLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        greetingNameLbl.setForeground(new java.awt.Color(255, 255, 255));
        greetingNameLbl.setText("Librarian!");
        greetingNameLbl.setAlignmentX(0.5F);

        manageLoansButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        manageLoansButton1.setForeground(new java.awt.Color(255, 255, 255));
        manageLoansButton1.setText("Manage Shelves");
        manageLoansButton1.setBorderPainted(false);
        manageLoansButton1.setContentAreaFilled(false);
        manageLoansButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLoansButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LibrarianWindowJLabelLayout = new javax.swing.GroupLayout(LibrarianWindowJLabel);
        LibrarianWindowJLabel.setLayout(LibrarianWindowJLabelLayout);
        LibrarianWindowJLabelLayout.setHorizontalGroup(
            LibrarianWindowJLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LibrarianWindowJLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LibrarianWindowJLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LibrarianWindowJLabelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(LibrarianWindowJLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LibrarianWindowJLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LibrarianWindowJLabelLayout.createSequentialGroup()
                                    .addGroup(LibrarianWindowJLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(manageLoansButton)
                                        .addComponent(jLabel8)
                                        .addComponent(manageLoansButton1))
                                    .addGap(23, 23, 23))
                                .addGroup(LibrarianWindowJLabelLayout.createSequentialGroup()
                                    .addGroup(LibrarianWindowJLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(manageUsersButton)
                                        .addComponent(manageBooksButton))
                                    .addContainerGap()))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LibrarianWindowJLabelLayout.createSequentialGroup()
                                .addComponent(logoutButton)
                                .addContainerGap())))
                    .addGroup(LibrarianWindowJLabelLayout.createSequentialGroup()
                        .addGroup(LibrarianWindowJLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(greetingNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(greetingLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        LibrarianWindowJLabelLayout.setVerticalGroup(
            LibrarianWindowJLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LibrarianWindowJLabelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addGap(56, 56, 56)
                .addComponent(manageUsersButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageBooksButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageLoansButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageLoansButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(greetingLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greetingNameLbl)
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addGap(40, 40, 40))
        );

        greetingLbl.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        greetingNameLbl.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        jSplitPane2.setLeftComponent(LibrarianWindowJLabel);

        panelCards.setBackground(new java.awt.Color(196, 229, 56));
        panelCards.setLayout(new java.awt.CardLayout());

        manageUserPanelCard.setBackground(new java.awt.Color(196, 229, 56));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manage Users");

        editButtonManageUsers.setText("Edit");
        editButtonManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonManageUsersActionPerformed(evt);
            }
        });

        addButtonManageUsers.setText("Add");
        addButtonManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonManageUsersActionPerformed(evt);
            }
        });

        deleteButtonManageUsers.setText("Delete");
        deleteButtonManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonManageUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manageUserPanelCardLayout = new javax.swing.GroupLayout(manageUserPanelCard);
        manageUserPanelCard.setLayout(manageUserPanelCardLayout);
        manageUserPanelCardLayout.setHorizontalGroup(
            manageUserPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageUserPanelCardLayout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jLabel2)
                .addContainerGap(399, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageUserPanelCardLayout.createSequentialGroup()
                .addGroup(manageUserPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(manageUserPanelCardLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButtonManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButtonManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButtonManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(manageUserPanelCardLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(104, 104, 104))
        );
        manageUserPanelCardLayout.setVerticalGroup(
            manageUserPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageUserPanelCardLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(manageUserPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButtonManageUsers)
                    .addComponent(editButtonManageUsers)
                    .addComponent(deleteButtonManageUsers))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        panelCards.add(manageUserPanelCard, "manageUserPanelCard");
        manageUserPanelCard.getAccessibleContext().setAccessibleParent(manageUserPanelCard);

        manageBooksPanelCard.setBackground(new java.awt.Color(196, 229, 56));

        manageBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title", "ISBN", "Copy No.", "Author", "Year Published"
            }
        ));
        jScrollPane2.setViewportView(manageBookTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Manage Books");

        addBtnManageBooks.setText("Add");
        addBtnManageBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnManageBooksActionPerformed(evt);
            }
        });

        editBtnManageBooks.setText("Edit Details");
        editBtnManageBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnManageBooksActionPerformed(evt);
            }
        });

        deleteBtnManageBooks.setText("Delete");
        deleteBtnManageBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnManageBooksActionPerformed(evt);
            }
        });

        manageAuthorBtnManageBooks.setText("Edit Authors");
        manageAuthorBtnManageBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAuthorBtnManageBooksActionPerformed(evt);
            }
        });

        manageCopiesBtnManageBooks.setText("Edit Copies");
        manageCopiesBtnManageBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCopiesBtnManageBooksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manageBooksPanelCardLayout = new javax.swing.GroupLayout(manageBooksPanelCard);
        manageBooksPanelCard.setLayout(manageBooksPanelCardLayout);
        manageBooksPanelCardLayout.setHorizontalGroup(
            manageBooksPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageBooksPanelCardLayout.createSequentialGroup()
                .addGroup(manageBooksPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(manageBooksPanelCardLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtnManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editBtnManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(manageAuthorBtnManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(manageCopiesBtnManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtnManageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, manageBooksPanelCardLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(manageBooksPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(manageBooksPanelCardLayout.createSequentialGroup()
                                .addGap(312, 312, 312)
                                .addComponent(jLabel3)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        manageBooksPanelCardLayout.setVerticalGroup(
            manageBooksPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageBooksPanelCardLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(manageBooksPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtnManageBooks)
                    .addComponent(editBtnManageBooks)
                    .addComponent(deleteBtnManageBooks)
                    .addComponent(manageAuthorBtnManageBooks)
                    .addComponent(manageCopiesBtnManageBooks))
                .addGap(51, 51, 51))
        );

        panelCards.add(manageBooksPanelCard, "manageBooksPanelCard");

        manageLoansPanelCard.setBackground(new java.awt.Color(196, 229, 56));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pending Loans");

        pendingLoanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Title", "Author", "ISBN", "Transaction Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pendingLoanTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(pendingLoanTable);

        loanBtnPendingLoans.setText("Accept Loan");
        loanBtnPendingLoans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanBtnPendingLoansActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout manageLoansPanelCardLayout = new javax.swing.GroupLayout(manageLoansPanelCard);
        manageLoansPanelCard.setLayout(manageLoansPanelCardLayout);
        manageLoansPanelCardLayout.setHorizontalGroup(
            manageLoansPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageLoansPanelCardLayout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageLoansPanelCardLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(manageLoansPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loanBtnPendingLoans, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(44, 44, 44))
        );
        manageLoansPanelCardLayout.setVerticalGroup(
            manageLoansPanelCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageLoansPanelCardLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loanBtnPendingLoans)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        panelCards.add(manageLoansPanelCard, "manageLoansPanelCard");

        jSplitPane2.setRightComponent(panelCards);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUsersButtonActionPerformed
       cardLayout.show(panelCards,"manageUserPanelCard");
    }//GEN-LAST:event_manageUsersButtonActionPerformed

    private void manageBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBooksButtonActionPerformed
        cardLayout.show(panelCards,"manageBooksPanelCard");
    }//GEN-LAST:event_manageBooksButtonActionPerformed

    private void manageLoansButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLoansButtonActionPerformed
        cardLayout.show(panelCards,"manageLoansPanelCard");
    }//GEN-LAST:event_manageLoansButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?","Logging Out",JOptionPane.YES_NO_OPTION);

        if(x==JOptionPane.YES_OPTION){
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void editButtonManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonManageUsersActionPerformed
        LibUser selectedUser = userList.getUser(userTable.getSelectedRow());
        
        EditUserDialog editDialog = new EditUserDialog(this, true, selectedUser);
        editDialog.setVisible(true);
        editDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                thisInstance.refreshTables();
            }
        });
    }//GEN-LAST:event_editButtonManageUsersActionPerformed

    private void addButtonManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonManageUsersActionPerformed
        RegisterDialog addUserDialog = new RegisterDialog(this, true, "Librarian");
        addUserDialog.setVisible(true);
        addUserDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                thisInstance.refreshTables();
            }
        });
    }//GEN-LAST:event_addButtonManageUsersActionPerformed

    private void deleteButtonManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonManageUsersActionPerformed
        LibUser selectedUser = userList.getUser(userTable.getSelectedRow());
        
        int x = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete "+selectedUser.loginid+"?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if(x==JOptionPane.NO_OPTION){
            
        }
        
        SQLCore.deleteUser(selectedUser.userId);
        JOptionPane.showMessageDialog(this,
                "You have successfully deleted "+selectedUser.loginid,
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        
        refreshTables();
    }//GEN-LAST:event_deleteButtonManageUsersActionPerformed

    private void addBtnManageBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnManageBooksActionPerformed
        AddBookDialog addBookDialog = new AddBookDialog(this, true);
        addBookDialog.setVisible(true);
        addBookDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                thisInstance.refreshTables();
            }
        });
    }//GEN-LAST:event_addBtnManageBooksActionPerformed

    private void editBtnManageBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnManageBooksActionPerformed
        SearchBook selectedBook = manageBookList.getBook(manageBookTable.getSelectedRow());
        
        EditBookDialog editBookDialog = new EditBookDialog(this, true, selectedBook);
        editBookDialog.setVisible(true);
        editBookDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                thisInstance.refreshTables();
            }
        });
    }//GEN-LAST:event_editBtnManageBooksActionPerformed

    private void deleteBtnManageBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnManageBooksActionPerformed
        SearchBook selectedBook = manageBookList.getBook(manageBookTable.getSelectedRow());
        
        int x = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete "+selectedBook.getTitle()+"?\n"
                        + "This will delete all copies of the book.",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if(x==JOptionPane.NO_OPTION){
            
        }
        
        SQLCore.deleteBook(selectedBook.getIsbn());
        JOptionPane.showMessageDialog(this,
                "You have successfully deleted "+selectedBook.getTitle(),
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        
        refreshTables();
    }//GEN-LAST:event_deleteBtnManageBooksActionPerformed

    private void loanBtnPendingLoansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanBtnPendingLoansActionPerformed
        PendingLoan selectedPending = pendingList.getPending(pendingLoanTable.getSelectedRow());
        
        int choice = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to accept the loan?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
        
        if(choice == JOptionPane.NO_OPTION){
            return;
        }
        
        SQLCore.acceptLoan(selectedPending.getTransactionNo());
        
        JOptionPane.showMessageDialog(this,
                "Loan has been accepted!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        
        refreshTables();
    }//GEN-LAST:event_loanBtnPendingLoansActionPerformed

    private void manageAuthorBtnManageBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAuthorBtnManageBooksActionPerformed
        SearchBook selectedBook = manageBookList.getBook(manageBookTable.getSelectedRow());
        
        ManageAuthorDialog authorDialog = new ManageAuthorDialog(this, true, selectedBook);
        authorDialog.setVisible(true);
        authorDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                thisInstance.refreshTables();
            }
        });
    }//GEN-LAST:event_manageAuthorBtnManageBooksActionPerformed

    private void manageCopiesBtnManageBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCopiesBtnManageBooksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageCopiesBtnManageBooksActionPerformed

    private void manageLoansButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLoansButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageLoansButton1ActionPerformed

    public void refreshTables(){
        initTableModels();
        fillTables();
    }
        
    public void initTableModels(){
        userModel = new LibraryTableModel();
        userModel.setColumnIdentifiers(new String [] {"Username", "First Name", "Last Name", "Address", "Status", "Unpaid Fines"});
        userTable.setModel(userModel);
        
        pendingLoanModel = new LibraryTableModel();
        pendingLoanModel.setColumnIdentifiers(new String [] {"Transaction No.","Name", "Title","Authors","ISBN", "Copy No.", "Date on Hold"});
        pendingLoanTable.setModel(pendingLoanModel);
        
        manageBookModel = new LibraryTableModel();
        manageBookModel.setColumnIdentifiers(new String[] {"Title","Authors","ISBN", "Year Published", "Copies", "Shelf ID"});
        manageBookTable.setModel(manageBookModel);
    }
    
    public void fillTables(){
        userList = new LibUserView();
        userList.fill();
        
        ArrayList<LibUser> libUserList = userList.getUserList();
        
        if(libUserList != null){
            for(LibUser item: libUserList){
                System.out.println(item);
                userModel.addRow(item.toRow());
            }
        }
        
        pendingList = new PendingLoanView();
        pendingList.fill();
        
        ArrayList<PendingLoan> pendingLoanList = pendingList.getPendingList();
        
        if(pendingLoanList != null){
            for(PendingLoan item: pendingLoanList){
                System.out.println(item);
                pendingLoanModel.addRow(item.toRow());
            }
        }
        
        manageBookList = new SearchBookView();
        manageBookList.fill();
        
        ArrayList<SearchBook> manageList = manageBookList.getBookList();
        
        if(manageList != null){
            for(SearchBook item: manageList){
                System.out.println(item);
                manageBookModel.addRow(item.toRow());
            }
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
            java.util.logging.Logger.getLogger(LibrarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarianFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrarianFrame().setVisible(true);
            }
        });
    }
    
    public class LibraryTableModel extends DefaultTableModel{
        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex){
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LibrarianWindowJLabel;
    private javax.swing.JButton addBtnManageBooks;
    private javax.swing.JButton addButtonManageUsers;
    private javax.swing.JButton deleteBtnManageBooks;
    private javax.swing.JButton deleteButtonManageUsers;
    private javax.swing.JButton editBtnManageBooks;
    private javax.swing.JButton editButtonManageUsers;
    private javax.swing.JLabel greetingLbl;
    private javax.swing.JLabel greetingNameLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JButton loanBtnPendingLoans;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageAuthorBtnManageBooks;
    private javax.swing.JTable manageBookTable;
    private javax.swing.JButton manageBooksButton;
    private javax.swing.JPanel manageBooksPanelCard;
    private javax.swing.JButton manageCopiesBtnManageBooks;
    private javax.swing.JButton manageLoansButton;
    private javax.swing.JButton manageLoansButton1;
    private javax.swing.JPanel manageLoansPanelCard;
    private javax.swing.JPanel manageUserPanelCard;
    private javax.swing.JButton manageUsersButton;
    private javax.swing.JPanel panelCards;
    private javax.swing.JTable pendingLoanTable;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
