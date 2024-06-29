package onlineshoppingplatform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OSPPayment extends JFrame implements ActionListener {
    private JLabel lblname, lbladd, lblcontact, lblcustomer, lblmop, lblamount, lblSelectedItems, lblTotalPrice;
    private JButton btnPurchase, btnHome, btnDelete;
    private JTextField txtname, txtadd, txtcontact, txtamount;
    private JComboBox<String> cmbmop;
    private JPanel customerPanel, itemsPanel, buttonPanel;
    private JScrollPane scrollPane;
    private double totalPrice;
    private List<String> selectedItems;
    private JTable selectedItemsTable;
    private DefaultTableModel tableModel;
    private Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/osp";
    private static final String USER = "lance";
    private static final String PASSWORD = "12345";

    public OSPPayment(String selectedItems, double totalPrice) {
        this.selectedItems = new ArrayList<>();
        for (String item : selectedItems.split("\n")) {
            this.selectedItems.add(item);
        }
        this.totalPrice = totalPrice;

        setTitle("PAYMENT");
        setSize(600, 700);
        setLayout(new BorderLayout());

        initializeDBConnection();

        customerPanel = new JPanel();
        customerPanel.setLayout(null);
        customerPanel.setPreferredSize(new Dimension(600, 300));

        lblcustomer = new JLabel("CUSTOMER'S INFORMATION");
        lblcustomer.setBounds(20, 20, 250, 30);
        lblcustomer.setFont(new Font("Arial", Font.BOLD, 16));

        lblname = new JLabel("Name:");
        lblname.setBounds(100, 70, 100, 30);
        lblname.setFont(new Font("Arial", Font.BOLD, 15));

        lbladd = new JLabel("Address:");
        lbladd.setBounds(100, 110, 100, 30);
        lbladd.setFont(new Font("Arial", Font.BOLD, 15));

        lblcontact = new JLabel("Contact No:");
        lblcontact.setBounds(100, 150, 100, 30);
        lblcontact.setFont(new Font("Arial", Font.BOLD, 15));

        lblamount = new JLabel("Amount:");
        lblamount.setBounds(100, 190, 100, 30);
        lblamount.setFont(new Font("Arial", Font.BOLD, 15));

        lblmop = new JLabel("Mode of Payment:");
        lblmop.setBounds(100, 230, 150, 30);
        lblmop.setFont(new Font("Arial", Font.BOLD, 15));

        txtname = new JTextField();
        txtname.setBounds(250, 70, 200, 30);
        txtname.setFont(new Font("Arial", Font.PLAIN, 15));

        txtadd = new JTextField();
        txtadd.setBounds(250, 110, 200, 30);
        txtadd.setFont(new Font("Arial", Font.PLAIN, 15));

        txtcontact = new JTextField();
        txtcontact.setBounds(250, 150, 200, 30);
        txtcontact.setFont(new Font("Arial", Font.PLAIN, 15));

        txtamount = new JTextField();
        txtamount.setBounds(250, 190, 200, 30);
        txtamount.setFont(new Font("Arial", Font.PLAIN, 15));

        String[] paymentMethods = {"Cash on Delivery", "GCash", "Paymaya"};
        cmbmop = new JComboBox<>(paymentMethods);
        cmbmop.setBounds(250, 230, 200, 30);
        cmbmop.setFont(new Font("Arial", Font.PLAIN, 15));

        customerPanel.add(lblcustomer);
        customerPanel.add(lblname);
        customerPanel.add(lbladd);
        customerPanel.add(lblcontact);
        customerPanel.add(lblamount);
        customerPanel.add(lblmop);
        customerPanel.add(txtname);
        customerPanel.add(txtadd);
        customerPanel.add(txtcontact);
        customerPanel.add(txtamount);
        customerPanel.add(cmbmop);

        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BorderLayout());

        lblSelectedItems = new JLabel("SELECTED ITEMS");
        lblSelectedItems.setFont(new Font("Arial", Font.BOLD, 16));
        itemsPanel.add(lblSelectedItems, BorderLayout.NORTH);

        String[] columnNames = {"Item Name", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        selectedItemsTable = new JTable(tableModel);
        selectedItemsTable.setFillsViewportHeight(true);
        for (String item : this.selectedItems) {
            String[] itemDetails = item.split(",");
            if (itemDetails.length == 2) {
                tableModel.addRow(itemDetails);
            }
        }
        scrollPane = new JScrollPane(selectedItemsTable);
        itemsPanel.add(scrollPane, BorderLayout.CENTER);

        lblTotalPrice = new JLabel("Total Price: $" + totalPrice);
        lblTotalPrice.setFont(new Font("Arial", Font.BOLD, 16));
        itemsPanel.add(lblTotalPrice, BorderLayout.SOUTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setPreferredSize(new Dimension(600, 50));

        btnHome = new JButton("HOME");
        btnHome.setPreferredSize(new Dimension(100, 30));
        btnHome.addActionListener(this);
        
        btnDelete = new JButton("DELETE");
        btnDelete.setPreferredSize(new Dimension(100, 30));
        btnDelete.addActionListener(this);
        
        btnPurchase = new JButton("PURCHASE");
        btnPurchase.setPreferredSize(new Dimension(100, 30));
        btnPurchase.addActionListener(this);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(btnHome);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(btnDelete);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(btnPurchase);

        buttonPanel.add(leftPanel, BorderLayout.WEST);
        buttonPanel.add(centerPanel, BorderLayout.CENTER);
        buttonPanel.add(rightPanel, BorderLayout.EAST);

        add(customerPanel, BorderLayout.NORTH);
        add(itemsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPurchase) {
            if (txtname.getText().isEmpty() || txtadd.getText().isEmpty() || txtcontact.getText().isEmpty() || txtamount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled out");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO payments (item_id, customer_name, customer_address, customer_phone, amount, payment_method, payment_status) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)"
            )) {
                for (String item : selectedItems) {
                    String[] itemDetails = item.split(",");
                    if (itemDetails.length == 2) {
                        stmt.setInt(1, getItemIdByName(itemDetails[0]));
                        stmt.setString(2, txtname.getText());
                        stmt.setString(3, txtadd.getText());
                        stmt.setString(4, txtcontact.getText());
                        stmt.setDouble(5, Double.parseDouble(txtamount.getText()));
                        stmt.setString(6, cmbmop.getSelectedItem().toString());
                        stmt.setString(7, "Pending");
                        stmt.executeUpdate();
                    }
                }
                JOptionPane.showMessageDialog(this, "Purchase successful");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == btnHome) {
            new Home();
            dispose();
        } else if (e.getSource() == btnDelete) {
            int selectedRow = selectedItemsTable.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.removeRow(selectedRow);
                selectedItems.remove(selectedRow);
                recalculateTotalPrice();
            } else {
                JOptionPane.showMessageDialog(this, "Please select an item to delete");
            }
        }
    }

    private int getItemIdByName(String itemName) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT id FROM items WHERE name = ?")) {
            stmt.setString(1, itemName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        return -1;
    }

    private void recalculateTotalPrice() {
        totalPrice = 0;
        for (String item : selectedItems) {
            String[] itemDetails = item.split(",");
            if (itemDetails.length == 2) {
                totalPrice += Double.parseDouble(itemDetails[1]);
            }
        }
        lblTotalPrice.setText("Total Price: $" + totalPrice);
    }

    public static void main(String[] args) {
        new OSPPayment("", 0.0);
    }
}
