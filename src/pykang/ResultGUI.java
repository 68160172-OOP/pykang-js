package pykang;

import javax.swing.*;
import java.awt.*;

public class ResultGUI extends JFrame {

    public ResultGUI(String text){

        setTitle("RESULT");
        setSize(800,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED,4));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);

        JLabel result = new JLabel(text);
        result.setForeground(Color.WHITE);
        result.setFont(new Font("Arial",Font.BOLD,32));

        gbc.gridy = 0;
        panel.add(result,gbc);

        RoundedButton menu = new RoundedButton("Menu");

        menu.addActionListener(e -> {

            dispose();
            new MainMenuGUI();

        });

        gbc.gridy = 1;
        panel.add(menu,gbc);

        add(panel);
        setVisible(true);
    }
}