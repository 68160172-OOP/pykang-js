package pykang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuGUI extends JFrame {

    public MainMenuGUI(){

        setTitle("KANG GAME");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED,4));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);

        JLabel title = new JLabel("KANG GAME");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial",Font.BOLD,36));

        gbc.gridy = 0;
        panel.add(title,gbc);

        RoundedButton play = new RoundedButton("Play");
        RoundedButton exit = new RoundedButton("Exit");

        play.addActionListener(e -> {

            dispose();
            new KangGUI();

        });

        exit.addActionListener(e -> System.exit(0));

        gbc.gridy = 1;
        panel.add(play,gbc);

        gbc.gridy = 2;
        panel.add(exit,gbc);

        add(panel);
        setVisible(true);
    }
}