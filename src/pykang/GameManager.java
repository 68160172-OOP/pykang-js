package pykang;

import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {

    private Deck deck;
    private ArrayList<Card> discardPile;

    public Player player;
    public BotPlayer bot1;
    public BotPlayer bot2;
    public BotPlayer bot3;

    public GameManager(){

        deck = new Deck();
        discardPile = new ArrayList<>();

        player = new Player("You");
        bot1 = new BotPlayer("BotSurat boy");
        bot2 = new BotPlayer("BotHome boy");
        bot3 = new BotPlayer("BotCity boy");

        deck.shuffle();

        // แจกไพ่เริ่มต้น
        for(int i=0;i<5;i++){

            player.addCard(deck.draw());
            bot1.addCard(deck.draw());
            bot2.addCard(deck.draw());
            bot3.addCard(deck.draw());

        }
    }

    //  เพิ่ม method นี้
    public Deck getDeck(){
        return deck;
    }

    //  draw จาก deck
    public Card drawFromDeck(){
        return deck.draw();
    }

    //  discard
    public void addDiscard(Card c){
        discardPile.add(c);
    }

    //  ตรวจ Kang
    public boolean isKang(ArrayList<Card> hand){

        HashMap<String,Integer> map = new HashMap<>();

        for(Card c : hand){

            String r = c.getRank();
            map.put(r,map.getOrDefault(r,0)+1);

            if(map.get(r) >= 4){
                return true;
            }
        }

        return false;
    }
}
