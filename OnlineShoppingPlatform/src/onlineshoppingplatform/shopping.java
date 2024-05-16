import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alzona
 */
public class shopping implements ActionListener {
    private JFrame f=new JFrame("Online Shopping System");
    private JLabel lblHomepage,lblOSP,lblCAtegories, lblvariation;
    private JTextField txtfldSearch=new JTextField();
    private JButton btnCart,btnPayment, btnapparel,btnappliances,btnfurniture, btngadgets, btnhygiene;
    shopping(){
        
        f.setSize(600,700);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
        lblHomepage = new JLabel("HOMEPAGE");
        lblHomepage.setBounds(10, 10, 100, 30);
        lblHomepage.setFont(new Font("Arial", Font.BOLD, 15));
        
        lblOSP = new JLabel("ONLINE SHOPPING");
        lblOSP.setBounds(10, 50, 150, 30);
        lblOSP.setFont(new Font("Arial", Font.BOLD, 15));
        
        lblCAtegories = new JLabel("Categories");
        lblCAtegories.setBounds(10, 120, 150, 30);
        lblCAtegories.setFont(new Font("Arial", Font.BOLD, 15));
        
        txtfldSearch.setBounds(15, 80, 220,30);
        txtfldSearch.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btnCart = new JButton("Cart");
        btnCart.setBounds(250, 80, 100, 30);
        btnCart.setFont(new Font("Arial", Font.PLAIN, 15));
        btnCart.addActionListener(this);
        
        btnPayment = new JButton("Payment");
        btnPayment.setBounds(360, 80, 100, 30);
        btnPayment.setFont(new Font("Arial", Font.PLAIN, 15));
        btnPayment.addActionListener(this);

        btnapparel = new JButton("APPAREL");
        btnapparel.setBounds(10, 150, 100, 30);
        btnapparel.setFont(new Font("Arial", Font.PLAIN, 10));
        btnapparel.addActionListener(this);
        
        lblvariation = new JLabel("VARIATION");
        lblvariation.setBounds(300, 300, 100, 30);
        lblvariation.setFont(new Font("Arial", Font.BOLD, 15));
        
        btnappliances = new JButton("APPLIANCES");
        btnappliances.setBounds(120, 150, 100, 30);
        btnappliances.setFont(new Font("Arial", Font.PLAIN, 10));
        btnappliances.addActionListener(this);

        btnfurniture = new JButton("FURNITURE");
        btnfurniture.setBounds(230, 150, 100, 30);
        btnfurniture.setFont(new Font("Arial", Font.PLAIN, 10));
        btnfurniture.addActionListener(this);
        
        f.add(lblHomepage);    
        f.add(lblOSP);
        f.add(txtfldSearch);
        f.add(btnCart);
        f.add(btnPayment);
        f.add(lblCAtegories);
        f.add(btnapparel);
        f.add(lblvariation);
        f.add(btnappliances);
        f.add(btnfurniture);
        
        f.setVisible(true);
        f.setResizable(false);
        
    }
    public void actionPerformed(ActionEvent e){
    }
    }