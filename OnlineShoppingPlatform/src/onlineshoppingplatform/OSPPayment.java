package onlineshoppingplatform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OSPPayment extends JFrame implements ActionListener {
    private JLabel lblname, lbladd, lblcontact, lblcustomer, lblmop, lblamount, lblSelectedItems, lblTotalPrice;
    private JButton btnPurchase, btnHome;
    private JTextField txtname, txtadd, txtcontact, txtamount;
    private JComboBox<String> cmbmop;
    private JPanel customerPanel, itemsPanel, buttonPanel;
    private JScrollPane scrollPane;
    private double totalPrice;
    private DBManager dbManager;
    private String selectedItems;

    public OSPPayment(String selectedItems, double totalPrice, DBManager dbManager) {
        this.selectedItems = selectedItems;
        this.totalPrice = totalPrice;
        this.dbManager = dbManager;

        setTitle("PAYMENT");
        setSize(600, 700);
        setLayout(new BorderLayout());

        // Customer information panel
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

        String[] paymentMethods = {"Cash on Delivery", "Credit Card", "Debit Card", "PayPal"};
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

        // Items and price panel
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BorderLayout());
        itemsPanel.setPreferredSize(new Dimension(600, 150));

        lblSelectedItems = new JLabel("ITEMS SELECTED: ");
        lblSelectedItems.setFont(new Font("Arial", Font.BOLD, 15));
        itemsPanel.add(lblSelectedItems, BorderLayout.NORTH);

        JTextArea selectedItemsArea = new JTextArea(selectedItems);
        selectedItemsArea.setFont(new Font("Arial", Font.PLAIN, 15));
        selectedItemsArea.setEditable(false);
        itemsPanel.add(new JScrollPane(selectedItemsArea), BorderLayout.CENTER);

        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lblTotalPrice = new JLabel("Total Price: $" + totalPrice);
        lblTotalPrice.setFont(new Font("Arial", Font.BOLD, 15));
        pricePanel.add(lblTotalPrice);
        itemsPanel.add(pricePanel, BorderLayout.SOUTH);

        // Button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setPreferredSize(new Dimension(600, 50));

        btnPurchase = new JButton("CHECK OUT");
        btnPurchase.setBounds(450, 10, 120, 30);
        btnPurchase.addActionListener(this);
        buttonPanel.add(btnPurchase);

        btnHome = new JButton("HOME");
        btnHome.setBounds(10, 10, 100, 30);
        btnHome.addActionListener(this);
        buttonPanel.add(btnHome);

        add(customerPanel, BorderLayout.NORTH);
        add(itemsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPurchase) {
            try {
                String name = txtname.getText();
                String address = txtadd.getText();
                String contact = txtcontact.getText();
                double amount = Double.parseDouble(txtamount.getText());
                String paymentMethod = (String) cmbmop.getSelectedItem();

                dbManager.addPayment(name, address, contact, amount, paymentMethod);
                generateReceipt();
                JOptionPane.showMessageDialog(this, "Order completed successfully! Receipt generated.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnHome) {
            new Home();
            dispose();
        }
    }

    private void generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Receipt\n\n");
        receipt.append("Customer Name: ").append(txtname.getText()).append("\n");
        receipt.append("Address: ").append(txtadd.getText()).append("\n");
        receipt.append("Contact No: ").append(txtcontact.getText()).append("\n\n");
        receipt.append("Selected Items:\n");

        receipt.append(selectedItems).append("\n");

        receipt.append("\nTotal Price: $").append(totalPrice).append("\n");
        receipt.append("Amount Tendered: $").append(txtamount.getText()).append("\n");
        receipt.append("Change: $").append(Double.parseDouble(txtamount.getText()) - totalPrice).append("\n");

        JTextArea receiptArea = new JTextArea(receipt.toString());
        receiptArea.setFont(new Font("Arial", Font.PLAIN, 12));
        receiptArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(receiptArea), "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Example usage:
        DBManager dbManager = new DBManager(); // Assume DBManager is implemented elsewhere
        String selectedItems = "Item 1\nItem 2\nItem 3";
        double totalPrice = 150.0;
        new OSPPayment(selectedItems, totalPrice, dbManager);
    }
}
