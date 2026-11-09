package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField t2;

    Login() {
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/splash.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(
            Toolkit.getDefaultToolkit().getScreenSize().width,
            Toolkit.getDefaultToolkit().getScreenSize().height,
            Image.SCALE_SMOOTH
        );
        ImageIcon scaledBg = new ImageIcon(bgImg);

        JLabel background = new JLabel(scaledBg);
        setContentPane(background);
        background.setLayout(null);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        int panelWidth = 450;
        int panelHeight = 300;

        int panelX = (int) (screenWidth * 0.75) - panelWidth;
        int panelY = screenHeight / 2 - panelHeight / 2;

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setOpaque(false); 
        p2.setBounds(panelX, panelY, panelWidth, panelHeight);
        background.add(p2);

        JLabel l2 = new JLabel("User Name");
        l2.setBounds(50, 20, 150, 25);
        l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 21));
        l2.setForeground(Color.BLACK);
        p2.add(l2);

        t1 = new JTextField();
        t1.setBounds(50, 50, 300, 30);
        p2.add(t1);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(50, 100, 150, 25);
        l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 21));
        l3.setForeground(Color.BLACK);
        p2.add(l3);

        t2 = new JPasswordField();
        t2.setBounds(50, 130, 300, 30);
        p2.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(50, 180, 136, 30);
        b1.setBackground(new Color(135, 195, 235));
        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("Sign Up");
        b2.setBounds(210, 180, 136, 30);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        b2.setForeground(new Color(128, 188, 228));
        b2.addActionListener(this);
        p2.add(b2);

        b3 = new JButton("Forget Password?");
        b3.setBounds(90, 230, 180, 30);
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        p2.add(b3);

        JLabel l4 = new JLabel("Trouble in Login");
        l4.setBounds(280, 230, 180, 30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        p2.add(l4);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String username = t1.getText().trim();
            String password = new String(t2.getPassword()).trim();

            // Prevent login if fields are empty
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both Username and Password!");
                return;
            }

            try {
                String sql = "select * from account where username = '" + username + "' AND password = '" + password + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(sql);

                if (rs.next()) {
                    this.setVisible(false);
                    new Dashboard(username).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            new Signup().setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
