
package onlineshoppingplatform;

import java.awt.Font;
import javax.swing.*;


/**
 *
 * @author noctafly
 */
public class OSPCategory {
            
    private JButton apparel, appliances, furnitures, gadgets, hygiene, mapparel, wapparel, kapparel, acc, shoes, home;  
    private JLabel categ, name, name1, name2, name3, name4, price1, price2, price3, price4, product1, product2, product3, product4, icon;
    
    public OSPCategory() {
    
    JFrame Apparel = new JFrame("CATEGORY");
     
    Apparel.setSize(600, 700);
        
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
        mapparel = new JButton("Men's Apparel");
        wapparel = new JButton("Women's Apparel");
        kapparel = new JButton("Kids's Apparel");
        acc = new JButton("Accessories");
        shoes = new JButton("Shoes");
        
        //displayed products on category tab
        product1 = new JLabel("/product img/");
        product2 = new JLabel("/product img/");
        product3 = new JLabel("/product img/");
        product4 = new JLabel("/product img/");
        
        //product names
        name1 = new JLabel("UNIFIT Shirt");
        name2 = new JLabel("High Quality Tees");
        name3 = new JLabel("Dri-fit Shorts");
        name4 = new JLabel("Women Floral V-Neck");
        
        //prices
        price1 = new JLabel("$10.11");
        price2 = new JLabel("$9.41");
        price3 = new JLabel("$4.08");
        price4 = new JLabel("$30.41");
        
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
        mapparel.setBounds(25, 160, 90, 23);
        wapparel.setBounds(135, 160, 95, 23);
        kapparel.setBounds(250, 160, 90, 23);
        acc.setBounds(360, 160, 90, 23);
        shoes.setBounds(470, 160, 90, 23);
        
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
        
        Apparel.add(categ);
        Apparel.add(name);
        Apparel.add(icon);
        Apparel.add(home);
        Apparel.add(apparel);
        Apparel.add(appliances);
        Apparel.add(furnitures);
        Apparel.add(gadgets);
        Apparel.add(hygiene);
        Apparel.add(product1);
        Apparel.add(product2);
        Apparel.add(product3);
        Apparel.add(product4);
        Apparel.add(mapparel);
        Apparel.add(wapparel);
        Apparel.add(kapparel);
        Apparel.add(acc);
        Apparel.add(shoes);
        Apparel.add(name1);
        Apparel.add(name2);
        Apparel.add(name3);
        Apparel.add(name4);
        Apparel.add(price1);
        Apparel.add(price2);
        Apparel.add(price3);
        Apparel.add(price4);
        
        mapparel.setFont(new Font("Arial", Font.PLAIN, 8));
        wapparel.setFont(new Font("Arial", Font.PLAIN, 8));
        kapparel.setFont(new Font("Arial", Font.PLAIN, 8));
        acc.setFont(new Font("Arial", Font.PLAIN, 8));
        shoes.setFont(new Font("Arial", Font.PLAIN, 8));
        
        Apparel.setLayout(null);            
        Apparel.setVisible(true);
        Apparel.setResizable(false);
        Apparel.setDefaultCloseOperation(Apparel.EXIT_ON_CLOSE);
}
}
