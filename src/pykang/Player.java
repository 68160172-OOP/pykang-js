package pykang;

import java.util.ArrayList;

public class Player {

    protected String name;
    protected ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void addCard(Card c){
        hand.add(c);
    }

   
    public void drawCard(Deck deck){

        Card c = deck.draw();

        if(c != null){
            hand.add(c);
        }

    }

}