package travel.management.system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BookHotel extends JFrame implements ActionListener {
    Choice c1, c2, c3;
    JTextField t1, t2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l15, l21, l22, l23, l24, l25;
    JButton b1, b2, b3;

    BookHotel(String username) {
        setSize(1050, 600);
        setLocationRelativeTo(null); // This centers the JFrame on the screen
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 90, 550, 350);
        add(l12);

        l1 = new JLabel("BOOK HOTELS");
        l1.setBounds(110, 10, 200, 30);
        l1.setFont(new Font("Yu Mincho", Font.BOLD, 22));
        add(l1);

        l2 = new JLabel("Username:");
        l2.setBounds(40, 70, 100, 30);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l2);

        l21 = new JLabel();
        l21.setBounds(250, 70, 200, 30);
        l21.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l21);

        l3 = new JLabel("Select Hotel:");
        l3.setBounds(40, 110, 150, 30);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l3);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                // --- CORRECTED HERE --- Fetches from the correct 'hotel' column
                c1.add(rs.getString("hotel"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(250, 110, 200, 30);
        c1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(c1);

        l4 = new JLabel("Total Persons:");
        l4.setBounds(40, 150, 150, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l4);

        t1 = new JTextField("1");
        t1.setBounds(250, 150, 200, 25);
        add(t1);

        l5 = new JLabel("Days:");
        l5.setBounds(40, 190, 100, 30);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l5);

        t2 = new JTextField("1");
        t2.setBounds(250, 190, 200, 25);
        add(t2);

        l6 = new JLabel("AC/Non-AC:");
        l6.setBounds(40, 230, 200, 30);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l6);

        c2 = new Choice();
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(250, 230, 200, 30);
        c2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(c2);

        l7 = new JLabel("Food Included:");
        l7.setBounds(40, 270, 200, 30);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l7);

        c3 = new Choice();
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(250, 270, 200, 30);
        c3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(c3);

        l8 = new JLabel("ID Type:");
        l8.setBounds(40, 310, 200, 30);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l8);

        l22 = new JLabel();
        l22.setBounds(250, 310, 200, 30);
        l22.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l22);

        l9 = new JLabel("ID Number:");
        l9.setBounds(40, 350, 200, 30);
        l9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l9);

        l23 = new JLabel();
        l23.setBounds(250, 350, 200, 30);
        l23.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l23);

        l10 = new JLabel("Phone Number:");
        l10.setBounds(40, 390, 200, 30);
        l10.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l10);

        l24 = new JLabel();
        l24.setBounds(250, 390, 200, 30);
        l24.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(l24);

        l11 = new JLabel("Total Price:");
        l11.setBounds(40, 430, 200, 30);
        l11.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(l11);

        l25 = new JLabel();
        l25.setBounds(250, 430, 150, 30);
        l25.setForeground(Color.RED);
        l25.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(l25);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                l21.setText(rs.getString("username"));
                l22.setText(rs.getString("id_type"));
                l23.setText(rs.getString("id_number"));
                l24.setText(rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("Check Price");
        b1.setBackground(new Color(135, 195, 235));
        b1.setForeground(Color.BLACK);
        b1.setBounds(60, 490, 130, 25);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Book Hotel");
        b2.setBackground(new Color(135, 195, 235));
        b2.setForeground(Color.BLACK);
        b2.setBounds(200, 490, 140, 25);
        b2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("BACK");
        b3.setBackground(new Color(135, 195, 235));
        b3.setForeground(Color.BLACK);
        b3.setBounds(350, 490, 110, 25);
        b3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        b3.addActionListener(this);
        add(b3);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                Conn c = new Conn();
                // --- CORRECTED HERE --- Fetches from 'hotel' and uses correct cost columns
                ResultSet rs = c.s.executeQuery("select * from hotel where hotel = '"+c1.getSelectedItem()+"'");

                if(rs.next()){
                    int cost = Integer.parseInt(rs.getString("cost_per_person"));
                    int ac_cost = Integer.parseInt(rs.getString("ac_room"));
                    int food_cost = Integer.parseInt(rs.getString("food_included"));

                    int persons = Integer.parseInt(t1.getText());
                    int days = Integer.parseInt(t2.getText());

                    String ac_selected = c2.getSelectedItem();
                    String food_selected = c3.getSelectedItem();

                    if(persons > 0 && days > 0) {
                        int total_cost = cost * persons * days;
                        if(ac_selected.equals("AC")){
                            total_cost += ac_cost * persons * days;
                        }
                        if(food_selected.equals("Yes")){
                            total_cost += food_cost * persons * days;
                        }
                        l25.setText("Rs " + total_cost);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number of persons and days");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            try {
                Conn c = new Conn();
                String price = l25.getText().replace("Rs ", "");
                String q1 = "insert into book_hotel values('" + l21.getText() + "','" + c1.getSelectedItem() + "','" + t1.getText() + "','" + t2.getText() + "','" + c2.getSelectedItem() + "','" + c3.getSelectedItem() + "','" + l22.getText() + "','" + l23.getText() + "','" + l24.getText() + "','" + price + "')";
                c.s.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully!");
                this.setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("testuser").setVisible(true);
    }
}