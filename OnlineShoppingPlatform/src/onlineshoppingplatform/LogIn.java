/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshoppingplatform;
 
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author ACER
 */
public class LogIn extends JFrame implements ActionListener{
    
    private JLabel lblname;
    private JButton btncust, btnadmin; 
    
    LogIn (){
        
        setSize(500,250);
        setTitle("Log In");
        
        lblname = new JLabel ("OSP : Log In");
        lblname.setFont(new Font ("Arial", Font.BOLD, 25));
        
        btncust = new JButton("Customer");
        btnadmin = new JButton("Admin"); 
        
        add(lblname);
        add(btncust);
        add(btnadmin);
        
        lblname.setBounds (170, 40, 200, 80);
        btncust.setBounds(260, 120  , 100, 30);
        btnadmin.setBounds(130, 120, 100, 30);
        
        btncust.addActionListener(this);
        btnadmin.addActionListener(this);
        //btnadmin.addActionListener(this);
        
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        
        if (e.getSource()== btncust){
        shopping menu = new shopping();
        menu.setVisible(true);  
        dispose();
        }
        
        else if (e.getSource()== btnadmin){
        Admin ad = new Admin();
        ad.setVisible(true);
        dispose();
        }
    }

public static void main(String[] args) {
        // TODO code application logic here
            EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LogIn login = new LogIn();
                login.setVisible(true);
            }
        });
    
    }

}
    


 
