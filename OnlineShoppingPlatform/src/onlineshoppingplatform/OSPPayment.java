
package onlineshoppingplatform;
import javax.swing.*;
import java.awt.*;

public class OSPPayment {
    private JLabel lblname, lbladd, lblcontact, lblcustomer, lblmop, lblamount;
    private JButton btnpurchase, btnhome, btncart;
    private JTextField txtname, txtadd, txtcontact, txtamount;
    private JComboBox<String> cmbmop;
    
    OSPPayment() {
        JFrame OSP = new JFrame("PAYMENT");

        OSP.setSize(600, 700);

        lblcustomer = new JLabel("Customer's Information");
        lblcustomer.setBounds(20, 20, 220, 20);
        lblcustomer.setFont(new Font("Arial", Font.BOLD, 16));

        lblname = new JLabel("Name");
        lblname.setBounds(100, 160, 100, 20);
        lblname.setFont(new Font("Arial", Font.BOLD, 15));
       
        lbladd = new JLabel("Address");
        lbladd.setBounds(100, 190, 100, 20);
        lbladd.setFont(new Font("Arial", Font.BOLD, 15));

        lblcontact = new JLabel("Contact No");
        lblcontact.setBounds(100, 220, 100, 20);
        lblcontact.setFont(new Font("Arial", Font.BOLD, 15));
        
        lblamount = new JLabel("Amount");
        lblamount.setBounds(100, 250, 100, 20);
        lblamount.setFont(new Font("Arial", Font.BOLD, 15));

        lblmop = new JLabel("Mode of Payment");
        lblmop.setBounds(100, 300, 210, 20);
        lblmop.setFont(new Font("Arial", Font.BOLD, 15));

        txtname = new JTextField();
        txtname.setBounds(200, 160, 200, 20);
        txtname.setFont(new Font("Arial", Font.PLAIN, 15));

        txtadd = new JTextField();
        txtadd.setBounds(200, 190, 200, 20);
        txtadd.setFont(new Font("Arial", Font.PLAIN, 15));

        txtcontact = new JTextField();
        txtcontact.setBounds(200, 220, 200, 20);
        txtcontact.setFont(new Font("Arial", Font.PLAIN, 15));
        
        txtamount = new JTextField();
        txtamount.setBounds(200, 250, 200, 20);
        txtamount.setFont(new Font("Arial", Font.PLAIN, 15));

        btnpurchase = new JButton("Purchase");
        btnpurchase.setBounds(350, 450, 100, 30);
        
        btnhome = new JButton("HOME");
        btnhome.setBounds(20, 50, 70, 30);
        
        btncart = new JButton("CART");
        btncart.setBounds(100, 50, 70, 30);

        JPanel panel = new JPanel();
        String[] mode = {"Cash on Delivery", "Debit Card", "Credit Card", "GCash", "Paymaya", "Paypal"};
        cmbmop = new JComboBox<>(mode);
        cmbmop.setBounds(250, 300, 150, 20);
        panel.add(cmbmop);

        OSP.add(panel);
        OSP.add(lblname);
        OSP.add(lbladd);
        OSP.add(lblcontact);
        OSP.add(lblcustomer);
        OSP.add(lblamount);
        OSP.add(lblmop);
        OSP.add(btnpurchase);
        OSP.add(btnhome);
        OSP.add(btncart);
        OSP.add(txtname);
        OSP.add(txtadd);
        OSP.add(txtcontact);
        OSP.add(txtamount);
        OSP.add(cmbmop);

        OSP.setLayout(null);
        OSP.setVisible(true);
        OSP.setResizable(false);
        OSP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
}
