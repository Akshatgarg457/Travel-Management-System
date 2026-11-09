package travel.management.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    String username;

    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximize frame to full screen
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Top panel (header)
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 1950, 65);
        p1.setBackground(new Color(0, 0, 100));
        p1.setLayout(null);
        add(p1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/dashboard3.jpg"));
        Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);

        JLabel l2 = new JLabel(i6);
        l2.setBounds(5, 0, 70, 70);
        p1.add(l2);

        JLabel l3 = new JLabel("DASHBOARD");
        l3.setFont(new Font("Tahoma", Font.BOLD, 30));
        l3.setForeground(Color.WHITE);
        l3.setBounds(80, 10, 300, 40);
        p1.add(l3);

        // Sidebar panel with buttons
        JPanel p2 = new JPanel();
        p2.setBounds(0, 65, 300, 1000);
        p2.setBackground(new Color(0, 0, 100));
        p2.setLayout(null);
        add(p2);

        b1 = createButton("Add Personal Details", 0, p2);
        b2 = createButton("View Personal Details", 50, p2);
        b3 = createButton("Check Package", 100, p2);
        b4 = createButton("Book Package", 150, p2);
        b5 = createButton("View Package", 200, p2);
        b6 = createButton("Book Hotels", 250, p2);
        b7 = createButton("View Booked Hotel", 300, p2);
        b8 = createButton("Payment", 350, p2);
        b9 = createButton("Calculator", 400, p2);
        b10 = createButton("NotePad", 450, p2);
        b11 = createButton("About", 500, p2);

        // Background image scaled to full screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, screenSize.width, screenSize.height);
        add(l1);

        // Title label on top of the background image
        JLabel l4 = new JLabel("TRAVEL & TOUR MANAGEMENT");
        l4.setBounds(screenSize.width / 3, 100, 1000, 70);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 60));
        l1.add(l4);
    }

    // Helper method to create buttons in sidebar
    private JButton createButton(String text, int y, JPanel parent) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(0, 0, 100));
        btn.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btn.setForeground(Color.WHITE);
        btn.setBounds(0, y, 300, 50);
        btn.addActionListener(this);
        parent.add(btn);
        return btn;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            new AddCustomer().setVisible(true);
        } else if (ae.getSource() == b2) {
            new ViewCustomer(username).setVisible(true);
        } else if (ae.getSource() == b3) {
            new CheckPackage().setVisible(true);
        } else if (ae.getSource() == b4) {
            new BookPackage(username).setVisible(true);
        } else if (ae.getSource() == b5) {
            new ViewPackage(username).setVisible(true);
        } else if (ae.getSource() == b6) {
            new BookHotel(username).setVisible(true);
        } else if (ae.getSource() == b7) {
            new ViewBookedHotel(username).setVisible(true);
        } else if (ae.getSource() == b11) {
            new About().setVisible(true);
        } else if (ae.getSource() == b8) {
            new Payment().setVisible(true);
        } else if (ae.getSource() == b9) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b10) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Dashboard("testuser").setVisible(true);
    }
}

