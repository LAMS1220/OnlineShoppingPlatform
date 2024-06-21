package onlineshoppingplatform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Dashboard extends JFrame {
    private JTable itemTable;
    private DefaultTableModel tableModel;

    public Dashboard() {
        setTitle("Administrator Dashboard");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize table with headers and no data initially
        String[] columnNames = {"Item Name", "Item Price", "Customer Name", "Customer Address", "Customer Phone", "Payment Status"};
        tableModel = new DefaultTableModel(columnNames, 0); // 0 rows initially

        itemTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        add(scrollPane, BorderLayout.CENTER);

        fetchItems(); // Fetch items from database and populate the table

        setVisible(true);
    }

    private void fetchItems() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_db", "username", "password");
            statement = connection.createStatement();
            // Assuming 'items' and 'payments' tables and their relationship
            String query = "SELECT i.name AS itemName, i.price AS itemPrice, p.customer_name, p.customer_address, p.customer_phone, p.payment_status " +
                           "FROM items i " +
                           "JOIN payments p ON i.id = p.item_id"; // Adjust the join condition based on your actual schema
            resultSet = statement.executeQuery(query);

            // Clear existing rows before adding updated ones
            tableModel.setRowCount(0);

            while (resultSet.next()) {
                String itemName = resultSet.getString("itemName");
                double itemPrice = resultSet.getDouble("itemPrice");
                String customerName = resultSet.getString("customer_name");
                String customerAddress = resultSet.getString("customer_address");
                String customerPhone = resultSet.getString("customer_phone");
                String paymentStatus = resultSet.getString("payment_status");

                // Add each row to the table model
                Object[] rowData = {itemName, itemPrice, customerName, customerAddress, customerPhone, paymentStatus};
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching data from database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources in the reverse order of their opening
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to refresh dashboard view when updates occur
    public void refreshDashboard() {
        fetchItems(); // Reload items from database and update the table
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dashboard::new);
    }
}
