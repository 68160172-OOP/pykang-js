package pykang;

public class Card {

    private String rank;
    private String suit;
    private int value;

    public Card(String rank,String suit,int value){
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public String getRank(){
        return rank;
    }

    public String getSuit(){
        return suit;
    }

    //
    public String getImage(){

        return rank + suit + ".png";

    }

    public String toString(){
        return rank + suit;
    }

}