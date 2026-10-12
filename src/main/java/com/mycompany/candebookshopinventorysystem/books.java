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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class books extends javax.swing.JFrame {
    private boolean showingArchived = false;
    private final DefaultListModel<BookSuggestion> suggestionModel =
        new DefaultListModel<>();

private final JList<BookSuggestion> suggestionList =
        new JList<>(suggestionModel);

private final JPopupMenu suggestionPopup = new JPopupMenu();

private static class BookSuggestion {
    private final String title;
    private final String isbn;

    public BookSuggestion(String title, String isbn) {
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
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(books.class.getName());

    /**
     * Creates new form books
     */
    public books() {
    initComponents();


         tblBooks.setBackground(new Color(255, 255, 204)); // cream
    tblBooks.setForeground(Color.BLACK);

    // Grid
    tblBooks.setGridColor(new Color(255, 180, 80));

    // Header
    tblBooks.getTableHeader().setBackground(new Color(255, 190, 120));
    tblBooks.getTableHeader().setForeground(Color.BLACK);

    // Selection
    tblBooks.setSelectionBackground(new Color(255, 80, 80));
    tblBooks.setSelectionForeground(Color.WHITE);

    // Scroll pane viewport
    jScrollPane1.getViewport().setBackground(new Color(255, 255, 204));
    
    loadBooks();
    loadCategories();
    setupBookAutocomplete();
    
    
   javax.swing.table.TableColumnModel columns =
        tblBooks.getColumnModel();

columns.getColumn(0).setPreferredWidth(50);  // Book ID
columns.getColumn(1).setPreferredWidth(150); // ISBN
columns.getColumn(2).setPreferredWidth(200); // Title
columns.getColumn(3).setPreferredWidth(160); // Author
columns.getColumn(4).setPreferredWidth(160); // Category
columns.getColumn(5).setPreferredWidth(75);  // Price
columns.getColumn(6).setPreferredWidth(60);  // Stock

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);
    }
    
    private void setupBookAutocomplete() {

    suggestionList.setSelectionMode(
            javax.swing.ListSelectionModel.SINGLE_SELECTION);

    suggestionPopup.setFocusable(false);
    suggestionPopup.add(new JScrollPane(suggestionList));
    suggestionPopup.setPopupSize(380, 150);

    // Show suggestions as the user types
    txtSearch1.getDocument().addDocumentListener(
            new DocumentListener() {

        @Override
        public void insertUpdate(DocumentEvent e) {
            showBookSuggestions();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            showBookSuggestions();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            showBookSuggestions();
        }
    });

    // Fill the search field when a suggestion is selected
    suggestionList.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                BookSuggestion selected =
                        suggestionList.getSelectedValue();

                if (selected != null) {
                    txtSearch1.setText(selected.getTitle());
                    suggestionPopup.setVisible(false);
                    searchBooks();
                }
            }
        }
    });

    // Hide suggestions when the user presses Escape
    txtSearch1.getInputMap().put(
            javax.swing.KeyStroke.getKeyStroke("ESCAPE"),
            "hideSuggestions");

    txtSearch1.getActionMap().put(
            "hideSuggestions",
            new javax.swing.AbstractAction() {
        @Override
        public void actionPerformed(
                java.awt.event.ActionEvent e) {
            suggestionPopup.setVisible(false);
        }
    });
    
    

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cmbCategory = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAddBook = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbBookStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 18)); // NOI18N
        jLabel1.setText("BOOK MANAGEMENT CATALOG");

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel2.setText("Search Title/ISBN ");

        txtSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        txtSearch1.addActionListener(this::txtSearch1ActionPerformed);

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(this::btnSearchActionPerformed);

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Category", "Textbooks", "Academic & Reference", "Fiction", "Children's Books" }));
        cmbCategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        cmbCategory.addActionListener(this::cmbCategoryActionPerformed);

        jLabel3.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel3.setText("Category Filter:");

        tblBooks.setBackground(new java.awt.Color(255, 204, 153));
        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Book ID", "ISBN", "Title", "Author", "Category", "Price", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tblBooks);

        btnEdit.setBackground(new java.awt.Color(255, 51, 51));
        btnEdit.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(this::btnEditActionPerformed);

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("ARCHIVE");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnAddBook.setBackground(new java.awt.Color(255, 51, 51));
        btnAddBook.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        btnAddBook.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBook.setText("+ ADD BOOK");
        btnAddBook.addActionListener(this::btnAddBookActionPerformed);

        back.setBackground(new java.awt.Color(255, 51, 51));
        back.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("< Back");
        back.addActionListener(this::backActionPerformed);

        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        jLabel4.setText("View Archives:");

        cmbBookStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active Books", "Archived Books" }));
        cmbBookStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        cmbBookStatus.addActionListener(this::cmbBookStatusActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(11, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(373, 373, 373)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAddBook)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(335, 335, 335)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbBookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(527, 527, 527)
                .addComponent(btnEdit)
                .addGap(61, 61, 61)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cmbBookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddBook)
                            .addComponent(txtSearch1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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
private Connection getConnection() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/book_sales_recording_system";
    String user = "root";
    String pass = "";

    return DriverManager.getConnection(url, user, pass);
}

