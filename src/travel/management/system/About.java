package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {
    String s;
    JButton b1;

    About() {
        setSize(600, 650);
        setLocationRelativeTo(null);
        setLayout(null);
        // --- CHANGED HERE ---
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Travel Management System");
        l1.setBounds(80, 20, 500, 80);
        // --- CHANGED HERE ---
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Yu Mincho", Font.BOLD, 28));
        add(l1);

        s = "This project is developed by Akshat, a student of CDGI (Chameli Devi Group of Institutions).\n\n"
          + "The Travel and Tourism Management System is designed to streamline the operations of travel agencies. "
          + "It provides a user-friendly interface for booking tours, managing destinations, and planning accommodations.\n\n"
          + "Key Features:\n"
          + "- Efficient travel package management.\n"
          + "- Easy booking and cancellation processes.\n"
          + "- Secure and responsive user interface.\n"
          + "- Comprehensive database of destinations and hotels.\n"
          + "- Automation of administrative tasks to save time.\n\n"
          + "The system enhances the experience for both travelers and travel agencies by offering fast access to "
          + "relevant information and eliminating manual errors in the process.";

        JTextArea t1 = new JTextArea(s);
        // --- CHANGED HERE ---
        t1.setBackground(Color.BLUE);
        t1.setForeground(Color.WHITE);
        t1.setEditable(false);
        t1.setLineWrap(true);
        t1.setWrapStyleWord(true);
        t1.setFont(new Font("Yu Mincho", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(t1);
        scrollPane.setBounds(30, 120, 530, 360);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);

        b1 = new JButton("BACK");
        b1.setBackground(new Color(135, 195, 235)); // Light blue button stands out
        b1.setForeground(Color.BLACK);
        b1.setBounds(225, 500, 150, 35);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        b1.addActionListener(this);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        new About().setVisible(true);
    }
}