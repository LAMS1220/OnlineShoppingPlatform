package onlineshoppingplatform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class OSPCart extends JFrame implements ActionListener {
    private JTable cartTable;
    private JButton btnConfirm;
    private DefaultTableModel tableModel;

    private DBManager dbManager;

    public OSPCart() {
        setTitle("Shopping Cart");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnNames = {"Item", "Description", "Price", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        cartTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setBounds(20, 20, 560, 280);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(scrollPane);

        JButton btnUpdateItem = new JButton("Update Item");
        btnUpdateItem.setBounds(20, 320, 100, 30);
        btnUpdateItem.addActionListener(this);

        JButton btnDeleteItem = new JButton("Delete Item");
        btnDeleteItem.setBounds(130, 320, 100, 30);
        btnDeleteItem.addActionListener(this);

        btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(240, 320, 100, 30);
        btnConfirm.addActionListener(this);

        panel.add(btnUpdateItem);
        panel.add(btnDeleteItem);
        panel.add(btnConfirm);

        add(panel);

        dbManager = new DBManager(); // Initialize DBManager
        loadCartItems(); // Load items from the database into the cart

        setVisible(true);
    }

    private void loadCartItems() {
        try {
            ResultSet resultSet = dbManager.getCartItems();

            while (resultSet.next()) {
                String item = resultSet.getString("item");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                tableModel.addRow(new Object[]{item, description, price, quantity});
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            int rowCount = tableModel.getRowCount();
            if (rowCount > 0) {
                // StringBuilder to collect selected items
                StringBuilder selectedItems = new StringBuilder();

                // Calculate total price
                double totalPrice = 0;
                for (int i = 0; i < rowCount; i++) {
                    String item = (String) tableModel.getValueAt(i, 0);
                    int quantity = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
                    double price = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
                    totalPrice += price * quantity;

                    // Append item to selectedItems list
                    selectedItems.append(item).append(", ");
                }

                // Remove the last comma and space
                if (selectedItems.length() > 0) {
                    selectedItems.setLength(selectedItems.length() - 2);
                }

                // Open OSPPayment with selected items and total price
                new OSPPayment(selectedItems.toString(), totalPrice, dbManager);
                dispose(); // Close the current frame (OSPCart)
            } else {
                JOptionPane.showMessageDialog(this, "Your cart is empty.");
            }
        } else {
            // Implement add, update, and delete item logic here
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OSPCart());
    }
}
