
package onlineshoppingplatform;
import java.awt.Font;
import javax.swing.*;

public class OSPProduct extends JFrame{
    
    private JButton btnHome, btnCart, btnAdd;
    private JLabel lblProduct, lblImage, lblDescription, lblVariation, lblAmount;
    private JComboBox cmbVariation;
    
    OSPProduct() {
        setTitle("Product");
        setSize(500,500);
        
        btnHome = new JButton ("Home");
        btnCart = new JButton ("Cart");
        btnAdd = new JButton ("Add");
        lblProduct = new JLabel ("Product ");
        lblImage = new JLabel ("Image Placeholder");
        lblDescription = new JLabel ("Description ");
        lblVariation = new JLabel ("Variations: ");
        lblAmount = new JLabel ("1,0000,0000,00,0,000");
       
        
        
        JPanel panel = new JPanel();
        String[] Items = {"one","two","three"};
        JComboBox cmbVariation = new JComboBox (Items);
        panel.add (cmbVariation);
        
        add(panel);
        add(btnHome);
        add(btnCart);
        add(btnAdd);
        add(lblProduct);
        add(lblImage);
        add(lblDescription);
        add(lblVariation);
        add(lblAmount);
        add(cmbVariation);
        
        btnHome.setBounds(10, 30, 70, 25);
        btnCart.setBounds(400, 30, 60, 25);
        btnAdd.setBounds(350, 290, 70, 30);
        lblProduct.setBounds(80, 250, 200, 50);
        lblProduct.setFont(new Font("Bell MT", Font.BOLD, 30));
        lblImage.setBounds(80, 150, 200, 90);
        lblDescription.setBounds(80, 280, 200, 50);
        lblDescription.setFont(new Font("Bell MT", Font.BOLD, 20));
        lblVariation.setBounds(350, 110, 80, 50);
        lblAmount.setBounds(80, 310, 90, 50);
        lblAmount.setFont(new Font("Bell MT", Font.BOLD, 15));
        cmbVariation.setBounds(350, 150, 75, 25);
        setLayout(null);
        
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
    }
    
}
