/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshoppingplatform;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author ACER
 */
public class Admin extends JFrame {
    
    private JLabel lblname, lblpw;
    private JTextField uname, pass;
    private JButton btnenter;
    
    Admin (){
        
        setSize(500,250);
        setTitle("Log In");
        
        lblname = new JLabel("Username");
        lblname.setFont(new Font ("Arial", Font.BOLD, 20));
        lblpw = new JLabel("Password");
        lblpw.setFont(new Font ("Arial", Font.BOLD, 20));
   
        uname = new JTextField();
        pass = new JTextField();
        btnenter = new JButton("Enter");
        
        add(lblname);
        add(lblpw);
        add(uname);
        add(pass);
        add(btnenter);
        
         lblname.setBounds(50, 40, 200, 80);
         lblpw.setBounds(50, 84 , 200, 80);
         uname.setBounds(160, 60, 200, 30);
         pass.setBounds(160, 110, 200, 30);
         btnenter.setBounds(380, 160, 80, 30);
         
         setLayout(null);
         setResizable(false);
         setVisible(true); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
}

