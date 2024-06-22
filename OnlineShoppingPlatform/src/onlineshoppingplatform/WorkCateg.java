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
public class WorkCateg extends JFrame implements ActionListener{
    private JButton homecat, personalcat, workcat, home, cart1, cart2, cart3, cart;  
    private JLabel categ, name1, name2, name3, price1, price2, price3,item1, item2, item3, desc1, desc2, desc3;
    private JPanel panel;
    
    WorkCateg() {
    
    JFrame Work = new JFrame("WORK ITEMS CATEGORY");
     
    Work.setSize(600, 435);
        
        //header
        categ = new JLabel("WORK CATEGORY");
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
        name1 = new JLabel("PRODUCT NAME:  Laptop Stand");
        name2 = new JLabel("PRODUCT NAME:  Anti-theft bag");
        name3 = new JLabel("PRODUCT NAME:  Refillable ink ballpen");
        
        
        //product descriptions
        desc1 = new JLabel("DESCRIPTION: Laptop accessories");
        desc2 = new JLabel("DESCRIPTION: Utility ");
        desc3 = new JLabel("DESCRIPTION: Writing materials");
        
        //prices
        price1 = new JLabel("PRICE:  $2.78");
        price2 = new JLabel("PRICE:  $50.26");
        price3 = new JLabel("PRICE:  $3.82");
        
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
        
        workcat.setFont(new Font("Arial", Font.BOLD, 15));
       
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
        
        Work.add(categ);
        Work.add(home);
        Work.add(homecat);
        Work.add(personalcat);
        Work.add(workcat);
        Work.add(name1);
        Work.add(name2);
        Work.add(name3);
        Work.add(price1);
        Work.add(price2);
        Work.add(price3);
        Work.add(cart1);
        Work.add(cart2);
        Work.add(cart3);
        Work.add(cart);
        Work.add(item1);
        Work.add(item2);
        Work.add(item3);
        Work.add(desc1);
        Work.add(desc2);
        Work.add(desc3);
        Work.add(panel);
        
        
        Work.setLayout(null);            
        Work.setVisible(true);
        Work.setResizable(false);
        Work.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        new WorkCateg(){};
    }
}