private void loadBooks() {

     DefaultTableModel model =
            (DefaultTableModel) tblBooks.getModel();

    model.setRowCount(0);

    String status = showingArchived ? "Archived" : "Active";

    String sql = "SELECT book_id, ISBN, book_name, author, "
               + "category, price, quantity "
               + "FROM books WHERE status = ? "
               + "ORDER BY book_id";

    try (Connection con = getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, status);

        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("ISBN"),
                    rs.getString("book_name"),
                    rs.getString("author"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                });
            }
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error loading books: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

private void loadCategories() {
    cmbCategory.removeAllItems();
   cmbCategory.addItem("All Category");

    String sql = "SELECT DISTINCT category FROM books "
           + "WHERE status = 'Active' "
           + "AND category IS NOT NULL AND category <> '' "
           + "ORDER BY category";

    try (Connection con = getConnection();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            cmbCategory.addItem(rs.getString("category"));
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,
                "Error loading categories: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

private void searchBooks() {

    String search = txtSearch1.getText().trim();

    String category = cmbCategory.getSelectedItem() == null
            ? "All Category"
            : cmbCategory.getSelectedItem().toString();

    DefaultTableModel model =
            (DefaultTableModel) tblBooks.getModel();

    model.setRowCount(0);

    String sql =
        "SELECT book_id, ISBN, book_name, author, category, price, quantity "
        + "FROM books "
        + "WHERE status = ? "
        + "AND (book_name LIKE ? OR ISBN LIKE ?) ";

    if (!category.equals("All Category")) {
        sql += "AND category = ? ";
    }

    sql += "ORDER BY book_id";

    try (Connection con = getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, showingArchived ? "Archived" : "Active");
        pst.setString(2, "%" + search + "%");
        pst.setString(3, "%" + search + "%");

        if (!category.equals("All Category")) {
            pst.setString(4, category);
        }

        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("ISBN"),
                    rs.getString("book_name"),
                    rs.getString("author"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getInt("quantity")
                });
            }
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error searching books: " + e.getMessage(),
                "Search Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

private void showBookSuggestions() {

    String search = txtSearch1.getText().trim();

    suggestionModel.clear();
    suggestionPopup.setVisible(false);

    if (search.isEmpty() || !txtSearch1.isShowing()) {
        return;
    }

    String sql =
        "SELECT book_name, ISBN FROM books "
        + "WHERE status = ? "
        + "AND (book_name LIKE ? OR ISBN LIKE ?) "
        + "ORDER BY book_name LIMIT 10";

    try (Connection con = getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, showingArchived ? "Archived" : "Active");
        pst.setString(2, search + "%");
pst.setString(3, search + "%");

        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                suggestionModel.addElement(
                    new BookSuggestion(
                        rs.getString("book_name"),
                        rs.getString("ISBN")
                    )
                );
            }
        }

        if (!suggestionModel.isEmpty()
                && txtSearch1.isShowing()) {
            suggestionList.setSelectedIndex(0);
            suggestionPopup.show(
                txtSearch1, 0, txtSearch1.getHeight()
            );
        }

    } catch (Exception e) {
        System.err.println(
            "Error loading book suggestions: " + e.getMessage()
        );
    }
}


