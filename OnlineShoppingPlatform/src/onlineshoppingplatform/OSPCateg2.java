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
public class OSPCateg2 extends JFrame implements ActionListener{
    private JButton apparel, appliances, furnitures, gadgets, hygiene, ref, efan, tv, ac, microwave, home;  
    private JLabel categ, name, name1, name2, name3, name4, price1, price2, price3, price4, product1, product2, product3, product4, icon;
    
    OSPCateg2() {
    
    JFrame appliance = new JFrame("APPLIANCES CATEGORY");
     
    appliance.setSize(600, 700);
        
        //header
        categ = new JLabel("CATEGORIES");
        name = new JLabel("OSP");
        icon = new JLabel("/icon/");
        home = new JButton("HOME");
        
        
        //main categories
        apparel = new JButton("Apparel");
        appliances = new JButton("Appliances");
        furnitures = new JButton("Furnitures");
        gadgets = new JButton("Gadgets");
        hygiene = new JButton("Hygiene");
        
        //sub categories
        ref = new JButton("Refrigerator");
        efan = new JButton("Electric Fan");
        tv = new JButton("Television");
        ac = new JButton("Aircon");
        microwave = new JButton("Microwave");
        
        //displayed products on category tab
        product1 = new JLabel("/product img/");
        product2 = new JLabel("/product img/");
        product3 = new JLabel("/product img/");
        product4 = new JLabel("/product img/");
        
        //product names
        name1 = new JLabel("Air Cooler Fan");
        name2 = new JLabel("Electric Kettle");
        name3 = new JLabel("9.0L Air Fryer");
        name4 = new JLabel("Large Rice Cooker");
        
        //prices
        price1 = new JLabel("$2");
        price2 = new JLabel("$10");
        price3 = new JLabel("$28");
        price4 = new JLabel("$43");
        
        //header ooordinates
        
        categ.setBounds(25, 0, 100, 50);
        name.setBounds(120, 25, 40, 40);
        icon.setBounds(25, 25, 40, 40);
        home.setBounds(25, 65, 70, 25);
        
        //sizes
        categ.setFont(new Font("Ariel", Font.BOLD, 15 ));
        
        //main categories coordinates
        apparel.setBounds(10, 120, 100, 25);
        appliances.setBounds(125, 120, 100, 25);
        furnitures.setBounds(240, 120, 100, 25);
        gadgets.setBounds(355, 120, 100, 25);
        hygiene.setBounds(470, 120, 100, 25);
        
        //sub categories coordinates
        ref.setBounds(25, 160, 90, 23);
        efan.setBounds(135, 160, 95, 23);
        tv.setBounds(250, 160, 90, 23);
        ac.setBounds(360, 160, 90, 23);
        microwave.setBounds(470, 160, 90, 23);
        
        //panel coordinates
        product1.setBounds(30, 200, 150, 150);
        product2.setBounds(170, 200, 150, 150);
        product3.setBounds(310, 200, 150, 150);
        product4.setBounds(450, 200, 150, 150);
        
        //names coordinates
        name1.setBounds(25, 290, 150, 150);
        name2.setBounds(165, 290, 150, 150);
        name3.setBounds(305, 290, 150, 150);
        name4.setBounds(445, 290, 150, 150);
      
        //prices coordinates
        price1.setBounds(25, 305, 150, 150);
        price2.setBounds(165, 305, 150, 150);
        price3.setBounds(305, 305, 150, 150);
        price4.setBounds(445, 305, 150, 150);
        
         //Action Listener
        apparel.addActionListener(this);
        furnitures.addActionListener(this);
        gadgets.addActionListener(this);
        hygiene.addActionListener(this);
        appliances.addActionListener(this);
        home.addActionListener(this);
        
        appliance.add(categ);
        appliance.add(name);
        appliance.add(icon);
        appliance.add(home);
        appliance.add(apparel);
        appliance.add(appliances);
        appliance.add(furnitures);
        appliance.add(gadgets);
        appliance.add(hygiene);
        appliance.add(product1);
        appliance.add(product2);
        appliance.add(product3);
        appliance.add(product4);
        appliance.add(ref);
        appliance.add(efan);
        appliance.add(tv);
        appliance.add(ac);
        appliance.add(microwave);
        appliance.add(name1);
        appliance.add(name2);
        appliance.add(name3);
        appliance.add(name4);
        appliance.add(price1);
        appliance.add(price2);
        appliance.add(price3);
        appliance.add(price4);
        
        ref.setFont(new Font("Arial", Font.PLAIN, 8));
        efan.setFont(new Font("Arial", Font.PLAIN, 8));
        tv.setFont(new Font("Arial", Font.PLAIN, 8));
        ac.setFont(new Font("Arial", Font.PLAIN, 8));
        microwave.setFont(new Font("Arial", Font.PLAIN, 8));
        
        appliance.setLayout(null);            
        appliance.setVisible(true);
        appliance.setResizable(false);
        appliance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
            
            if(e.getSource() == apparel){
                OSPCategory c1 = new OSPCategory();
                c1.setVisible(true);
            }
            else if(e.getSource() == appliances){
                OSPCateg2 c2 = new OSPCateg2();
                c2.setVisible(true);
            }
            else if(e.getSource() == furnitures){
                OSPCateg3 c3 = new OSPCateg3();
                c3.setVisible(true);
            }
            else if(e.getSource() == gadgets){
                OSPCateg4 c4 = new OSPCateg4();
                c4.setVisible(true);
            }
            else if(e.getSource() == hygiene){
                OSPCateg5 c5 = new OSPCateg5();
                c5.setVisible(true);
            }
             else if(e.getSource() == home){
               shopping menu = new shopping();
               menu.setVisible(true);
             }
    }

   
}