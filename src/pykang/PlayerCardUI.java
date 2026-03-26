package pykang;


import javax.swing.*;
import java.awt.*;

public class PlayerCardUI extends JPanel {
// แต่งการ์ดคนเล่นสักหน่อย
    private String text;

    public PlayerCardUI(String t){

        text = t;

        setPreferredSize(new Dimension(80,120));
        setOpaque(false);

    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // shadow
        g2.setColor(new Color(0,0,0,80));
        g2.fillRoundRect(5,5,getWidth()-5,getHeight()-5,15,15);

        // card
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0,0,getWidth()-5,getHeight()-5,15,15);

        // border
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0,0,getWidth()-5,getHeight()-5,15,15);

        // text
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial",Font.BOLD,18));

        g2.drawString(text,getWidth()/2-15,getHeight()/2);

    }

}