package onlineshoppingplatform;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alzona
 */
public class shopping extends JFrame implements ActionListener{
    
    private JLabel lblHomepage ,lblOSP, lblCategories, lblproduct1, lblproduct2,lblproduct3 ,lblproduct4, lbltext1,lbltext2,lbltext3,lbltext4 ;
    private JTextField txtfldSearch;
    private JButton btnCart,btnPayment, btnapparel,btnappliances,btnfurniture, btngadgets, btnhygiene;
    
    shopping(){
        
        setTitle("Online Shopping Platform");
        setSize(600,700);
        
        lblHomepage = new JLabel("HOMEPAGE");
        lblHomepage.setBounds(10, 10, 100, 30);
        lblHomepage.setFont(new Font("Arial", Font.BOLD, 15));
        
        lblOSP = new JLabel("ONLINE SHOPPING");
        lblOSP.setBounds(10, 50, 150, 30);
        lblOSP.setFont(new Font("Arial", Font.BOLD, 15));
        
        lblCategories = new JLabel("CATEGORIES");
        lblCategories.setBounds(10, 120, 150, 30);
        lblCategories.setFont(new Font("Arial", Font.BOLD, 15));
        
        txtfldSearch = new JTextField();
        txtfldSearch.setBounds(10, 80, 220,30);
        txtfldSearch.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btnCart = new JButton("CART");
        btnCart.setBounds(250, 80, 100, 30);
        btnCart.setFont(new Font("Arial", Font.BOLD, 15));
        
        btnPayment = new JButton("PAYMENT");
        btnPayment.setBounds(360, 80, 110, 30);
        
        btnPayment.setFont(new Font("Arial", Font.BOLD, 15));
        
        btnapparel = new JButton("APPAREL");
        btnapparel.setBounds(10, 150, 100, 30);
        btnapparel.setFont(new Font("Arial", Font.BOLD, 10));
        
        btnappliances = new JButton("APPLIANCES");
        btnappliances.setBounds(120, 150, 100, 30);
        btnappliances.setFont(new Font("Arial", Font.BOLD, 10));
        
        btnfurniture = new JButton("FURNITURE");
        btnfurniture.setBounds(230, 150, 100, 30);
        btnfurniture.setFont(new Font("Arial", Font.BOLD, 10));
        
        btngadgets = new JButton("GADGETS");
        btngadgets.setBounds(340, 150, 100, 30);
        btngadgets.setFont(new Font("Arial", Font.BOLD, 10));
        
        btnhygiene = new JButton("HYGIENE");
        btnhygiene.setBounds(450, 150, 100, 30);
        btnhygiene.setFont(new Font("Arial", Font.BOLD, 10));
        
        lblproduct1 = new JLabel ("IMAGE");
        lblproduct1.setBounds(50, 350, 70, 25);
        lblproduct1.setFont(new Font("Arial", Font.BOLD,15));
        
        lblproduct2 = new JLabel ("IMAGE");
        lblproduct2.setBounds(200, 350, 70, 25);
        lblproduct2.setFont(new Font("Arial", Font.BOLD,15));
        
        lblproduct3 = new JLabel ("IMAGE");
        lblproduct3.setBounds(350, 350, 70, 25);
        lblproduct3.setFont(new Font("Arial", Font.BOLD,15));
        
        lblproduct4 = new JLabel ("IMAGE");
        lblproduct4.setBounds(475, 350, 70, 25);
        lblproduct4.setFont(new Font("Arial", Font.BOLD,15));
        
        lbltext1 = new JLabel ("DESCRIPTION");
        lbltext1.setBounds(50, 370, 100, 25);
        lbltext1.setFont(new Font("Arial", Font.BOLD,10));
        
        lbltext2 = new JLabel ("DESCRIPTION");
        lbltext2.setBounds(200, 370, 100, 25);
        lbltext2.setFont(new Font("Arial", Font.BOLD,10));
        
        lbltext3 = new JLabel ("DESCRIPTION");
        lbltext3.setBounds(350, 370, 100, 25);
        lbltext3.setFont(new Font("Arial", Font.BOLD,10));
        
        lbltext4 = new JLabel ("DESCRIPTION");
        lbltext4.setBounds(475, 370, 100, 25);
        lbltext4.setFont(new Font("Arial", Font.BOLD,10));
        
        add(lblHomepage);    
        add(lblOSP);
        add(txtfldSearch);
        add(btnCart);
        add(btnPayment);
        add(lblCategories);
        add(btnapparel);
        add(btnappliances);
        add(btnfurniture);
        add(btngadgets);
        add(btnhygiene);
        add(lblproduct1);
        add(lblproduct2);
        add(lblproduct3);
        add(lblproduct4);
        add(lbltext1);
        add(lbltext2);
        add(lbltext3);
        add(lbltext4);
        
        btnCart.addActionListener(this);
        btnPayment.addActionListener(this);
        btnapparel.addActionListener(this);
        btnappliances.addActionListener(this);
        btnfurniture.addActionListener(this);
        btngadgets.addActionListener(this);
        btnhygiene.addActionListener(this);
        
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void actionPerformed (ActionEvent e){
        
        dispose();
        if(e.getSource() == btnPayment){
            OSPPayment payment = new OSPPayment();
            payment.setVisible(true);
            
        }else if (e.getSource() == btnCart) {
            OSPCart cart = new OSPCart();
            cart.setVisible(true);
        }
        else if(e.getSource() == btnapparel){
            OSPCategory categ = new OSPCategory();
            categ.setVisible(true);      
        }
        else if(e.getSource() == btnappliances){
            OSPCateg2 appliance = new OSPCateg2();
            appliance.setVisible(true);
        }
        else if(e.getSource() == btnfurniture){
            OSPCateg3 furnitures = new OSPCateg3();
            furnitures.setVisible(true);                    
        }
        else if(e.getSource() == btngadgets){
            OSPCateg4 gadgets = new OSPCateg4();
            gadgets.setVisible(true);    
        }
        else if(e.getSource() == btnhygiene){
            OSPCateg5 hygiene = new OSPCateg5();
            hygiene.setVisible(true);
        }
    }
}
