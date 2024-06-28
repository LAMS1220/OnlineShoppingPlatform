package onlineshopp;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    
    private JLabel lblTitle;
    private JButton btnRegister, btnLogin, btncus; 
    
    public Menu() {
        setSize(500, 300);
        setTitle("Admin Portal");

        lblTitle = new JLabel("ONLINE SHOPPING PLATFORM");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));

        btnRegister = new JButton("REGISTER");
        btnLogin = new JButton("LOGIN");
        btncus = new JButton ("CUSTOMER");
        
        
        add(lblTitle);
        add(btnRegister);
        add(btnLogin);
        add(btncus);
        
        lblTitle.setBounds(100, 40, 300, 80);
        btnRegister.setBounds(260, 120, 100, 30);
        btnLogin.setBounds(130, 120, 100, 30);
        btncus.setBounds(195, 170, 100, 30);
        
        btnRegister.addActionListener(this);
        btnLogin.addActionListener(this);
        btncus.addActionListener(this);
        
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {
            JOptionPane.showMessageDialog(this, "Welcome.", "SIGNUP", JOptionPane.INFORMATION_MESSAGE);
            AdminRegister adminRegister = new AdminRegister();
            adminRegister.setVisible(true);
            dispose();
        } else if (e.getSource() == btnLogin) {
            JOptionPane.showMessageDialog(this, "Welcome.", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
            AdminLogin adminLogin = new AdminLogin();
            adminLogin.setVisible(true);
            dispose();
        }
        else if (e.getSource() == btncus) {
            JOptionPane.showMessageDialog(this, "Welcome Customer!", "SHOPPING", JOptionPane.INFORMATION_MESSAGE);
            Home home = new Home();
            home.setVisible(true);
            dispose();
        }
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu login = new Menu();
                login.setVisible(true);
            }
        });
    }
}
