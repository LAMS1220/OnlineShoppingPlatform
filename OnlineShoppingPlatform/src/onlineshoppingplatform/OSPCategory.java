
package onlineshoppingplatform;

import java.awt.Font;
import javax.swing.*;


/**
 *
 * @author noctafly
 */
public class OSPCategory {
    public OSPCategory() {
    
    JFrame Category = new JFrame("CATEGORY");    
    JButton apparel, appliances, furnitures, gadgets, hygiene, mapparel, wapparel, kapparel, acc, shoes, home;  
    JLabel categ, name, name1, name2, name3, name4, price1, price2, price3, price4, product1, product2, product3, product4, icon;
    
    Category.setSize(600, 700);
        
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
        price1 = new JLabel("$10");
        price2 = new JLabel("$9");
        price3 = new JLabel("$4");
        price4 = new JLabel("$30");
        
        //header ooordinates
        
        categ.setBounds(25, 40, 100, 50);
        name.setBounds(120, 60, 40, 40);
        icon.setBounds(40, 60, 40, 40);
        home.setBounds(20, 25, 70, 25);
        
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
        
        Category.add(categ);
        Category.add(name);
        Category.add(icon);
        Category.add(home);
        Category.add(apparel);
        Category.add(appliances);
        Category.add(furnitures);
        Category.add(gadgets);
        Category.add(hygiene);
        Category.add(product1);
        Category.add(product2);
        Category.add(product3);
        Category.add(product4);
        Category.add(mapparel);
        Category.add(wapparel);
        Category.add(kapparel);
        Category.add(acc);
        Category.add(shoes);
        Category.add(name1);
        Category.add(name2);
        Category.add(name3);
        Category.add(name4);
        Category.add(price1);
        Category.add(price2);
        Category.add(price3);
        Category.add(price4);
        
        mapparel.setFont(new Font("Arial", Font.PLAIN, 8));
        wapparel.setFont(new Font("Arial", Font.PLAIN, 8));
        kapparel.setFont(new Font("Arial", Font.PLAIN, 8));
        acc.setFont(new Font("Arial", Font.PLAIN, 8));
        shoes.setFont(new Font("Arial", Font.PLAIN, 8));
        
        Category.setLayout(null);            
        Category.setVisible(true);
        Category.setDefaultCloseOperation(Category.EXIT_ON_CLOSE);
}
}
