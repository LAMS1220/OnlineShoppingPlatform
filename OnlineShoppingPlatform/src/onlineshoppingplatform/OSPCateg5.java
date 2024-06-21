
package onlineshoppingplatform;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author noctafly
 */
public class OSPCateg5 extends JFrame implements ActionListener{
    private JButton apparel, appliances, furnitures, gadgets, hygiene, home, cart1, cart2, cart3, cart4, cart;  
    private JLabel categ, name, name1, name2, name3, name4, price1, price2, price3, price4, product1, product2, product3, product4, mouthwash, wipes, adorn, shaver ;
    
    OSPCateg5() {
    
    JFrame Hygiene = new JFrame("HYGIENE CATEGORY");
     
    Hygiene.setSize(600, 700);
        
        //header
        categ = new JLabel("CATEGORIES");
        name = new JLabel("OSP");
        home = new JButton("HOME");
        
        //cart button
        cart = new JButton("CART");
        
        //main categories
        apparel = new JButton("Apparel");
        appliances = new JButton("Appliances");
        furnitures = new JButton("Furnitures");
        gadgets = new JButton("Gadgets");
        hygiene = new JButton("Hygiene");
        
        //1st gadget image
        mouthwash = new JLabel();
        mouthwash.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\noctafly\\Desktop\\New Folder (2)\\New Folder\\New Folder\\kaks\\asand\\pogiako\\New Folder\\New Folder\\New Folder\\OnlineShoppingPlatform\\OnlineShoppingPlatform\\src\\onlineshoppingplatform\\listerine.png").getImage().getScaledInstance(90, 150, Image.SCALE_SMOOTH)));
              
        //2nd gadget image
        wipes = new JLabel();
        wipes.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\noctafly\\Desktop\\New Folder (2)\\New Folder\\New Folder\\kaks\\asand\\pogiako\\New Folder\\New Folder\\New Folder\\OnlineShoppingPlatform\\OnlineShoppingPlatform\\src\\onlineshoppingplatform\\wipes.png").getImage().getScaledInstance(110, 100, Image.SCALE_SMOOTH)));
        
        //3rd gadget image
        adorn = new JLabel();
        adorn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\noctafly\\Desktop\\New Folder (2)\\New Folder\\New Folder\\kaks\\asand\\pogiako\\New Folder\\New Folder\\New Folder\\OnlineShoppingPlatform\\OnlineShoppingPlatform\\src\\onlineshoppingplatform\\adorn.png").getImage().getScaledInstance(110, 130, Image.SCALE_SMOOTH)));
  
        //4th gadget image
        shaver = new JLabel();
        shaver.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\noctafly\\Desktop\\New Folder (2)\\New Folder\\New Folder\\kaks\\asand\\pogiako\\New Folder\\New Folder\\New Folder\\OnlineShoppingPlatform\\OnlineShoppingPlatform\\src\\onlineshoppingplatform\\shaver.png").getImage().getScaledInstance(120, 135, Image.SCALE_SMOOTH)));
        
        
        //displayed products on category tab
        product1 = new JLabel();
        product2 = new JLabel();
        product3 = new JLabel();
        product4 = new JLabel();
        
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
        
        //add to cart buttons
        cart1 = new JButton("Add to Cart");
        cart2 = new JButton("Add to Cart");
        cart3 = new JButton("Add to Cart");
        cart4 = new JButton("Add to Cart");
        
        //header ooordinates       
        categ.setBounds(25, 0, 100, 50);
        name.setBounds(120, 25, 40, 40);
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
        
        //images coordinates
        mouthwash.setBounds(30, 200, 150, 150);
        wipes.setBounds(160, 200, 150, 150);
        adorn.setBounds(300, 200, 150, 150);
        shaver.setBounds(445, 200, 150, 150);
        
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
        
         //add to cart coordinates
        cart1.setBounds(20, 390, 100, 25);
        cart2.setBounds(160, 390, 100, 25);
        cart3.setBounds(300, 390, 100, 25);
        cart4.setBounds(440, 390, 100, 25);
        
        //cart button coordinates
        cart.setBounds(490, 450, 70, 25);
        
         //Action Listener
        appliances.addActionListener(this);
        furnitures.addActionListener(this);
        apparel.addActionListener(this);
        apparel.addActionListener(this);
        gadgets.addActionListener(this);
        home.addActionListener(this);
        cart.addActionListener(this);
        
        Hygiene.add(categ);
        Hygiene.add(name);
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
        Hygiene.add(name1);
        Hygiene.add(name2);
        Hygiene.add(name3);
        Hygiene.add(name4);
        Hygiene.add(price1);
        Hygiene.add(price2);
        Hygiene.add(price3);
        Hygiene.add(price4);
        Hygiene.add(mouthwash);
        Hygiene.add(wipes);
        Hygiene.add(adorn);
        Hygiene.add(shaver);
        Hygiene.add(cart);
        Hygiene.add(cart1);
        Hygiene.add(cart2);
        Hygiene.add(cart3);
        Hygiene.add(cart4);
        
        Hygiene.setLayout(null);            
        Hygiene.setVisible(true);
        Hygiene.setResizable(false);
        Hygiene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            else if(e.getSource() == cart){
               OSPCart cart = new OSPCart();
               cart.setVisible(true);

   
    }
    }
}