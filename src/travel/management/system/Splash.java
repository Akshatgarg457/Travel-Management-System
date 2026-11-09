package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash {
    public static void main(String[] args) {
        SplashFrame frame = new SplashFrame();
        frame.setVisible(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int i, x = 1;  
        for (i = 2; i <= 600; i += 10, x += 7) {
            int frameWidth = i + x;
            int frameHeight = i;

            int posX = (screenWidth - frameWidth) / 2;
            int posY = (screenHeight - frameHeight) / 2;

            frame.setLocation(posX, posY);
            frame.setSize(frameWidth, frameHeight);
            try {
                Thread.sleep(8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SplashFrame extends JFrame implements Runnable {
    Thread t1;

    SplashFrame() {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/splash2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);
        add(l1);

        setUndecorated(true);

        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        try {
            Thread.sleep(7000); 
            this.setVisible(false);

            Login l = new Login();
            l.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
