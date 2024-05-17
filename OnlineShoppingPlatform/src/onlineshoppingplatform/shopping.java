package onlineshoppingplatform;

import javax.swing.*;
import java.awt.Font;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alzona
 */
public class shopping {
    
    private JLabel lblHomepage ,lblOSP, lblCategories, lblproduct1, lblproduct2,lblproduct3 ,lblproduct4, lbltext1,lbltext2,lbltext3,lbltext4 ;
    private JTextField txtfldSearch;
    private JButton btnCart,btnPayment, btnapparel,btnappliances,btnfurniture, btngadgets, btnhygiene;
    
    shopping(){
        JFrame f = new JFrame("Online Shopping Platform");
        
        f.setSize(600,700);
        
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
        
        f.add(lblHomepage);    
        f.add(lblOSP);
        f.add(txtfldSearch);
        f.add(btnCart);
        f.add(btnPayment);
        f.add(lblCategories);
        f.add(btnapparel);
        f.add(btnappliances);
        f.add(btnfurniture);
        f.add(btngadgets);
        f.add(btnhygiene);
        f.add(lblproduct1);
        f.add(lblproduct2);
        f.add(lblproduct3);
        f.add(lblproduct4);
        f.add(lbltext1);
        f.add(lbltext2);
        f.add(lbltext3);
        f.add(lbltext4);
        
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new shopping(){};
    }
    }