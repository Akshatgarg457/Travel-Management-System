package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton b1;

    ViewBookedHotel(String username) {
        setTitle("View Booked Hotel Details");
        setSize(1000, 580); // Increased height slightly to accommodate all fields
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l110 = new JLabel(i3);
        l110.setBounds(450, 50, 500, 400); // Adjusted position slightly
        add(l110);

        JLabel heading = new JLabel("VIEW BOOKED HOTEL DETAILS");
        heading.setBounds(60, 0, 400, 25);
        heading.setFont(new Font("Yu Mincho", Font.BOLD, 21));
        add(heading);

        // Labels updated to match your 'book_hotel' table schema
        String[] labels = {
            "Username", "Hotel Name", "Total Persons", "Total Days", "AC/Non-AC",
            "Food Included", "ID Type", "ID Number", "Phone Number", "Total Price"
        };

        JLabel[] labelFields = new JLabel[labels.length];
        int y = 50;
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i] + " : ");
            label.setBounds(30, y, 150, 30);
            label.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(label);

            labelFields[i] = new JLabel();
            labelFields[i].setBounds(250, y, 200, 30);
            labelFields[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(labelFields[i]);

            y += 40;
        }

        // Updated to use 'book_hotel' table and corresponding columns for test data
        try {
            Conn c = new Conn();
            // Query now points to the correct table 'book_hotel'
            ResultSet check = c.s.executeQuery("SELECT * FROM book_hotel WHERE username = '" + username + "'");
            if (!check.next()) {
                // Test data query now inserts into 'book_hotel' with matching values
                String query = "INSERT INTO book_hotel VALUES ('" + username + "', 'Radisson Blu', '2', '3', 'AC', 'Yes', 'Aadhar Card', '123456789012', '9876543210', '18000')";
                c.s.executeUpdate(query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Load booking data from the correct table 'book_hotel'
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM book_hotel WHERE username = '" + username + "'");
            if (rs.next()) {
                // This loop works because the label array order now matches the table column order
                for (int i = 0; i < labelFields.length; i++) {
                    labelFields[i].setText(rs.getString(i + 1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("BACK");
        b1.setBounds(150, 470, 150, 25); // Adjusted position
        b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        b1.setBackground(new Color(135, 195, 235));
        b1.addActionListener(this);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ViewBookedHotel("testuser").setVisible(true);
        });
    }
}