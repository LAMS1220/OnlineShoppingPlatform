package onlineshoppingplatform;

import java.awt.event.*;
import javax.swing.*;


public class OSPCart implements ActionListener{
    
    private int counter = 0;
    private JButton btnAdd, btnSub, btnDel;
    private JLabel lblQuantity;
    
    
    OSPCart(){
        JFrame OSP = new JFrame ("CART");
        
        
        //size of frame
        OSP.setSize(500,700);
        
        
        //components
        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnDel = new JButton("Delete");
        lblQuantity = new JLabel("Quantity: 0");
        
        //add to frame
        OSP.add(btnAdd);
        OSP.add(btnSub);
        OSP.add(btnDel);
        OSP.add(lblQuantity);
        
        
        //location
        btnAdd.setBounds(175, 300, 45, 25);
        btnSub.setBounds(300, 300, 45, 25);
        btnDel.setBounds(400, 325, 75, 25);
        lblQuantity.setBounds(230, 290, 200, 50);
        
        
        //listener
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnDel.addActionListener(this);
        
        //layout
        OSP.setLayout(null);
        
        
        //visible
        OSP.setVisible(true);
        
        OSP.setDefaultCloseOperation(OSP.EXIT_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == btnAdd){
            counter ++;         
        }
        if (e.getSource() == btnSub){
            counter --;  
        }
        else if (e.getSource() == btnDel){
            counter = 0;
        }
        lblQuantity.setText("Quantity: "+counter);
    }
    
    
}
    
    
    

