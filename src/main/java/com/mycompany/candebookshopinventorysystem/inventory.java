/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.candebookshopinventorysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPopupMenu;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;

/**
 *
 * @author ibane
 */
public class inventory extends javax.swing.JFrame {
    private final DefaultListModel<InventorySuggestion> suggestionModel =
        new DefaultListModel<>();

private final JList<InventorySuggestion> suggestionList =
        new JList<>(suggestionModel);

private final JPopupMenu suggestionPopup = new JPopupMenu();

private static class InventorySuggestion {
    private final String title;
    private final String isbn;

    public InventorySuggestion(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return title + "  |  ISBN: " + isbn;
    }
}
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(inventory.class.getName());

    /**
     * Creates new form inventory
     */
    public inventory() {
    initComponents();
    
     jTable2.setBackground(new Color(255, 255, 204)); // cream
    jTable2.setForeground(Color.BLACK);

    // Grid
    jTable2.setGridColor(new Color(255, 180, 80));

    // Header
    jTable2.getTableHeader().setBackground(new Color(255, 190, 120));
    jTable2.getTableHeader().setForeground(Color.BLACK);

    // Selection
    jTable2.setSelectionBackground(new Color(255, 80, 80));
    jTable2.setSelectionForeground(Color.WHITE);

    // Scroll pane viewport
    jScrollPane2.getViewport().setBackground(new Color(255, 255, 204));
    
    connectDatabase();
loadInventory();
loadInventorySummary();
colorStatusColumn();
setupInventoryAutocomplete();
    
 // Adjust Books table column widths
javax.swing.table.TableColumnModel columns =
        jTable2.getColumnModel();

columns.getColumn(0).setPreferredWidth(50);  // Book ID
columns.getColumn(1).setPreferredWidth(150); // ISBN
columns.getColumn(2).setPreferredWidth(210); // Title
columns.getColumn(3).setPreferredWidth(160); // Author
columns.getColumn(4).setPreferredWidth(170); // Category
columns.getColumn(5).setPreferredWidth(75);  // Price
columns.getColumn(6).setPreferredWidth(60);  // Stock

setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);
    }
    
    
private void setupInventoryAutocomplete() {
    suggestionList.setSelectionMode(
            javax.swing.ListSelectionModel.SINGLE_SELECTION);

    suggestionPopup.setFocusable(false);
    suggestionPopup.add(new JScrollPane(suggestionList));
    suggestionPopup.setPopupSize(380, 150);

    txtSearch.getDocument().addDocumentListener(
            new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            showInventorySuggestions();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            showInventorySuggestions();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            showInventorySuggestions();
        }
    });

    suggestionList.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            if (e.getClickCount() == 1) {
                InventorySuggestion selected =
                        suggestionList.getSelectedValue();

                if (selected != null) {
                    txtSearch.setText(selected.getTitle());
                    suggestionPopup.setVisible(false);
                    btnSearchActionPerformed(null);
                }
            }
        }
    });

    txtSearch.getInputMap().put(
            javax.swing.KeyStroke.getKeyStroke("ESCAPE"),
            "hideInventorySuggestions");

    txtSearch.getActionMap().put(
            "hideInventorySuggestions",
            new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(
                java.awt.event.ActionEvent e) {
            suggestionPopup.setVisible(false);
        }
    });
}

private void showInventorySuggestions() {
    String search = txtSearch.getText().trim();

    suggestionModel.clear();

    if (search.isEmpty() || con == null) {
        suggestionPopup.setVisible(false);
        return;
    }

    String sql = "SELECT book_name, ISBN FROM books "
            + "WHERE status = 'Active' "
            + "AND (book_name LIKE ? OR ISBN LIKE ?) "
            + "ORDER BY book_name LIMIT 10";

    try (PreparedStatement pst = con.prepareStatement(sql)) {
        
pst.setString(1, search + "%");
pst.setString(2, search + "%");


        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                suggestionModel.addElement(
                        new InventorySuggestion(
                                rs.getString("book_name"),
                                rs.getString("ISBN")
                        )
                );
            }
        }

        if (suggestionModel.isEmpty()) {
            suggestionPopup.setVisible(false);
        } else {
             suggestionList.setSelectedIndex(0);
            if (!suggestionPopup.isVisible()) {
                suggestionPopup.show(
                        txtSearch, 0, txtSearch.getHeight()
                );
            }
        }

    } catch (Exception e) {
        suggestionPopup.setVisible(false);
        System.err.println(
                "Inventory suggestion error: " + e.getMessage()
        );
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelOutOfStock = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabelInStock = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelLowStock = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbStockFilter = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        jLabel1.setText("INVENTORY");

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel2.setText("OUT OF STOCK");

        jLabelOutOfStock.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabelOutOfStock.setForeground(new java.awt.Color(255, 0, 0));
        jLabelOutOfStock.setText("2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabelOutOfStock))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelOutOfStock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 153));

        jLabel8.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel8.setText("IN STOCK");

        jLabelInStock.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabelInStock.setForeground(new java.awt.Color(0, 153, 0));
        jLabelInStock.setText("01");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabelInStock)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInStock)
                .addGap(12, 12, 12))
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 153));

        jLabel5.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel5.setText("LOW STOCK");

        jLabelLowStock.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabelLowStock.setForeground(new java.awt.Color(255, 153, 0));
        jLabelLowStock.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabelLowStock)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLowStock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel3.setText("Search Title/ISBN");

        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel4.setText("Stock Filter:");

        cmbStockFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Stock", "In Stock", "Low Stock", "Out of Stock" }));
        cmbStockFilter.setBorder(null);
        cmbStockFilter.addActionListener(this::cmbStockFilterActionPerformed);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("< Back");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Book ID", "ISBN", "Title", "Author", "Category", "Price", "Stock", "Status"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(461, 461, 461)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearch))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbStockFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbStockFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private Connection con;

