package pykang;

import javax.swing.*;
import java.net.URL;

public class CardButton extends JButton {

    private Card card;

    public CardButton(Card card){

        this.card = card;

        String path = "/pykang/cards/" + card.getImage();

        URL location = getClass().getResource(path);

        if(location != null){

            setIcon(new ImageIcon(location));

        }else{

            setText(card.toString());

        }

    }

}