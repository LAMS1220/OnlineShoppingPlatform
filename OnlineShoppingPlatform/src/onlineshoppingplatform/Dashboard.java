package onlineshoppingplatform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Dashboard extends JFrame implements ActionListener {
    private JTable itemTable;
    private DefaultTableModel tableModel;
    private JButton btnAdd, btnDelete;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/osp";
    private static final String USER = "lance";
    private static final String PASSWORD = "12345";

    public Dashboard() {
        setTitle("ADMINISTRATIVE DASHBOARD");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        btnAdd = new JButton("UPDATE");
        btnDelete = new JButton("DELETE");

        String[] columnNames = {"Item Name", "Item Price", "Customer Name", "Customer Address", "Customer Phone", "Payment Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        itemTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        add(scrollPane, BorderLayout.CENTER);

        // Initialize database connection
        initializeDBConnection();
        fetchItems();

        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void initializeDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fetchItems() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT i.name AS itemName, i.price AS itemPrice, p.customer_name, p.customer_address, p.customer_phone, p.payment_status " +
                           "FROM items i " +
                           "JOIN payments p ON i.id = p.item_id";
            ResultSet resultSet = statement.executeQuery(query);

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                String itemName = resultSet.getString("itemName");
                double itemPrice = resultSet.getDouble("itemPrice");
                String customerName = resultSet.getString("customer_name");
                String customerAddress = resultSet.getString("customer_address");
                String customerPhone = resultSet.getString("customer_phone");
                String paymentStatus = resultSet.getString("payment_status");

                Object[] rowData = {itemName, itemPrice, customerName, customerAddress, customerPhone, paymentStatus};
                tableModel.addRow(rowData);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateItem() {
        String itemName = JOptionPane.showInputDialog(this, "Enter Item Name:");
        String itemPriceStr = JOptionPane.showInputDialog(this, "Enter Item Price:");
        double itemPrice = Double.parseDouble(itemPriceStr);

        try {
            String insertItemQuery = "INSERT INTO items (name, price) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertItemQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, itemName);
            preparedStatement.setDouble(2, itemPrice);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int itemId = generatedKeys.getInt(1);

                String customerName = JOptionPane.showInputDialog(this, "Enter Customer Name:");
                String customerAddress = JOptionPane.showInputDialog(this, "Enter Customer Address:");
                String customerPhone = JOptionPane.showInputDialog(this, "Enter Customer Phone:");
                String paymentStatus = JOptionPane.showInputDialog(this, "Enter Payment Status:");

                String insertPaymentQuery = "INSERT INTO payments (item_id, customer_name, customer_address, customer_phone, payment_status) VALUES (?, ?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(insertPaymentQuery);
                preparedStatement.setInt(1, itemId);
                preparedStatement.setString(2, customerName);
                preparedStatement.setString(3, customerAddress);
                preparedStatement.setString(4, customerPhone);
                preparedStatement.setString(5, paymentStatus);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            refreshDashboard();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding item to database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteItem() {
        int selectedRow = itemTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String itemName = (String) tableModel.getValueAt(selectedRow, 0);
        try {
            String deleteItemQuery = "DELETE FROM items WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteItemQuery);
            preparedStatement.setString(1, itemName);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            refreshDashboard();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error deleting item from database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void refreshDashboard() {
        fetchItems();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            updateItem();
        } else if (e.getSource() == btnDelete) {
            deleteItem();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dashboard::new);
    }
}
