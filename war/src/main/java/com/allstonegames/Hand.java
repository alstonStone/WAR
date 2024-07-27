package com.allstonegames;

import java.util.ArrayList;

public class Hand {

    ArrayList<Card> cardsInHand = new ArrayList<Card>();

    public void print(){
        for(Card c: cardsInHand){
            System.out.print(c.toString());
        }
        System.out.println();
    }


    public ArrayList<Card> getCards(){
        return  this.cardsInHand;
    }

}
