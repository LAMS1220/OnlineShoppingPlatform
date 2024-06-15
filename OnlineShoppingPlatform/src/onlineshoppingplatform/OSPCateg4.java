
package onlineshoppingplatform;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author noctafly
 */
public class OSPCateg4 extends JFrame implements ActionListener{
    private JButton apparel, appliances, furnitures, gadgets, hygiene,home;  
    private JLabel categ, name, name1, name2, name3, name4, price1, price2, price3, price4, product1, product2, product3, product4, icon;
    
    OSPCateg4() {
    
    JFrame Gadgets = new JFrame("GADGETS CATEGORY");
     
    Gadgets.setSize(600, 700);
        
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

        //displayed products on category tab
        product1 = new JLabel("/product img/");
        product2 = new JLabel("/product img/");
        product3 = new JLabel("/product img/");
        product4 = new JLabel("/product img/");
        
        //product names
        name1 = new JLabel("Samsung Z Flip 5");
        name2 = new JLabel("Asus ROG 3");
        name3 = new JLabel("Mi Pad 5");
        name4 = new JLabel("Mechanical Keyboard");
        
        //prices
        price1 = new JLabel("$1,230");
        price2 = new JLabel("$225.26");
        price3 = new JLabel("$291.82");
        price4 = new JLabel("$100.12");
        
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
        appliances.addActionListener(this);
        furnitures.addActionListener(this);
        apparel.addActionListener(this);
        hygiene.addActionListener(this);
        gadgets.addActionListener(this);
        home.addActionListener(this);
        
        Gadgets.add(categ);
        Gadgets.add(name);
        Gadgets.add(icon);
        Gadgets.add(home);
        Gadgets.add(apparel);
        Gadgets.add(appliances);
        Gadgets.add(furnitures);
        Gadgets.add(gadgets);
        Gadgets.add(hygiene);
        Gadgets.add(product1);
        Gadgets.add(product2);
        Gadgets.add(product3);
        Gadgets.add(product4);
        Gadgets.add(name1);
        Gadgets.add(name2);
        Gadgets.add(name3);
        Gadgets.add(name4);
        Gadgets.add(price1);
        Gadgets.add(price2);
        Gadgets.add(price3);
        Gadgets.add(price4);
       
        Gadgets.setLayout(null);            
        Gadgets.setVisible(true);
        Gadgets.setResizable(false);
        Gadgets.setDefaultCloseOperation(Gadgets.EXIT_ON_CLOSE);
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