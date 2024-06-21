package onlineshoppingplatform;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OSPCategory extends JFrame {
    private DBManager dbManager;

    public OSPCategory() {
        dbManager = new DBManager();
        setTitle("Category: Appliances");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Example items, replace with actual data from the database
        String[][] items = {
            {"Fridge", "Cooling appliance", "500"},
            {"Microwave", "Heating appliance", "200"},
            {"Washing Machine", "Laundry appliance", "700"}
        };

        for (String[] item : items) {
            String name = item[0];
            String description = item[1];
            String price = item[2];
            JButton itemButton = new JButton("Select " + name);
            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        dbManager.addItemToCart(name, description, Double.parseDouble(price));
                        JOptionPane.showMessageDialog(null, name + " added to cart.");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            JLabel itemLabel = new JLabel("<html>Name: " + name + "<br>Description: " + description + "<br>Price: $" + price + "</html>");
            panel.add(itemLabel);
            panel.add(itemButton);
        }

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OSPCategory());
    }
}
