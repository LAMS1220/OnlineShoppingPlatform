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
public class PersonalCateg extends JFrame implements ActionListener{
    private JButton homecat, personalcat, workcat, home, cart1, cart2, cart3, cart;  
    private JLabel categ, name1, name2, name3, price1, price2, price3,item1, item2, item3, desc1, desc2, desc3;
    private JPanel panel;
    
    PersonalCateg() {
    
    JFrame Personal = new JFrame("PERSONAL ITEMS CATEGORY");
     
    Personal.setSize(600, 435);
        
        //header
        categ = new JLabel("PERSONAL CATEGORY");
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
        name1 = new JLabel("PRODUCT NAME:  Bluetooth Headset");
        name2 = new JLabel("PRODUCT NAME:  Waterproof Laptop Bag");
        name3 = new JLabel("PRODUCT NAME:  Universal Keyboard");
        
        
        //product descriptions
        desc1 = new JLabel("DESCRIPTION: Audio device");
        desc2 = new JLabel("DESCRIPTION: Daily use bag");
        desc3 = new JLabel("DESCRIPTION: Computer peripheral");
        
        //prices
        price1 = new JLabel("PRICE:  $1,291.00");
        price2 = new JLabel("PRICE:  $124.26");
        price3 = new JLabel("PRICE:  $100.82");
        
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
        
        personalcat.setFont(new Font("Arial", Font.BOLD, 12));
       
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
        
        Personal.add(categ);
        Personal.add(home);
        Personal.add(homecat);
        Personal.add(personalcat);
        Personal.add(workcat);
        Personal.add(name1);
        Personal.add(name2);
        Personal.add(name3);
        Personal.add(price1);
        Personal.add(price2);
        Personal.add(price3);
        Personal.add(cart1);
        Personal.add(cart2);
        Personal.add(cart3);
        Personal.add(cart);
        Personal.add(item1);
        Personal.add(item2);
        Personal.add(item3);
        Personal.add(desc1);
        Personal.add(desc2);
        Personal.add(desc3);
        Personal.add(panel);
        
        
        Personal.setLayout(null);            
        Personal.setVisible(true);
        Personal.setResizable(false);
        Personal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        new PersonalCateg(){};
    }
}