private void connectDatabase() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/book_sales_recording_system";
        String user = "root";
        String pass = "";

        con = DriverManager.getConnection(url, user, pass);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Database connection failed: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

private void loadInventory() {

    DefaultTableModel model =
            (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0);

    String sql = "SELECT book_id, ISBN, book_name, author, "
            + "category, price, quantity "
            + "FROM books WHERE status = 'Active' "
            + "ORDER BY book_id";

    try (PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            int quantity = rs.getInt("quantity");

            String status;
            if (quantity == 0) {
                status = "Out of Stock";
            } else if (quantity <= 5) {
                status = "Low Stock";
            } else {
                status = "In Stock";
            }

            model.addRow(new Object[]{
                rs.getInt("book_id"),
                rs.getString("ISBN"),
                rs.getString("book_name"),
                rs.getString("author"),
                rs.getString("category"),
                rs.getDouble("price"),
                quantity,
                status
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error loading inventory: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void loadInventorySummary() {
    
    String sql = "SELECT "
            + "COALESCE(SUM(CASE WHEN quantity > 0 "
            + "AND quantity <= 5 THEN 1 ELSE 0 END), 0) AS low_stock, "
            + "COALESCE(SUM(CASE WHEN quantity > 5 "
            + "THEN 1 ELSE 0 END), 0) AS in_stock, "
            + "COALESCE(SUM(CASE WHEN quantity = 0 "
            + "THEN 1 ELSE 0 END), 0) AS out_of_stock "
            + "FROM books WHERE status = 'Active'";

    try (PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        if (rs.next()) {
            jLabelLowStock.setText(
                    String.valueOf(rs.getInt("low_stock")));

            jLabelInStock.setText(
                    String.valueOf(rs.getInt("in_stock")));

            jLabelOutOfStock.setText(
                    String.valueOf(rs.getInt("out_of_stock")));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error loading inventory summary: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void colorStatusColumn() {

    jTable2.getColumnModel().getColumn(7)
            .setCellRenderer(new DefaultTableCellRenderer() {

        @Override
        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            if (!isSelected) {

                if ("In Stock".equals(value)) {
                    c.setForeground(new Color(0, 153, 0)); // Green

                } else if ("Low Stock".equals(value)) {
                    c.setForeground(new Color(255, 153, 0)); // Orange

                } else if ("Out of Stock".equals(value)) {
                    c.setForeground(Color.RED); // Red

                } else {
                    c.setForeground(Color.BLACK);
                }

            } else {
                c.setForeground(Color.WHITE);
            }

            return c;
        }
    });
    }

private void filterInventory() {

    if (cmbStockFilter.getSelectedItem() == null) {
        return;
    }

    String filter = cmbStockFilter.getSelectedItem().toString();

    DefaultTableModel model =
            (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0);

    String sql;

    sql = switch (filter) {
            case "In Stock" -> "SELECT book_id, ISBN, book_name, author, "
            + "category, price, quantity FROM books "
            + "WHERE status = 'Active' AND quantity > 5 "
            + "ORDER BY book_id";
            case "Low Stock" -> "SELECT book_id, ISBN, book_name, author, "
            + "category, price, quantity FROM books "
            + "WHERE status = 'Active' "
            + "AND quantity > 0 AND quantity <= 5 "
            + "ORDER BY book_id";
            case "Out of Stock" -> "SELECT book_id, ISBN, book_name, author, "
            + "category, price, quantity FROM books "
            + "WHERE status = 'Active' AND quantity = 0 "
            + "ORDER BY book_id";
            default -> "SELECT book_id, ISBN, book_name, author, "
            + "category, price, quantity FROM books "
            + "WHERE status = 'Active' "
            + "ORDER BY book_id";
        };

    try (PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            int quantity = rs.getInt("quantity");

            String status;
            if (quantity == 0) {
                status = "Out of Stock";
            } else if (quantity <= 5) {
                status = "Low Stock";
            } else {
                status = "In Stock";
            }

            model.addRow(new Object[]{
                rs.getInt("book_id"),
                rs.getString("ISBN"),
                rs.getString("book_name"),
                rs.getString("author"),
                rs.getString("category"),
                rs.getDouble("price"),
                quantity,
                status
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Filter error: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     homepage homeFrame = new homepage();
    homeFrame.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    String search = txtSearch.getText().trim();

    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    model.setRowCount(0);

    String sql = "SELECT book_id, ISBN, book_name, author, category, price, quantity "
               + "FROM books "
               + "WHERE book_name LIKE ? OR ISBN LIKE ? "
               + "ORDER BY book_id";

    try {

        boolean found;
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + search + "%");
            pst.setString(2, "%" + search + "%");
            try (ResultSet rs = pst.executeQuery()) {
                found = false;
                while (rs.next()) {
                    
                    found = true;
                    
                    int quantity = rs.getInt("quantity");
                    
                    String status;
                    
                    if (quantity == 0) {
                        status = "Out of Stock";
                    } else if (quantity <= 5) {
                        status = "Low Stock";
                    } else {
                        status = "In Stock";
                    }
                    
                    model.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("ISBN"),
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        quantity,
                        status
                    });
                }
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this,
                    "No book found.",
                    "Search Result",
                    JOptionPane.INFORMATION_MESSAGE);

            loadInventory();
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,
                "Search error: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void cmbStockFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStockFilterActionPerformed
    filterInventory();
    }//GEN-LAST:event_cmbStockFilterActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new inventory().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbStockFilter;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelInStock;
    private javax.swing.JLabel jLabelLowStock;
    private javax.swing.JLabel jLabelOutOfStock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
