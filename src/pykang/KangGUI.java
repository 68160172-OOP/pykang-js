package pykang;

import javax.swing.*;
import java.awt.*;

public class KangGUI extends JFrame {

    private GameManager game;

    private JPanel playerPanel;
    private JPanel botTopPanel;
    private JPanel botLeftPanel;
    private JPanel botRightPanel;

    public KangGUI(){

        game = new GameManager();

        setTitle("Kang Card Game");
        setSize(1000,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(0,120,0));

        createTable();

        setVisible(true);
    }

    private void createTable(){

        JPanel table = new JPanel(new BorderLayout());
        table.setOpaque(false);
        add(table);

        // ---------------------- BOT1 (ด้านบน) -------------------------

        JPanel botTopWrapper = new JPanel(new BorderLayout());
        botTopWrapper.setOpaque(false);

        botTopPanel = new JPanel();
        botTopPanel.setOpaque(false);

        JLabel botSurat = new JLabel(game.bot1.getName());
        botSurat.setForeground(Color.WHITE);
        botSurat.setFont(new Font("Arial",Font.BOLD,16));
        botSurat.setHorizontalAlignment(SwingConstants.CENTER);

        botTopWrapper.add(botSurat,BorderLayout.NORTH);
        botTopWrapper.add(botTopPanel,BorderLayout.CENTER);

        table.add(botTopWrapper,BorderLayout.NORTH);


        // ------- CENTER AREA ----------------

        JPanel center = new JPanel(new BorderLayout());
        center.setOpaque(false);
        table.add(center,BorderLayout.CENTER);


        // ----------------- BOT2 (ซ้าย) -------------------

        JPanel botLeftWrapper = new JPanel(new BorderLayout());
        botLeftWrapper.setOpaque(false);

        // ⭐ ซ้ายดี
        botLeftWrapper.setBorder(BorderFactory.createEmptyBorder(0,140,0,0));

        botLeftPanel = new JPanel(new GridLayout(5,1,5,5));
        botLeftPanel.setOpaque(false);

        JLabel botHomeboy = new JLabel(game.bot2.getName());
        botHomeboy.setForeground(Color.WHITE);
        botHomeboy.setFont(new Font("Arial",Font.BOLD,16));
        botHomeboy.setHorizontalAlignment(SwingConstants.CENTER);

        botLeftWrapper.add(botLeftPanel,BorderLayout.CENTER);
        botLeftWrapper.add(botHomeboy,BorderLayout.SOUTH);

        center.add(botLeftWrapper,BorderLayout.WEST);


        // ------------- BOT3 (ขวา) --------------

        JPanel botRightWrapper = new JPanel(new BorderLayout());
        botRightWrapper.setOpaque(false);

        // ⭐ ขวาร้าย
        botRightWrapper.setBorder(BorderFactory.createEmptyBorder(0,0,0,140));

        botRightPanel = new JPanel(new GridLayout(5,1,5,5));
        botRightPanel.setOpaque(false);

        JLabel botCityboy = new JLabel(game.bot3.getName());
        botCityboy.setForeground(Color.WHITE);
        botCityboy.setFont(new Font("Arial",Font.BOLD,16));
        botCityboy.setHorizontalAlignment(SwingConstants.CENTER);

        botRightWrapper.add(botRightPanel,BorderLayout.CENTER);
        botRightWrapper.add(botCityboy,BorderLayout.SOUTH);

        center.add(botRightWrapper,BorderLayout.EAST);


        // ---------- กลางโต๊ะ --------------

        JPanel middle = new JPanel();
        middle.setOpaque(false);

        JPanel deckPanel = new JPanel();
        deckPanel.setOpaque(false);
        deckPanel.setLayout(new BoxLayout(deckPanel,BoxLayout.Y_AXIS));

        deckPanel.add(new CardBack(60,90));
        deckPanel.add(new JLabel("Deck"));

        JPanel discardPanel = new JPanel();
        discardPanel.setOpaque(false);
        discardPanel.setLayout(new BoxLayout(discardPanel,BoxLayout.Y_AXIS));

        discardPanel.add(new CardBack(60,90));
        discardPanel.add(new JLabel("Discard"));

        RoundedButton draw = new RoundedButton("Draw");

        draw.addActionListener(e -> playerDraw());

        middle.add(deckPanel);
        middle.add(discardPanel);
        middle.add(draw);

        center.add(middle,BorderLayout.CENTER);


        // ---------------- PLAYER AREA ----------------

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setOpaque(false);

        table.add(bottom,BorderLayout.SOUTH);

        RoundedButton kang = new RoundedButton("Kang");

        kang.addActionListener(e -> {

            new ResultGUI("YOU KANG!\nYOU WIN!");
            dispose();

        });

        JPanel kangPanel = new JPanel();
        kangPanel.setOpaque(false);
        kangPanel.add(kang);

        bottom.add(kangPanel,BorderLayout.NORTH);


        playerPanel = new JPanel();
        playerPanel.setOpaque(false);

        bottom.add(playerPanel,BorderLayout.CENTER);


        RoundedButton exit = new RoundedButton("Exit");

        exit.addActionListener(e -> {

            new MainMenuGUI();
            dispose();

        });

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitPanel.setOpaque(false);
        exitPanel.add(exit);

        bottom.add(exitPanel,BorderLayout.SOUTH);

        refreshTable();
    }

    private void refreshTable(){

        playerPanel.removeAll();

        for(Card c : game.player.getHand()){

            PlayerCardUI card = new PlayerCardUI(c.toString());

            card.addMouseListener(new java.awt.event.MouseAdapter(){

                public void mouseClicked(java.awt.event.MouseEvent e){

                    discardCard(c);

                }

            });

            playerPanel.add(card);
        }

        botTopPanel.removeAll();
        for(int i=0;i<game.bot1.getHand().size();i++)
            botTopPanel.add(new CardBack(40,60));

        botLeftPanel.removeAll();
        for(int i=0;i<game.bot2.getHand().size();i++)
            botLeftPanel.add(new CardBack(40,60));

        botRightPanel.removeAll();
        for(int i=0;i<game.bot3.getHand().size();i++)
            botRightPanel.add(new CardBack(40,60));

        repaint();
        revalidate();
    }

    private void playerDraw(){

        game.player.drawCard(game.getDeck());

        refreshTable();
        botTurn();
    }

    private void discardCard(Card c){

        game.player.getHand().remove(c);

        refreshTable();
        botTurn();
    }

    private void botTurn(){

        game.bot1.drawCard(game.getDeck());
        game.bot2.drawCard(game.getDeck());
        game.bot3.drawCard(game.getDeck());

        refreshTable();
    }
}