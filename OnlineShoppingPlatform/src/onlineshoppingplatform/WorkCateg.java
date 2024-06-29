package onlineshoppingplatform;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkCateg extends JFrame implements ActionListener {
    private JButton btnHome, btnPersonal, btnWork,btnPayment;
    private JLabel lbltitle;
    private List<ItemPanel> pnlItems;
    private Connection conn;
    private List<Item> lstItems;
    private double totalPrice;

    private static final String URL = "jdbc:mysql://localhost:3306/osp";
    private static final String USER = "lance";
    private static final String PASSWORD = "12345";

    public WorkCateg() {
        setTitle("WORK ITEMS CATEGORY");
        setSize(800, 600);
        setResizable(false);
        setLayout(null);

        lbltitle = new JLabel("WORK CATEGORY");
        lbltitle.setFont(new Font("Arial", Font.BOLD, 15));
        lbltitle.setBounds(10, 10, 200, 30);

        btnPayment = new JButton("PAYMENT");
        btnPayment.setBounds(660, 10, 100, 30);
        btnPayment.addActionListener(this);

        btnHome = new JButton("HOME");
        btnPersonal = new JButton("PERSONAL");
        btnWork = new JButton("WORK");

        Dimension buttonSize = new Dimension(100, 30);
        btnHome.setBounds(10, 65, 100, 30);
        btnPersonal.setBounds(10, 230, 100, 30);
        btnWork.setBounds(10, 395, 100, 30);
        
        btnHome.addActionListener(this);
        btnPersonal.addActionListener(this);
        btnWork.addActionListener(this);

        add(btnHome);
        add(btnPersonal);
        add(btnWork);
        add(lbltitle);
        add(btnPayment);


        pnlItems = new ArrayList<>();
        lstItems = new ArrayList<>();
        totalPrice = 0.0;

        establishConnection();

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(0, 1));
        itemsPanel.setBounds(120, 60, 660, 500);

        addItem(itemsPanel, "Laptop", 1000.00);
        addItem(itemsPanel, "Office Chair", 150.00);
        addItem(itemsPanel, "Desk Lamp", 30.00);

        add(itemsPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed");
        }
    }

    private void addItem(JPanel panel, String itemName, double itemPrice) {
        ItemPanel itemPanel = new ItemPanel(itemName, itemPrice);
        pnlItems.add(itemPanel);
        panel.add(itemPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();

        if (e.getSource() == btnHome) {
            HomeCateg hc = new HomeCateg();
            hc.setVisible(true);
        } else if (e.getSource() == btnPersonal) {
            PersonalCateg pc = new PersonalCateg();
            pc.setVisible(true);
        } else if (e.getSource() == btnWork) {
            WorkCateg wc = new WorkCateg();
            wc.setVisible(true);
        } else if (e.getSource() == btnPayment) {
            new OSPPayment(getCartItems(), totalPrice);
            dispose();
        }
    }

    private String getCartItems() {
        StringBuilder items = new StringBuilder();
        for (Item item : lstItems) {
            items.append(item.getName()).append(",").append(item.getPrice()).append("\n");
        }
        return items.toString();
    }

    private void updateCart() {
        // Update cart logic
    }

    private class ItemPanel extends JPanel implements ActionListener {

        private JLabel lblItemName;
        private JLabel lblItemPrice;
        private JButton btnAddToCart;

        public ItemPanel(String itemName, double itemPrice) {
            setLayout(new FlowLayout(FlowLayout.LEFT));

            lblItemName = new JLabel(itemName);
            lblItemPrice = new JLabel("$" + itemPrice);
            btnAddToCart = new JButton("Add to Cart");

            btnAddToCart.addActionListener(this);

            add(lblItemName);
            add(lblItemPrice);
            add(btnAddToCart);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAddToCart) {
                addItemToCart(lblItemName.getText(), Double.parseDouble(lblItemPrice.getText().substring(1)));
            }
        }

        private void addItemToCart(String itemName, double itemPrice) {
            lstItems.add(new Item(itemName, itemPrice));
            totalPrice += itemPrice;
            updateCart();

            try (PreparedStatement insertItemStmt = conn.prepareStatement("INSERT INTO items (name, price) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                insertItemStmt.setString(1, itemName);
                insertItemStmt.setDouble(2, itemPrice);
                insertItemStmt.executeUpdate();

                try (ResultSet generatedKeys = insertItemStmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int itemId = generatedKeys.getInt(1);
                        try (PreparedStatement insertPaymentStmt = conn.prepareStatement("INSERT INTO payments (item_id, customer_name, customer_address, customer_phone, payment_status) VALUES (?, ?, ?, ?, ?)")) {
                            insertPaymentStmt.setInt(1, itemId);
                            insertPaymentStmt.setString(2, "Customer Name");
                            insertPaymentStmt.setString(3, "Customer Address");
                            insertPaymentStmt.setString(4, "Customer Phone");
                            insertPaymentStmt.setString(5, "Pending");
                            insertPaymentStmt.executeUpdate();
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new WorkCateg();
    }

    private class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
