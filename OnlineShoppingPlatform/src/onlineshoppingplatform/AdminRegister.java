package onlineshoppingplatform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminRegister extends JFrame implements ActionListener {

    private JLabel lblUsername, lblPassword, lblTitle;
    private JTextField txtfldUsername;
    private JPasswordField txtfldPassword;
    private JButton btnRegister, btnBack;
    private Connection conn;

    public AdminRegister() {
        initializeDBConnection();

        setTitle("Admin Registration");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTitle = new JLabel("ADMIN REGISTRATION");
        lblTitle.setBounds(75, 20, 250, 30);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));

        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 80, 100, 25);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 15));

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 120, 100, 25);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 15));

        txtfldUsername = new JTextField();
        txtfldUsername.setBounds(150, 80, 150, 25);
        txtfldUsername.setFont(new Font("Arial", Font.PLAIN, 15));

        txtfldPassword = new JPasswordField();
        txtfldPassword.setBounds(150, 120, 150, 25);
        txtfldPassword.setFont(new Font("Arial", Font.PLAIN, 15));

        btnRegister = new JButton("Register");
        btnRegister.setBounds(50, 180, 100, 30);
        btnRegister.setFont(new Font("Arial", Font.BOLD, 15));
        btnRegister.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(200, 180, 100, 30);
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnBack.addActionListener(this);

        add(lblTitle);
        add(lblUsername);
        add(lblPassword);
        add(txtfldUsername);
        add(txtfldPassword);
        add(btnRegister);
        add(btnBack);

        setVisible(true);
        setResizable(false);
    }

    private void initializeDBConnection() {
        try {
            String URL = "jdbc:mysql://localhost:3306/osp";
            String USER = "lance";
            String PASSWORD = "12345";
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
        if (e.getSource() == btnRegister) {
            registerAdmin(txtfldUsername.getText(), new String(txtfldPassword.getPassword()));
            JOptionPane.showMessageDialog(this, "Admin registered successfully!");
            dispose();
            new Dashboard().setVisible(true);
        } else if (e.getSource() == btnBack) {
            this.dispose();
            new Menu().setVisible(true);
        }
    }

    private void registerAdmin(String username, String password) {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO admins (username, password) VALUES (?, ?)")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AdminRegister();
    }
}
