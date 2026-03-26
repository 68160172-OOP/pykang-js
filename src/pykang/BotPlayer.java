package pykang;

import java.util.Random;

public class BotPlayer extends Player {

    public BotPlayer(String name){
        super(name);
    }

    public void playTurn(GameManager game){

        // จั่วไพ่
        Card c = game.drawFromDeck();

        if(c != null){
            hand.add(c);
        }

        // เช็ค Kang
        if(game.isKang(hand)){
            new ResultGUI(name + " KANG! Vaallll");
            return;
        }

        // ทิ้งไพ่
        if(hand.size() > 0){

            Random r = new Random();
            Card discard = hand.remove(r.nextInt(hand.size()));

            game.addDiscard(discard);
        }

    }

}