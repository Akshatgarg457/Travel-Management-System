package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Paytm extends JFrame
{   
    Paytm()
    {
        setTitle("Paytm Payment Gateway");
        setSize(800, 600);
        setLocationRelativeTo(null);  // Center the JFrame on screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try
        {
            j.setPage("https://paytm.com");
        }
        catch(Exception e)
        {
            System.out.println("Error loading page: " + e.getMessage());
            j.setContentType("text/html");
            j.setText("<html>Could not load the page.</html>");
        }

        JScrollPane js = new JScrollPane(j);
        getContentPane().add(js);
    }

    public static void main(String[] args)
    {
        new Paytm().setVisible(true);
    }
}
