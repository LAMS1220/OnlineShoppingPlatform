package onlineshoppingplatform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shopping extends JFrame implements ActionListener {

    private JLabel lblshopping, lblcategory;
    private JButton btnhome, btncart;
    private JPanel panel, panel2;
    private JButton btnAppliance, btnApparel, btnFurniture, btnGadgets, btnHygiene;
    private JButton[][] selectButtons;
    private JButton confirmButton;
    private String[][] items;

    shopping() {
        setTitle("Shopping");
        setSize(800, 600);
        setLayout(null);

        lblshopping = new JLabel("ONLINE SHOPPING PLATFORM");
        lblshopping.setFont(new Font("Arial", Font.BOLD, 24));
        lblshopping.setBounds(20, 20, 500, 30);

        lblcategory = new JLabel("Category");
        lblcategory.setFont(new Font("Arial", Font.BOLD, 16));
        lblcategory.setBounds(20, 70, 100, 20);

        btnhome = new JButton("HOME");
        btnhome.setBounds(650, 20, 100, 30);
        btnhome.addActionListener(this);

        btncart = new JButton("CART");
        btncart.setBounds(650, 60, 100, 30);
        btncart.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(20, 100, 300, 450);
        panel.setBackground(Color.white);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(340, 100, 420, 450);
        panel2.setBackground(Color.white);

        // Category buttons
        btnAppliance = new JButton("Appliance");
        btnAppliance.setBounds(20, 20, 120, 30);
        btnAppliance.addActionListener(this);
        panel.add(btnAppliance);

        btnApparel = new JButton("Apparel");
        btnApparel.setBounds(20, 70, 120, 30);
        btnApparel.addActionListener(this);
        panel.add(btnApparel);

        btnFurniture = new JButton("Furniture");
        btnFurniture.setBounds(20, 120, 120, 30);
        btnFurniture.addActionListener(this);
        panel.add(btnFurniture);

        btnGadgets = new JButton("Gadgets");
        btnGadgets.setBounds(20, 170, 120, 30);
        btnGadgets.addActionListener(this);
        panel.add(btnGadgets);

        btnHygiene = new JButton("Hygiene");
        btnHygiene.setBounds(20, 220, 120, 30);
        btnHygiene.addActionListener(this);
        panel.add(btnHygiene);

        int numCategories = 5; 
        int itemsPerCategory = 3; 
        selectButtons = new JButton[numCategories][itemsPerCategory];

        String[] categories = {"Appliance", "Apparel", "Furniture", "Gadgets", "Hygiene"};
        String[][] items = {
                {"Item 1", "Item 2", "Item 3"},
                {"Item 4", "Item 5", "Item 6"},
                {"Item 7", "Item 8", "Item 9"},
                {"Item 10", "Item 11", "Item 12"},
                {"Item 13", "Item 14", "Item 15"}
        };

        // Adding select buttons for each category item
        for (int i = 0; i < categories.length; i++) {
            JLabel lblCat = new JLabel(categories[i]);
            lblCat.setBounds(160, 20 + i * 90, 100, 20);
            lblCat.setFont(new Font("Arial", Font.BOLD, 14));
            panel.add(lblCat);

            for (int j = 0; j < items[i].length; j++) {
                JLabel lblItem = new JLabel(items[i][j]);
                lblItem.setBounds(160, 50 + j * 30 + i * 90, 100, 20);
                lblItem.setFont(new Font("Arial", Font.PLAIN, 14));
                panel.add(lblItem);

                JButton btnSelect = new JButton("Select");
                btnSelect.setBounds(260, 50 + j * 30 + i * 90, 80, 20);
                btnSelect.addActionListener(this);
                selectButtons[i][j] = btnSelect;
                panel.add(btnSelect);
            }
        }

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(150, 20, 100, 30);
        confirmButton.addActionListener(this);
        panel2.add(confirmButton);

        add(lblshopping);
        add(lblcategory);
        add(btnhome);
        add(btncart);
        add(panel);
        add(panel2);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnhome) {
            dispose();
            shopping menu = new shopping();
            menu.setVisible(true);
        } else if (e.getSource() == btncart) {
            dispose();
            OSPCart cart = new OSPCart();
            cart.setVisible(true);
        } else if (e.getSource() == confirmButton) {
            OSPCart cart = new OSPCart();
            cart.setVisible(true);
            dispose();
        } else if (e.getSource() == btnAppliance) {
            dispose();
            OSPCateg2 categoryAppliance = new OSPCateg2();
            categoryAppliance.setVisible(true);
        } else if (e.getSource() == btnApparel) {
            dispose();
            OSPCategory categoryApparel = new OSPCategory();
            categoryApparel.setVisible(true);
        } else if (e.getSource() == btnFurniture) {
            dispose();
            OSPCateg3 categoryFurniture = new OSPCateg3();
            categoryFurniture.setVisible(true);
        } else if (e.getSource() == btnGadgets) {
            dispose();
            OSPCateg4 categoryGadgets = new OSPCateg4();
            categoryGadgets.setVisible(true);
        } else if (e.getSource() == btnHygiene) {
            dispose();
            OSPCateg5 categoryHygiene = new OSPCateg5();
            categoryHygiene.setVisible(true);
        } else {
            for (int i = 0; i < selectButtons.length; i++) {
                for (int j = 0; j < selectButtons[i].length; j++) {
                    if (e.getSource() == selectButtons[i][j]) {
                        System.out.println("Selected item: " + items[i][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new shopping();
    }
}
