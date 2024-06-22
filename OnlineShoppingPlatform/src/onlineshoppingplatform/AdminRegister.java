package onlineshoppingplatform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdminRegister extends JFrame implements ActionListener {
    private JLabel lblUsername, lblPassword, lblTitle;
    private JTextField txtfldUsername;
    private JPasswordField txtfldPassword;
    private JButton btnRegister, btnBack;
    private DBManager db;

    public AdminRegister() {
        db = new DBManager();
        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            try {
                db.registerAdmin(txtfldUsername.getText(), new String(txtfldPassword.getPassword()));
                JOptionPane.showMessageDialog(this, "Admin registered successfully!");
                dispose();
                new Dashboard().setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed to register admin: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnBack) {
            this.dispose();
            new Menu().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AdminRegister();
    }
}
