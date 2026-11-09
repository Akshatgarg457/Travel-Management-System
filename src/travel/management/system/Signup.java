package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField t1, t2, t3, t4;
    JComboBox<String> c1;

    Signup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Full screen setup
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setLocationRelativeTo(null);
        setLayout(null);

        // Background image
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/splash.jpg"));
        Image bgImage = bgIcon.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, screenSize.width, screenSize.height);
        setContentPane(background);
        background.setLayout(null);

        // Heading
        JLabel heading = new JLabel("Sign Up");
        heading.setBounds(screenSize.width - 650, 60, 300, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 36));
        heading.setForeground(Color.WHITE);
        background.add(heading);

        // Layout values
        int formX = screenSize.width - 700;
        int formY = 130;
        int labelWidth = 150;
        int fieldWidth = 200;
        int height = 30;
        int gap = 50;

        // Username
        JLabel l1 = new JLabel("UserName");
        l1.setBounds(formX, formY, labelWidth, height);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setForeground(Color.WHITE);
        background.add(l1);

        t1 = new JTextField();
        t1.setBounds(formX + labelWidth, formY, fieldWidth, height);
        background.add(t1);

        // Name
        JLabel l2 = new JLabel("Name");
        l2.setBounds(formX, formY + gap, labelWidth, height);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setForeground(Color.WHITE);
        background.add(l2);

        t2 = new JTextField();
        t2.setBounds(formX + labelWidth, formY + gap, fieldWidth, height);
        background.add(t2);

        // Password
        JLabel l3 = new JLabel("Password");
        l3.setBounds(formX, formY + 2 * gap, labelWidth, height);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setForeground(Color.WHITE);
        background.add(l3);

        t3 = new JTextField();
        t3.setBounds(formX + labelWidth, formY + 2 * gap, fieldWidth, height);
        background.add(t3);

        // Security Question
        JLabel l4 = new JLabel("Security Question");
        l4.setBounds(formX, formY + 3 * gap, labelWidth, height);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setForeground(Color.WHITE);
        background.add(l4);

        String[] questions = {
            "Fav Anime character",
            "Fav Marvel Superhero",
            "Your Lucky Number",
            "Your Nickname"
        };
        c1 = new JComboBox<>(questions);
        c1.setBounds(formX + labelWidth, formY + 3 * gap, fieldWidth, height);
        background.add(c1);

        // Answer
        JLabel l5 = new JLabel("Answer");
        l5.setBounds(formX, formY + 4 * gap, labelWidth, height);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setForeground(Color.WHITE);
        background.add(l5);

        t4 = new JTextField();
        t4.setBounds(formX + labelWidth, formY + 4 * gap, fieldWidth, height);
        background.add(t4);

        // Buttons
        b1 = new JButton("Create");
        b1.setBounds(formX + 20, formY + 5 * gap, 100, 30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(this);
        background.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(formX + 150, formY + 5 * gap, 100, 30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.addActionListener(this);
        background.add(b2);

        // No signup image anymore
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = (String) c1.getSelectedItem();
            String answer = t4.getText();

            String query = "INSERT INTO account VALUES('" + username + "','" + name + "','" + password + "','" + security + "','" + answer + "');";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account created successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error creating account.");
            }

        } else if (ae.getSource() == b2) {
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
