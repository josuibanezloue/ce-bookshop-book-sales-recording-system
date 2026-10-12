/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.candebookshopinventorysystem;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author ibane
 */
public final class homepage extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(homepage.class.getName());

    /**
     * Creates new form homepage
     */
    public homepage() {
        initComponents();
        tblRecentSales.setBackground(new Color(255, 255, 204));
    tblRecentSales.setForeground(Color.BLACK);

    // Table grid lines
    tblRecentSales.setGridColor(new Color(255, 180, 80));

    // Table header
    tblRecentSales.getTableHeader().setBackground(new Color(255, 190, 120));
    tblRecentSales.getTableHeader().setForeground(Color.BLACK);

    // Selected row
    tblRecentSales.setSelectionBackground(new Color(255, 80, 80));
    tblRecentSales.setSelectionForeground(Color.WHITE);

    // Scroll pane background
    jScrollPane1.getViewport().setBackground(new Color(255, 255, 204));

        lblWelcome.setText("WELCOME, " + login.loggedInUsername);
        loadDashboardData(); // <-- ADD THIS LINE HERE
        
        
 // Adjust Homepage Recent Sales table columns
javax.swing.table.TableColumnModel columns =
        tblRecentSales.getColumnModel();

columns.getColumn(0).setPreferredWidth(55); // Date
columns.getColumn(1).setPreferredWidth(180); // Title
columns.getColumn(2).setPreferredWidth(30); // Quantity
columns.getColumn(3).setPreferredWidth(65); // Total
columns.getColumn(4).setPreferredWidth(65); // Cashier

setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        books = new javax.swing.JButton();
        sales = new javax.swing.JButton();
        inventory = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        accountsettings = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTotalBooks = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblTodaysSales = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblBooksSold = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblLowStock = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecentSales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));

        books.setBackground(new java.awt.Color(255, 51, 51));
        books.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        books.setForeground(new java.awt.Color(255, 255, 255));
        books.setText("BOOKS");
        books.addActionListener(this::booksActionPerformed);

        sales.setBackground(new java.awt.Color(255, 51, 51));
        sales.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        sales.setForeground(new java.awt.Color(255, 255, 255));
        sales.setText("SALES");
        sales.addActionListener(this::salesActionPerformed);

        inventory.setBackground(new java.awt.Color(255, 51, 51));
        inventory.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        inventory.setForeground(new java.awt.Color(255, 255, 255));
        inventory.setText("INVENTORY");
        inventory.addActionListener(this::inventoryActionPerformed);

        logout.setBackground(new java.awt.Color(255, 51, 51));
        logout.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("LOG OUT");
        logout.addActionListener(this::logoutActionPerformed);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ibane\\Downloads\\4914 for Homepage.jpg")); // NOI18N

        accountsettings.setBackground(new java.awt.Color(255, 51, 51));
        accountsettings.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        accountsettings.setForeground(new java.awt.Color(255, 255, 255));
        accountsettings.setText("ACCOUNT SETTINGS");
        accountsettings.addActionListener(this::accountsettingsActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sales, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(books, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(inventory, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(accountsettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(books, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(sales, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(accountsettings, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));

        lblWelcome.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        lblWelcome.setText("WELCOME.");

        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel4.setText("Book Sales Recording System");

        jPanel4.setBackground(new java.awt.Color(255, 204, 153));

        lblTotalBooks.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        lblTotalBooks.setText("TOTAL BOOKS");

        jLabel5.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel5.setText("100");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblTotalBooks))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalBooks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 153));

        lblTodaysSales.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        lblTodaysSales.setText("TOTAL SALES");

        jLabel7.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel7.setText("05430.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lblTodaysSales)
                        .addGap(27, 27, 27))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTodaysSales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 204, 153));

        lblBooksSold.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        lblBooksSold.setText("BOOKS SOLD");

        jLabel9.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel9.setText("20");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblBooksSold))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel9)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBooksSold)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 204, 153));

        lblLowStock.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        lblLowStock.setText("LOW STOCK");

        jLabel11.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblLowStock))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel11)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLowStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tblRecentSales.setBackground(new java.awt.Color(255, 204, 153));
        tblRecentSales.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        tblRecentSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Title", "Quantity", "Total", "Cashier"
            }
        ));
        jScrollPane1.setViewportView(tblRecentSales);

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        jLabel2.setText("RECENT SALES ACTIVITY");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWelcome)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(26, 26, 26)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void loadDashboardData() {

    String url = "jdbc:mysql://localhost:3306/book_sales_recording_system";
    String user = "root";
    String pass = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (java.sql.Connection conn = java.sql.DriverManager.getConnection(url, user, pass); java.sql.Statement stmt = conn.createStatement()) {
            
            try ( // ==============================
            // 1. TOTAL BOOKS
            // ==============================
                    java.sql.ResultSet rs1 = stmt.executeQuery(
                            "SELECT COALESCE(SUM(quantity), 0) " +
        "FROM books WHERE status = 'Active'"
                    )) {
                if (rs1.next()) {
                    jLabel5.setText(String.valueOf(rs1.getInt(1)));
                }
            }
            
            
            try ( // ==============================
            // 2. TOTAL SALES
            // ==============================
                    java.sql.ResultSet rs2 = stmt.executeQuery(
                            "SELECT COALESCE(SUM(total_price), 0) " +
                                    "FROM sales"
                    )) {
                if (rs2.next()) {
                    jLabel7.setText(
                            "₱" + String.format("%.2f", rs2.getDouble(1))
                    );
                }
            }
            
            
            try ( // ==============================
            // 3. BOOKS SOLD
            // ==============================
                    java.sql.ResultSet rs3 = stmt.executeQuery(
                            "SELECT COALESCE(SUM(quantity), 0) FROM sales"
                    )) {
                if (rs3.next()) {
                    jLabel9.setText(
                            String.valueOf(rs3.getInt(1))
                    );
                }
            }
            
            
            try ( // ==============================
            // 4. LOW STOCK
            // ==============================
                    java.sql.ResultSet rs4 = stmt.executeQuery(
    "SELECT COUNT(*) " +
    "FROM books " +
    "WHERE status = 'Active' " +
    "AND quantity > 0 AND quantity <= 5"
)) {
    if (rs4.next()) {
        jLabel11.setText(
                String.valueOf(rs4.getInt(1))
        );
    }
}
            
            
            // ==============================
            // 5. RECENT SALES ACTIVITY
            // ==============================
            javax.swing.table.DefaultTableModel model =
                    (javax.swing.table.DefaultTableModel)
                    tblRecentSales.getModel();
            
            model.setRowCount(0);
            
            try (java.sql.ResultSet rs5 = stmt.executeQuery(
                    "SELECT sale_date, book_name, quantity, " +
                            "total_price, cashier_name " +
                            "FROM sales " +
                            "ORDER BY sale_date DESC " +
                            "LIMIT 10"
            )) {
                while (rs5.next()) {
                    
                    model.addRow(new Object[]{
                        rs5.getString("sale_date"),
                        rs5.getString("book_name"),
                        rs5.getInt("quantity"),
                        "₱" + String.format(
                                "%.2f",
                                rs5.getDouble("total_price")
                        ),
                        rs5.getString("cashier_name")
                    });
                }
            }
        }

    } catch (ClassNotFoundException | SQLException e) {

        JOptionPane.showMessageDialog(
                this,
                "Database Error: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
    private void booksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksActionPerformed
    books books1 = new books();
    books1.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_booksActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
   int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to log out?",
        "Confirm Logout",
        JOptionPane.YES_NO_OPTION
    );

    if(confirm == JOptionPane.YES_OPTION){
        new login().setVisible(true);   // open the login form again
        this.dispose();                  // close the homepage window
    }
    }//GEN-LAST:event_logoutActionPerformed

    private void inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryActionPerformed
    inventory inventory1 = new inventory();
    inventory1.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_inventoryActionPerformed

    private void salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesActionPerformed
    sales sales1 = new sales();
    sales1.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_salesActionPerformed

    private void accountsettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsettingsActionPerformed
    accountsettings settings = new accountsettings();
    settings.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_accountsettingsActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new homepage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountsettings;
    private javax.swing.JButton books;
    private javax.swing.JButton inventory;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBooksSold;
    private javax.swing.JLabel lblLowStock;
    private javax.swing.JLabel lblTodaysSales;
    private javax.swing.JLabel lblTotalBooks;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JButton logout;
    private javax.swing.JButton sales;
    private javax.swing.JTable tblRecentSales;
    // End of variables declaration//GEN-END:variables
}
