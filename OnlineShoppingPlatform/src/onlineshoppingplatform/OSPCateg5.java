
package onlineshoppingplatform;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author noctafly
 */
public class OSPCateg5 implements ActionListener{
    private JButton apparel, appliances, furnitures, gadgets, hygiene, shave, foot, deo, skin, shower, home;  
    private JLabel categ, name, name1, name2, name3, name4, price1, price2, price3, price4, product1, product2, product3, product4, icon;
    
    public OSPCateg5() {
    
    JFrame Hygiene = new JFrame("CATEGORY");
     
    Hygiene.setSize(600, 700);
        
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
        shave = new JButton("Shaving");
        foot = new JButton("Foot Care");
        deo = new JButton("Deodorant");
        skin = new JButton("Skin Care");
        shower = new JButton("Shower");
        
        //displayed products on category tab
        product1 = new JLabel("/product img/");
        product2 = new JLabel("/product img/");
        product3 = new JLabel("/product img/");
        product4 = new JLabel("/product img/");
        
        //product names
        name1 = new JLabel("Listerine Mouthwash");
        name2 = new JLabel("Wet Wipes");
        name3 = new JLabel("Adorn Sunscreen");
        name4 = new JLabel("Electric Shaver");
        
        //prices
        price1 = new JLabel("$3.71");
        price2 = new JLabel("$1.65");
        price3 = new JLabel("$4.32");
        price4 = new JLabel("$2.51");
        
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
        shave.setBounds(25, 160, 90, 23);
        foot.setBounds(135, 160, 95, 23);
        deo.setBounds(250, 160, 90, 23);
        skin.setBounds(360, 160, 90, 23);
        shower.setBounds(470, 160, 90, 23);
        
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
        apparel.addActionListener(this);
        
        Hygiene.add(categ);
        Hygiene.add(name);
        Hygiene.add(icon);
        Hygiene.add(home);
        Hygiene.add(apparel);
        Hygiene.add(appliances);
        Hygiene.add(furnitures);
        Hygiene.add(gadgets);
        Hygiene.add(hygiene);
        Hygiene.add(product1);
        Hygiene.add(product2);
        Hygiene.add(product3);
        Hygiene.add(product4);
        Hygiene.add(shave);
        Hygiene.add(foot);
        Hygiene.add(deo);
        Hygiene.add(skin);
        Hygiene.add(shower);
        Hygiene.add(name1);
        Hygiene.add(name2);
        Hygiene.add(name3);
        Hygiene.add(name4);
        Hygiene.add(price1);
        Hygiene.add(price2);
        Hygiene.add(price3);
        Hygiene.add(price4);
        
        shave.setFont(new Font("Arial", Font.PLAIN, 8));
        foot.setFont(new Font("Arial", Font.PLAIN, 8));
        deo.setFont(new Font("Arial", Font.PLAIN, 8));
        skin.setFont(new Font("Arial", Font.PLAIN, 8));
        shower.setFont(new Font("Arial", Font.PLAIN, 8));
        
        Hygiene.setLayout(null);            
        Hygiene.setVisible(true);
        Hygiene.setResizable(false);
        Hygiene.setDefaultCloseOperation(Hygiene.EXIT_ON_CLOSE);
}

    @Override
    public void actionPerformed(ActionEvent e) {
            dispose();
            if(e.getSource() == appliances){
                OSPCateg2 c2 = new OSPCateg2();
                c2.setVisible(true);
            }
            else if(e.getSource() == furnitures){
                OSPCateg3 c3 = new OSPCateg3();
                c3.setVisible(true);
            }
            else if(e.getSource() == gadgets){
                OSPCategory c1 = new OSPCategory();
                c1.setVisible(true);
            }
            else if(e.getSource() == apparel){
                OSPCategory c1 = new OSPCategory();
                c1.setVisible(true);
            }
    }

   
}