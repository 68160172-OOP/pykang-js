package pykang;

import javax.swing.*;
import java.awt.*;

public class CardBack extends JPanel {

    public CardBack(int w,int h){

        setPreferredSize(new Dimension(w,h));
        setOpaque(false);

    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // เงา
        g2.setColor(new Color(0,0,0,70));
        g2.fillRoundRect(5,5,getWidth()-5,getHeight()-5,15,15);

        // ตัวกาดร์
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0,0,getWidth()-5,getHeight()-5,15,15);

        //กรอบ
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(0,0,getWidth()-5,getHeight()-5,15,15);

        // ข้อความ
        g2.setColor(new Color(180,0,0));
        g2.setFont(new Font("Tahoma",Font.BOLD,14));

        g2.drawString("แคง",getWidth()/2-12,getHeight()/2);

    }

}
