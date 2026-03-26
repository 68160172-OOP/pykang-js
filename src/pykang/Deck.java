package pykang;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){

        cards = new ArrayList<>();

        String[] suits = {"♠","♥","♦","♣"};
        String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        for(String s : suits){

            for(String r : ranks){

                cards.add(new Card(r,s,getValue(r)));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card draw(){

        if(cards.isEmpty()){
            return null;
        }

        return cards.remove(0);
    }

    // คำนวณ value ของไพ่
    private int getValue(String rank){

        if(rank.equals("A")) return 1;

        if(rank.equals("J") || rank.equals("Q") || rank.equals("K")) return 10;

        return Integer.parseInt(rank);
    }
}