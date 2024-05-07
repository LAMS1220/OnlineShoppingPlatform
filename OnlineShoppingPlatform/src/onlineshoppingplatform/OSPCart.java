package onlineshoppingplatform;

import java.awt.event.*;
import javax.swing.*;



public class OSPCart implements ActionListener{
    
    private int counter = 0;
    private int counter2 = 0;
    private JButton btnAdd, btnSub, btnDel, btnAdd2, btnSub2, btnDel2 ;
    private JLabel lblQuantity, lblImage, lblQuantity2, lblImage2, lblCart, lblAmount;
    
    
    OSPCart(){
        JFrame OSP = new JFrame ("CART");
        
        
        //size of frame
        OSP.setSize(500,500);
        
        
        //components
        lblCart = new JLabel ("CART QUERY");
        lblAmount = new JLabel ("AMOUNT: ");
        
        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnDel = new JButton("Delete");
        lblQuantity = new JLabel("Quantity: 0");
        lblImage = new JLabel("image placeholder");
        
        //2nd
        btnAdd2 = new JButton("+");
        btnSub2 = new JButton("-");
        btnDel2 = new JButton("Delete");
        lblQuantity2 = new JLabel("Quantity: 0");
        lblImage2 = new JLabel("image placeholder");
        
        //add to frame
        OSP.add(lblCart);
        OSP.add(lblAmount);
        
        OSP.add(btnAdd);
        OSP.add(btnSub);
        OSP.add(btnDel);
        OSP.add(lblQuantity);
        OSP.add(lblImage);
        
        //2nd
        OSP.add(btnAdd2);
        OSP.add(btnSub2);
        OSP.add(btnDel2);
        OSP.add(lblQuantity2);
        OSP.add(lblImage2);
        
        //location
        lblCart.setBounds(50, 75, 100, 100);
        lblAmount.setBounds(350, 300, 100, 200);
        
        btnAdd.setBounds(175, 200, 45, 25);
        btnSub.setBounds(300, 200, 45, 25);
        btnDel.setBounds(390, 225, 75, 25);
        lblQuantity.setBounds(230, 190, 200, 50);
        lblImage.setBounds(50, 150, 100, 100);
        
        //2nd
        btnAdd2.setBounds(175, 300, 45, 25);
        btnSub2.setBounds(300, 300, 45, 25);
        btnDel2.setBounds(390, 325, 75, 25);
        lblQuantity2.setBounds(230, 290, 200, 50);
        lblImage2.setBounds(50, 250, 100, 100);
        
        //listener
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnDel.addActionListener(this);
        
        //2nd
        btnAdd2.addActionListener(this);
        btnSub2.addActionListener(this);
        btnDel2.addActionListener(this);
        
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
        if (e.getSource() == btnAdd2){
            counter2 ++;
        }
        if (e.getSource() == btnSub){
            counter --;  
        }
        if (e.getSource() == btnSub2){
            counter2 --;  
        }
        else if (e.getSource() == btnDel){
            counter = 0;
        }
        else if (e.getSource() == btnDel2){
            counter2 = 0;
        }
        lblQuantity.setText("Quantity: "+counter);
        
        lblQuantity2.setText("Quantity: "+counter2);
        
        lblAmount.setText("AMOUNT: $"+counter+counter2);
    }

}
