package onlineshoppingplatform;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdminLogin extends JFrame implements ActionListener {
    private JLabel lblTitle, lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnBack;
    private DBManager db;

    public AdminLogin() {
        db = new DBManager();

        setTitle("Admin Login");
        setLayout(null);

        lblTitle = new JLabel("Admin Login");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(120, 30, 200, 30);

        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 80, 100, 25);
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 120, 100, 25);
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));

        txtUsername = new JTextField();
        txtUsername.setBounds(150, 80, 150, 25);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 15));

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 120, 150, 25);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 15));

        btnLogin = new JButton("Login");
        btnLogin.setBounds(50, 180, 100, 30);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
        btnLogin.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(200, 180, 100, 30);
        btnBack.setFont(new Font("Arial", Font.BOLD, 15));
        btnBack.addActionListener(this);

        add(lblTitle);
        add(lblUsername);
        add(lblPassword);
        add(txtUsername);
        add(txtPassword);
        add(btnLogin);
        add(btnBack);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            try {
                if (db.loginAdmin(username, password)) {
                    JOptionPane.showMessageDialog(this, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new Dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Login failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnBack) {
            dispose();
            new Menu().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }
}
