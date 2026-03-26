package pykang;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    public RoundedButton(String text){

        super(text);

        setFocusPainted(false);
        setForeground(Color.WHITE);
        setBackground(Color.RED);
        setFont(new Font("Arial",Font.BOLD,20));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(150,50));

    }

    protected void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0,0,getWidth(),getHeight(),40,40);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.drawRoundRect(0,0,getWidth()-1,getHeight()-1,40,40);

    }
}