
package onlineshoppingplatform;

import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author noctafly
 */
public class OSPCateg3 implements ActionListener{
    
    private JButton apparel, appliances, furnitures, gadgets, hygiene, bed, table, chair, lamp, cabinet, home;  
    private JLabel categ, name, name1, name2, name3, name4, price1, price2, price3, price4, product1, product2, product3, product4, icon;
    
    public OSPCateg3() {
    
    JFrame Furnitures = new JFrame("CATEGORY");
     
    Furnitures.setSize(600, 700);
        
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
        bed = new JButton("Bed");
        table = new JButton("Table");
        chair = new JButton("Chair");
        lamp = new JButton("Lamp");
        cabinet = new JButton("Cabinet");
        
        //displayed products on category tab
        product1 = new JLabel("/product img/");
        product2 = new JLabel("/product img/");
        product3 = new JLabel("/product img/");
        product4 = new JLabel("/product img/");
        
        //product names
        name1 = new JLabel("Floating Shelf");
        name2 = new JLabel("Wall Bracket");
        name3 = new JLabel("Bed Family Single");
        name4 = new JLabel("Laptop Table");
        
        //prices
        price1 = new JLabel("$7");
        price2 = new JLabel("$3");
        price3 = new JLabel("$76");
        price4 = new JLabel("$18");
        
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
        bed.setBounds(25, 160, 90, 23);
        table.setBounds(135, 160, 95, 23);
        chair.setBounds(250, 160, 90, 23);
        lamp.setBounds(360, 160, 90, 23);
        cabinet.setBounds(470, 160, 90, 23);
        
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
        
        Furnitures.add(categ);
        Furnitures.add(name);
        Furnitures.add(icon);
        Furnitures.add(home);
        Furnitures.add(apparel);
        Furnitures.add(appliances);
        Furnitures.add(furnitures);
        Furnitures.add(gadgets);
        Furnitures.add(hygiene);
        Furnitures.add(product1);
        Furnitures.add(product2);
        Furnitures.add(product3);
        Furnitures.add(product4);
        Furnitures.add(bed);
        Furnitures.add(table);
        Furnitures.add(chair);
        Furnitures.add(lamp);
        Furnitures.add(cabinet);
        Furnitures.add(name1);
        Furnitures.add(name2);
        Furnitures.add(name3);
        Furnitures.add(name4);
        Furnitures.add(price1);
        Furnitures.add(price2);
        Furnitures.add(price3);
        Furnitures.add(price4);
        
        bed.setFont(new Font("Arial", Font.PLAIN, 8));
        table.setFont(new Font("Arial", Font.PLAIN, 8));
        chair.setFont(new Font("Arial", Font.PLAIN, 8));
        lamp.setFont(new Font("Arial", Font.PLAIN, 8));
        cabinet.setFont(new Font("Arial", Font.PLAIN, 8));
        
        Furnitures.setLayout(null);            
        Furnitures.setVisible(true);
        Furnitures.setResizable(false);
        Furnitures.setDefaultCloseOperation(Furnitures.EXIT_ON_CLOSE);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
            if(e.getSource() == appliances){
                OSPCateg2 c2 = new OSPCateg2();
                c2.setVisible(true);
            }
            else if(e.getSource() == apparel){
                OSPCategory c1 = new OSPCategory();
                c1.setVisible(true);
            }
            else if(e.getSource() == gadgets){
                OSPCateg4 c4 = new OSPCateg4();
                c4.setVisible(true);
            }
            else if(e.getSource() == hygiene){
                OSPCateg5 c5 = new OSPCateg5();
                c5.setVisible(true);
            }
    }

}