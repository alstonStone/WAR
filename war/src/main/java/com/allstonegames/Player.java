package com.allstonegames;

import java.util.ArrayList;

public class Player {

    Hand mainHand = new Hand();
    public String name;


    public Player(String name){
        this.name = name;
    }

    public void addCard(Card c) {
        mainHand.cardsInHand.add(c);
    }

    public void print(){
        mainHand.print();
    }

    public Card getTopCard(){
        return mainHand.cardsInHand.get(0);
    }

    public Card giveTopCard(){
        Card c = getTopCard();
        mainHand.cardsInHand.remove(c);
        return c;
    }
    public ArrayList<Card> giveTopNCards(int nCards){
        ArrayList<Card> cards = new ArrayList<Card>();
        int count = 1;
        while(count < nCards){
            Card c = getTopCard();
            mainHand.cardsInHand.remove(c);
            cards.add(c);
            count++;
        }
        return cards;
    }

    // gives three cards face down, then a fourth card face up to compare.
    // if the player deoesnt have enough cards, they give what they can and flip their last card
    public ArrayList<Card> giveCardsForTie(){
        if(mainHand.getHandSize() >=4){
            return giveTopNCards(4);
        }else{
            return giveTopNCards(mainHand.getHandSize()-1);
        }
    }


    public ArrayList<Card> getCards(){
        return  this.mainHand.getCards();
    }

    

}
