
package onlineshoppingplatform;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OSPPayment extends JFrame implements ActionListener{
    private JLabel lblname, lbladd, lblcontact, lblcustomer, lblmop, lblamount;
    private JButton btnpurchase, btnhome, btncart;
    private JTextField txtname, txtadd, txtcontact, txtamount;
    private JComboBox<String> cmbmop;
    
    OSPPayment() {
        setTitle("Payment");

        setSize(600, 700);

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
        btnhome.addActionListener(this);
        
        
        btncart = new JButton("CART");
        btncart.setBounds(100, 50, 70, 30);
        btncart.addActionListener(this);

        JPanel panel = new JPanel();
        String[] mode = {"Cash on Delivery", "Debit Card", "Credit Card", "GCash", "Paymaya", "Paypal"};
        cmbmop = new JComboBox<>(mode);
        cmbmop.setBounds(250, 300, 150, 20);
        panel.add(cmbmop);

        add(panel);
        add(lblname);
        add(lbladd);
        add(lblcontact);
        add(lblcustomer);
        add(lblamount);
        add(lblmop);
        add(btnpurchase);
        add(btnhome);
        add(btncart);
        add(txtname);
        add(txtadd);
        add(txtcontact);
        add(txtamount);
        add(cmbmop);

        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        
        dispose();
        if(e.getSource() == btnhome){
            shopping menu = new shopping();
            menu.setVisible(true);
            
        }else if (e.getSource() == btncart) {
            OSPCart cart = new OSPCart();
            cart.setVisible(true);
        }
        
}
    public static void main (String[]args){
        new OSPPayment();
    }
}
