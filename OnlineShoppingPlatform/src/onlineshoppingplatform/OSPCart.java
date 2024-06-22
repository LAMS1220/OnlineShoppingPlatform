package onlineshoppingplatform;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class OSPCart extends JFrame implements ActionListener {
    private JTable cartTable;
    private JButton btnConfirm, btnAddItem, btnUpdateItem, btnDeleteItem;
    private DefaultTableModel tableModel;

    private DBManager dbManager;

    public OSPCart() {
        setTitle("SHOPPING");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnNames = {"ID", "Item", "Description", "Price", "Quantity"};
        tableModel = new DefaultTableModel(columnNames, 0);
        cartTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setBounds(20, 20, 560, 280);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(scrollPane);

        btnAddItem = new JButton("Add Item");
        btnAddItem.setBounds(20, 320, 100, 30);
        btnAddItem.addActionListener(this);

        btnUpdateItem = new JButton("Update Item");
        btnUpdateItem.setBounds(130, 320, 100, 30);
        btnUpdateItem.addActionListener(this);

        btnDeleteItem = new JButton("Delete Item");
        btnDeleteItem.setBounds(240, 320, 100, 30);
        btnDeleteItem.addActionListener(this);

        btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(350, 320, 100, 30);
        btnConfirm.addActionListener(this);

        panel.add(btnAddItem);
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
                int id = resultSet.getInt("id");
                String item = resultSet.getString("item");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

                tableModel.addRow(new Object[]{id, item, description, price, quantity});
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addItemToCart() {
        JTextField itemField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField quantityField = new JTextField();
        Object[] message = {
            "Item:", itemField,
            "Description:", descriptionField,
            "Price:", priceField,
            "Quantity:", quantityField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Item to Cart", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String item = itemField.getText();
            String description = descriptionField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            try {
                dbManager.addItemToCart(item, description, price, quantity);
                tableModel.addRow(new Object[]{null, item, description, price, quantity});
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateItemInCart() {
        int selectedRow = cartTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to update.");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);
        String item = (String) tableModel.getValueAt(selectedRow, 1);
        String description = (String) tableModel.getValueAt(selectedRow, 2);
        double price = (double) tableModel.getValueAt(selectedRow, 3);
        int quantity = (int) tableModel.getValueAt(selectedRow, 4);

        JTextField itemField = new JTextField(item);
        JTextField descriptionField = new JTextField(description);
        JTextField priceField = new JTextField(String.valueOf(price));
        JTextField quantityField = new JTextField(String.valueOf(quantity));
        Object[] message = {
            "Item:", itemField,
            "Description:", descriptionField,
            "Price:", priceField,
            "Quantity:", quantityField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Update Item", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            item = itemField.getText();
            description = descriptionField.getText();
            price = Double.parseDouble(priceField.getText());
            quantity = Integer.parseInt(quantityField.getText());

            try {
                dbManager.updateCartItem(id, item, description, price, quantity);
                tableModel.setValueAt(item, selectedRow, 1);
                tableModel.setValueAt(description, selectedRow, 2);
                tableModel.setValueAt(price, selectedRow, 3);
                tableModel.setValueAt(quantity, selectedRow, 4);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteItemFromCart() {
        int selectedRow = cartTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.");
            return;
        }

        int id = (int) tableModel.getValueAt(selectedRow, 0);

        try {
            dbManager.deleteCartItem(id);
            tableModel.removeRow(selectedRow);
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
                    String item = (String) tableModel.getValueAt(i, 1);
                    int quantity = Integer.parseInt(tableModel.getValueAt(i, 4).toString());
                    double price = Double.parseDouble(tableModel.getValueAt(i, 3).toString());
                    totalPrice += price * quantity;

                    // Append item to selectedItems list
                    selectedItems.append(item).append(" (").append(quantity).append("), ");
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
        } else if (e.getSource() == btnAddItem) {
            addItemToCart();
        } else if (e.getSource() == btnUpdateItem) {
            updateItemInCart();
        } else if (e.getSource() == btnDeleteItem) {
            deleteItemFromCart();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OSPCart());
    }
}
