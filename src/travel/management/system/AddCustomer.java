package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6, t7;
    JComboBox<String> c1;
    JRadioButton r1, r2;
    JButton b1, b2;

    AddCustomer() {
        setSize(850, 580);
        setLocationRelativeTo(null); // ✅ Centers the frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(30, 20, 150, 25);
        l1.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(220, 20, 150, 25);
        add(t1);

        JLabel l2 = new JLabel("ID : ");
        l2.setBounds(30, 70, 150, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l2);

        c1 = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Pan Card", "Voter ID"});
        c1.setBounds(220, 70, 150, 25);
        add(c1);

        JLabel l3 = new JLabel("ID Number : ");
        l3.setBounds(30, 120, 150, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(220, 120, 150, 25);
        add(t2);

        JLabel l4 = new JLabel("Name : ");
        l4.setBounds(30, 170, 150, 25);
        l4.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l4);

        t3 = new JTextField();
        t3.setBounds(220, 170, 150, 25);
        add(t3);

        JLabel l5 = new JLabel("Gender : ");
        l5.setBounds(30, 220, 150, 25);
        l5.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setBounds(220, 220, 70, 25);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(300, 220, 150, 25);
        r2.setBackground(Color.WHITE);
        add(r2);

        ButtonGroup bg = new ButtonGroup(); // ✅ Group the radio buttons
        bg.add(r1);
        bg.add(r2);

        JLabel l6 = new JLabel("Country : ");
        l6.setBounds(30, 270, 150, 25);
        l6.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l6);

        t4 = new JTextField();
        t4.setBounds(220, 270, 150, 25);
        add(t4);

        JLabel l7 = new JLabel("Address : ");
        l7.setBounds(30, 320, 150, 25);
        l7.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l7);

        t5 = new JTextField();
        t5.setBounds(220, 320, 150, 25);
        add(t5);

        JLabel l8 = new JLabel("Phone : ");
        l8.setBounds(30, 370, 150, 25);
        l8.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l8);

        t6 = new JTextField();
        t6.setBounds(220, 370, 150, 25);
        add(t6);

        JLabel l9 = new JLabel("Email : ");
        l9.setBounds(30, 420, 150, 25);
        l9.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l9);

        t7 = new JTextField();
        t7.setBounds(220, 420, 150, 25);
        add(t7);

        b1 = new JButton("ADD");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(70, 470, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(220, 470, 100, 30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 550, Image.SCALE_DEFAULT);
        JLabel l10 = new JLabel(new ImageIcon(i2));
        l10.setBounds(420, 50, 400, 400);
        add(l10);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = t1.getText();
            String id = (String) c1.getSelectedItem();
            String number = t2.getText();
            String name = t3.getText(); // ✅ Corrected: used t3 for name
            String gender = null;

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }

            String country = t4.getText();
            String address = t5.getText();
            String phone = t6.getText();
            String email = t7.getText();

            String q = "insert into customer values('" + username + "','" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + address + "','" + phone + "','" + email + "')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Customer Details Added!");
                this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }
}
