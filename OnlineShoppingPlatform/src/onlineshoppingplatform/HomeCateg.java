/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshoppingplatform;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author noctafly
 */
public class HomeCateg extends JFrame implements ActionListener{
    private JButton homecat, personalcat, workcat, home, cart1, cart2, cart3, cart;  
    private JLabel categ, name1, name2, name3, price1, price2, price3,item1, item2, item3, desc1, desc2, desc3;
    private JPanel panel;
    
    HomeCateg() {
    
    JFrame Home = new JFrame("HOME ITEMS CATEGORY");
     
    Home.setSize(600, 435);
        
        //header
        categ = new JLabel("HOME CATEGORY");
        cart = new JButton("CART");
        home = new JButton("HOME");
       
        //main categories
        homecat = new JButton("HOME");
        personalcat = new JButton("PERSONAL");
        workcat = new JButton("WORK");
  
        //items
        item1 = new JLabel("Item 1");
        item2 = new JLabel("Item 2");
        item3 = new JLabel("Item 3");
        
        //product names
        name1 = new JLabel("PRODUCT NAME:  Electric Toothbrush");
        name2 = new JLabel("PRODUCT NAME:  Body and Hand Wash");
        name3 = new JLabel("PRODUCT NAME: Ponds Men Facial Wash");
        
        
        //product descriptions
        desc1 = new JLabel("DESCRIPTION: Cleans teeth");
        desc2 = new JLabel("DESCRIPTION: Body hygiene care");
        desc3 = new JLabel("DESCRIPTION: Facial hygiene care");
        
        //prices
        price1 = new JLabel("PRICE:  $1,230");
        price2 = new JLabel("PRICE:  $225.26");
        price3 = new JLabel("PRICE:  $291.82");
        
         //add to cart buttons
        cart1 = new JButton("Select product");
        cart2 = new JButton("Select product");
        cart3 = new JButton("Select product");
        
        panel = new JPanel();
        panel.setBounds(140, 60, 430, 320);
        panel.setBackground(Color.WHITE);
        
        //header ooordinates       
        categ.setBounds(25, 0, 200, 50);
        cart.setBounds(490, 14, 80, 30);
        home.setBounds(390, 14, 80, 30);
                          
        categ.setFont(new Font("Arial", Font.BOLD, 15 ));
               
        //main categories coordinates
        homecat.setBounds(20, 100, 100, 30);
        personalcat.setBounds(20, 200, 100, 30);
        workcat.setBounds(20, 300, 100, 30);
        
        homecat.setFont(new Font("Arial", Font.BOLD, 15));
       
        //items coordinates
        item1.setBounds(160, 30, 100, 100);
        item2.setBounds(160, 140, 100, 100);
        item3.setBounds(160, 260, 100, 100);
        
        item1.setFont(new Font("Arial", Font.PLAIN, 14));
        item2.setFont(new Font("Arial", Font.PLAIN, 14));
        item3.setFont(new Font("Arial", Font.PLAIN, 14));
        
        //names coordinates
        name1.setBounds(180, 30, 250, 150);
        name2.setBounds(180, 140, 250, 150);
        name3.setBounds(180, 260, 250, 150);
      
        //description coordinates
        desc1.setBounds(180, 70, 200, 100);
        desc2.setBounds(180, 180, 250, 100);
        desc3.setBounds(180, 300, 200, 100);
        
        //prices coordinates
        price1.setBounds(180, 60, 150, 150);
        price2.setBounds(180, 170, 150, 150);
        price3.setBounds(180, 290, 150, 150);
        
         //add to cart coordinates
        cart1.setBounds(430, 100, 120, 30);
        cart2.setBounds(430, 210, 120, 30);
        cart3.setBounds(430, 330, 120, 30);
               
         //Action Listener
        homecat.addActionListener(this);
        personalcat.addActionListener(this);
        workcat.addActionListener(this);      
        home.addActionListener(this);
        cart.addActionListener(this);
        
        Home.add(categ);
        Home.add(home);
        Home.add(homecat);
        Home.add(personalcat);
        Home.add(workcat);
        Home.add(name1);
        Home.add(name2);
        Home.add(name3);
        Home.add(price1);
        Home.add(price2);
        Home.add(price3);
        Home.add(cart1);
        Home.add(cart2);
        Home.add(cart3);
        Home.add(cart);
        Home.add(item1);
        Home.add(item2);
        Home.add(item3);
        Home.add(desc1);
        Home.add(desc2);
        Home.add(desc3);
        Home.add(panel);
        
        
        Home.setLayout(null);            
        Home.setVisible(true);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
            
            if(e.getSource() == homecat){
                HomeCateg hc = new HomeCateg();
                hc.setVisible(true);
            }
            else if(e.getSource() == personalcat){
                PersonalCateg pc = new PersonalCateg();
                pc.setVisible(true);
            }
            else if(e.getSource() == workcat){
                WorkCateg wc = new WorkCateg();
                wc.setVisible(true);
            }         
             else if(e.getSource() == home){
               shopping menu = new shopping();
                menu.setVisible(true);
            }
             else if(e.getSource() == cart){
               OSPCart cart = new OSPCart();
               cart.setVisible(true);

             }

    }  
    public static void main(String[]args){
        
        new HomeCateg() {};
    }
}