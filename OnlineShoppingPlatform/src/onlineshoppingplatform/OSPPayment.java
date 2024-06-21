package onlineshoppingplatform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OSPPayment extends JFrame implements ActionListener {
    private JLabel lblname, lbladd, lblcontact, lblcustomer, lblmop, lblamount, lblSelectedItems, lblTotalPrice;
    private JButton btnPurchase, btnHome, btnCart;
    private JTextField txtname, txtadd, txtcontact, txtamount;
    private JComboBox<String> cmbmop;
    private JPanel panel;
    private JScrollPane scrollPane;
    private DefaultListModel<String> listModel;
    private double totalPrice = 0.0;
    private DBManager dbManager;
    private String selectedItems;

    OSPPayment(String selectedItems, double totalPrice, DBManager dbManager) {
        this.selectedItems = selectedItems;
        this.totalPrice = totalPrice;
        this.dbManager = dbManager;

        setTitle("Payment");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblcustomer = new JLabel("Customer's Information");
        lblcustomer.setBounds(20, 20, 220, 20);
        lblcustomer.setFont(new Font("Arial", Font.BOLD, 16));

        lblname = new JLabel("Name");
        lblname.setBounds(100, 160, 100, 20);
        lblname.setFont(new Font("Arial", Font.BOLD, 15));

        lbladd = new JLabel("Address");
        lbladd.setBounds(100, 190, 100, 20);
        lbladd.setFont(new Font("Arial", Font.BOLD, 15));

        lblcontact = new JLabel("Contact No");
        lblcontact.setBounds(100, 220, 100, 20);
        lblcontact.setFont(new Font("Arial", Font.BOLD, 15));

        lblamount = new JLabel("Amount");
        lblamount.setBounds(100, 250, 100, 20);
        lblamount.setFont(new Font("Arial", Font.BOLD, 15));

        lblmop = new JLabel("Mode of Payment");
        lblmop.setBounds(100, 300, 210, 20);
        lblmop.setFont(new Font("Arial", Font.BOLD, 15));

        txtname = new JTextField();
        txtname.setBounds(200, 160, 200, 20);
        txtname.setFont(new Font("Arial", Font.PLAIN, 15));

        txtadd = new JTextField();
        txtadd.setBounds(200, 190, 200, 20);
        txtadd.setFont(new Font("Arial", Font.PLAIN, 15));

        txtcontact = new JTextField();
        txtcontact.setBounds(200, 220, 200, 20);
        txtcontact.setFont(new Font("Arial", Font.PLAIN, 15));

        txtamount = new JTextField();
        txtamount.setBounds(200, 250, 200, 20);
        txtamount.setFont(new Font("Arial", Font.PLAIN, 15));

        panel = new JPanel();
        panel.setBounds(20, 340, 560, 240);
        panel.setLayout(new BorderLayout());

        lblSelectedItems = new JLabel("Selected Items:");
        lblSelectedItems.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(lblSelectedItems, BorderLayout.NORTH);

        JTextArea selectedItemsArea = new JTextArea(selectedItems);
        selectedItemsArea.setFont(new Font("Arial", Font.PLAIN, 15));
        selectedItemsArea.setEditable(false);
        panel.add(new JScrollPane(selectedItemsArea), BorderLayout.CENTER);

        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        lblTotalPrice = new JLabel("Total Price: $" + totalPrice);
        lblTotalPrice.setFont(new Font("Arial", Font.BOLD, 15));
        pricePanel.add(lblTotalPrice);
        panel.add(pricePanel, BorderLayout.SOUTH);

        btnPurchase = new JButton("Purchase");
        btnPurchase.setBounds(350, 600, 100, 30);
        btnPurchase.addActionListener(this);

        btnHome = new JButton("HOME");
        btnHome.setBounds(20, 50, 70, 30);
        btnHome.addActionListener(this);

        btnCart = new JButton("CART");
        btnCart.setBounds(100, 50, 70, 30);
        btnCart.addActionListener(this);

        add(lblcustomer);
        add(lblname);
        add(lbladd);
        add(lblcontact);
        add(lblamount);
        add(lblmop);
        add(btnPurchase);
        add(btnHome);
        add(btnCart);
        add(txtname);
        add(txtadd);
        add(txtcontact);
        add(txtamount);
        add(panel);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPurchase) {
            String name = txtname.getText();
            String address = txtadd.getText();
            String contact = txtcontact.getText();
            double amount = Double.parseDouble(txtamount.getText());
            String paymentMethod = (String) cmbmop.getSelectedItem();

            try {
                dbManager.addPayment(name, address, contact, amount, paymentMethod);
                generateReceipt();
                JOptionPane.showMessageDialog(this, "Payment processed successfully! Receipt generated.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error processing payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnHome) {
            new shopping();
            dispose();
        } else if (e.getSource() == btnCart) {
            new OSPCart();
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
    
}
