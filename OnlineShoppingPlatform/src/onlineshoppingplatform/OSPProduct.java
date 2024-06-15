 
package onlineshoppingplatform;
import java.awt.Font;
import javax.swing.*;

public class OSPProduct extends JFrame{
    
    private JButton btnHome, btnCart, btnAdd;
    private JLabel lblProduct, lblImage, lblDescription, lblVariation, lblAmount,lblName;
    private JComboBox cmbVariation;
    
    OSPProduct() {
        
        setTitle("Product");
        setSize(600,700);
        
        lblName = new JLabel ("PRODUCT VIEW");
        btnHome = new JButton ("HOME");
        btnCart = new JButton ("CART");
        btnAdd = new JButton ("ADD");
        lblProduct = new JLabel ("Product ");
        lblImage = new JLabel ("Image Placeholder");
        lblDescription = new JLabel ("Description ");
        lblVariation = new JLabel ("Variations: ");
        lblAmount = new JLabel ("Amount");
       
        JPanel panel = new JPanel();
        String[] Items = {"one","two","three"};
        JComboBox cmbVariation = new JComboBox (Items);
        panel.add (cmbVariation);
        
        add(panel);
        add(lblName);
        add(btnHome);
        add(btnCart);
        add(btnAdd);
        add(lblProduct);
        add(lblImage);
        add(lblDescription);
        add(lblVariation);
        add(lblAmount);
        add(cmbVariation);
        
        btnHome.setBounds(15, 60, 70, 25);
        btnCart.setBounds(475,60, 80, 25);
        btnAdd.setBounds(475, 500, 70, 30);
        
        lblName.setBounds(10, 20, 120, 30);
        lblName.setFont(new Font("Arial", Font.BOLD, 15));
        
        lblProduct.setBounds(80, 340, 200, 50);
        lblProduct.setFont(new Font("Arial", Font.BOLD, 30));
        
        lblImage.setBounds(80, 200, 200, 90);
        lblImage.setFont(new Font("Arial", Font.BOLD, 20));
        
        lblDescription.setBounds(80, 375, 200, 50);
        lblDescription.setFont(new Font("Arial", Font.BOLD, 20));
        
        lblVariation.setBounds(475, 130, 80, 50);
        
        lblAmount.setBounds(80,400, 90, 50);
        lblAmount.setFont(new Font("Arial", Font.BOLD, 15));
        
        cmbVariation.setBounds(475, 165, 75, 25);
        
        setLayout(null);
        
        setVisible(true);
        setResizable(false);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
    }
    
}