public void refreshBooks() {
    loadBooks();
    loadCategories();
}
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    searchBooks();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
     if (showingArchived) {
        restoreSelectedBook();
    } else {
        archiveSelectedBook();
    }
}
    
    private void archiveSelectedBook() {

    if (!login.loggedInRole.equalsIgnoreCase("admin")) {
        JOptionPane.showMessageDialog(this,
                "Only administrators can archive books.");
        return;
    }

    int selectedRow = tblBooks.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this,
                "Please select a book to archive.");
        return;
    }

    int bookId = Integer.parseInt(
            tblBooks.getValueAt(selectedRow, 0).toString());

    String bookName = tblBooks.getValueAt(selectedRow, 2).toString();

    int confirm = JOptionPane.showConfirmDialog(
            this,
            "Archive \"" + bookName + "\"?",
            "Confirm Archive",
            JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    String sql = "UPDATE books SET status = 'Archived' "
               + "WHERE book_id = ? AND status = 'Active'";

    try (Connection con = getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, bookId);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this,
                    "Book archived successfully!");
        }

        loadBooks();
        loadCategories();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error archiving book: " + e.getMessage());
    }
}
    
    private void restoreSelectedBook() {

    if (!login.loggedInRole.equalsIgnoreCase("admin")) {
        JOptionPane.showMessageDialog(this,
                "Only administrators can restore books.");
        return;
    }

    int selectedRow = tblBooks.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this,
                "Please select a book to restore.");
        return;
    }

    int bookId = Integer.parseInt(
            tblBooks.getValueAt(selectedRow, 0).toString());

    String bookName = tblBooks.getValueAt(selectedRow, 2).toString();

    int confirm = JOptionPane.showConfirmDialog(
            this,
            "Restore \"" + bookName + "\"?",
            "Confirm Restore",
            JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    String sql = "UPDATE books SET status = 'Active' "
               + "WHERE book_id = ? AND status = 'Archived'";

    try (Connection con = getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, bookId);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(this,
                    "Book restored successfully!");
        }

        loadBooks();
        loadCategories();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error restoring book: " + e.getMessage());
    }
    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    homepage homeFrame = new homepage();
    homeFrame.setVisible(true);
    this.dispose();
  
    }//GEN-LAST:event_backActionPerformed

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
 if (cmbCategory.getSelectedItem() != null) {
        searchBooks();
 }
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void btnAddBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookActionPerformed
    if (!login.loggedInRole.equalsIgnoreCase("admin")) {
        JOptionPane.showMessageDialog(this,
            "Only administrators can add books.",
            "Access Denied",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    addbook addBookFrame = new addbook(this);
addBookFrame.setVisible(true);

    this.setVisible(false);

    }//GEN-LAST:event_btnAddBookActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
     if (!login.loggedInRole.equalsIgnoreCase("admin")) {
        JOptionPane.showMessageDialog(this,
            "Only administrators can edit books.",
            "Access Denied",
            JOptionPane.WARNING_MESSAGE);
        return;
    }
     int selectedRow = tblBooks.getSelectedRow();

    if (selectedRow == -1) {

        JOptionPane.showMessageDialog(this,
                "Please select a book to edit.",
                "Edit Book",
                JOptionPane.WARNING_MESSAGE);

        return;
    }

    int bookId = Integer.parseInt(
            tblBooks.getValueAt(selectedRow, 0).toString()
    );

    String oldISBN = tblBooks.getValueAt(selectedRow, 1).toString();
    String oldTitle = tblBooks.getValueAt(selectedRow, 2).toString();
    String oldAuthor = tblBooks.getValueAt(selectedRow, 3).toString();
    String oldCategory = tblBooks.getValueAt(selectedRow, 4).toString();
    String oldPrice = tblBooks.getValueAt(selectedRow, 5).toString();
    String oldQuantity = tblBooks.getValueAt(selectedRow, 6).toString();

    String isbn = JOptionPane.showInputDialog(
            this, "ISBN:", oldISBN);

    if (isbn == null) return;

    String title = JOptionPane.showInputDialog(
            this, "Title:", oldTitle);

    if (title == null) return;

    String author = JOptionPane.showInputDialog(
            this, "Author:", oldAuthor);

    if (author == null) return;

    String category = JOptionPane.showInputDialog(
            this, "Category:", oldCategory);

    if (category == null) return;

    String priceText = JOptionPane.showInputDialog(
            this, "Price:", oldPrice);

    if (priceText == null) return;

    String quantityText = JOptionPane.showInputDialog(
            this, "Quantity:", oldQuantity);

    if (quantityText == null) return;

    if (isbn.trim().isEmpty()
            || title.trim().isEmpty()
            || author.trim().isEmpty()
            || category.trim().isEmpty()
            || priceText.trim().isEmpty()
            || quantityText.trim().isEmpty()) {

        JOptionPane.showMessageDialog(this,
                "All fields are required.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);

        return;
    }
    
    
String newISBN = isbn.trim();

if (!newISBN.matches("^(978|979)\\d{10}$")) {
    JOptionPane.showMessageDialog(this,
            "Invalid ISBN. Enter a 13-digit ISBN starting with 978 or 979.",
            "Invalid ISBN",
            JOptionPane.WARNING_MESSAGE);
    return;
}


if (author.trim().matches("\\d+")) {
    JOptionPane.showMessageDialog(this,
            "Author name cannot contain only numbers.",
            "Invalid Author",
            JOptionPane.WARNING_MESSAGE);
    return;
}

if (category.trim().matches("\\d+")) {
    JOptionPane.showMessageDialog(this,
            "Category cannot contain only numbers.",
            "Invalid Category",
            JOptionPane.WARNING_MESSAGE);
    return;
}



    double price;
    int quantity;

    try {

        price = Double.parseDouble(priceText);
        quantity = Integer.parseInt(quantityText);

        if (price < 0 || quantity < 0) {

            JOptionPane.showMessageDialog(this,
                    "Price and quantity cannot be negative.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(this,
                "Invalid price or quantity.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);

        return;
    }

    String sql = "UPDATE books SET "
               + "ISBN = ?, "
               + "book_name = ?, "
               + "author = ?, "
               + "category = ?, "
               + "price = ?, "
               + "quantity = ? "
               + "WHERE book_id = ?";

    try (Connection con = getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, newISBN);
        pst.setString(2, title.trim());
        pst.setString(3, author.trim());
        pst.setString(4, category.trim());
        pst.setDouble(5, price);
        pst.setInt(6, quantity);
        pst.setInt(7, bookId);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(this,
                "Book updated successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

        loadBooks();
        loadCategories();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,
                "Error updating book: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnEditActionPerformed

    private void cmbBookStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBookStatusActionPerformed
    if (cmbBookStatus.getSelectedItem() == null) {
        return;
    }

    showingArchived =
            cmbBookStatus.getSelectedItem()
                    .toString()
                    .equals("Archived Books");

    loadBooks();

    // Update the action button text
    if (showingArchived) {
        btnDelete.setText("RESTORE");
    } else {
        btnDelete.setText("ARCHIVE");
    }

    // Clear the search field when switching views
    txtSearch1.setText("");

    }//GEN-LAST:event_cmbBookStatusActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new books().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnAddBook;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbBookStatus;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables
}
