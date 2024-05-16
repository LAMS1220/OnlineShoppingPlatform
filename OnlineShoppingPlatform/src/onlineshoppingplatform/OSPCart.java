package onlineshoppingplatform;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;



public class OSPCart implements ActionListener{
    
    private int counter = 0;
    private int counter2 = 0;
    private JButton btnAdd, btnSub, btnDel, btnAdd2, btnSub2, btnDel2, btnHome, btnPayment ;
    private JLabel lblQuantity, lblImage, lblQuantity2, lblImage2, lblCart, lblAmount;
  
    
    
    OSPCart(){
        JFrame OSP = new JFrame ("CART");

        //size of frame
        //font
        OSP.setSize(600,700);
        
        //components
        lblCart = new JLabel ("CART QUERY");
        lblCart.setFont(new Font ("Arial", Font.BOLD, 15));
        lblAmount = new JLabel ("AMOUNT: ");
        lblAmount.setFont(new Font ("Arial", Font.BOLD, 15));
        btnHome = new JButton("HOME");
        btnPayment = new JButton("CHECK OUT");
        
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
        OSP.add(btnPayment);
        OSP.add(btnHome);
        
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
        btnHome.setBounds(25, 80, 70, 25);
        lblCart.setBounds(25, 0, 100, 100);
        
        
        lblAmount.setBounds(400, 410, 100, 200);
        btnPayment.setBounds(400, 550,120, 25);
        
        btnAdd.setBounds(200, 290, 45, 25);
        btnSub.setBounds(325, 290, 45, 25);
        btnDel.setBounds(400, 290, 75, 25);
        lblQuantity.setBounds(255, 280, 200, 50);
        lblImage.setBounds(75, 240, 100, 100);
        
        //2nd
        btnAdd2.setBounds(200, 400, 45, 25);
        btnSub2.setBounds(325, 400, 45, 25);
        btnDel2.setBounds(400, 400, 75, 25);
        lblQuantity2.setBounds(255, 390, 200, 50);
        lblImage2.setBounds(75, 350, 100, 100);
        
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
        OSP.setResizable(false);
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
