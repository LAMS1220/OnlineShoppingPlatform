
package onlineshoppingplatform;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class OSPMenu {

 
        
        OSPMenu(){
        JFrame OSP = new JFrame("ONLINE SHOPPING SIMULATOR");
    
        OSP.setSize(500, 700);
                  
        //Buttons
        JButton Search = new JButton("Search");
        JButton Cart = new JButton("Cart");
        JButton Categories = new JButton("Categories");
        JButton Order = new JButton("Order Tracking");
        
        JLabel Online = new JLabel("WELCOME TO ONLINE SHOPPING SIMULATOR!!");
        
        //Locator
        Search.setBounds(150, 200, 150, 30);
        Cart.setBounds(150, 250, 150, 30);
        Categories.setBounds(150, 300, 150, 30);
        Order.setBounds(150, 350, 150, 30);
        Online.setBounds(100, 5, 400, 350);
        
        OSP.add(Search);
        OSP.add(Cart);
        OSP.add(Categories);
        OSP.add(Order);
        OSP.add(Online);
    
        OSP.setLayout(null);            
        OSP.setVisible(true);
        OSP.setDefaultCloseOperation(OSP.EXIT_ON_CLOSE);
    }
    
    
}
