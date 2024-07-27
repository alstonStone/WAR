package com.allstonegames;

import java.util.ArrayList;

public class Player {

    Hand hand = new Hand();
    public String name;

    public Player(String name){
        this.name = name;
    }



    public void addCard(Card c) {
        hand.cardsInHand.add(c);
    }

    public void print(){
        hand.print();
    }

    public Card getCard(){
        return hand.cardsInHand.get(0);
    }
    public Card getCard(int depth){
        return hand.cardsInHand.get(depth);
    }

    public Card giveCard(){
        Card c = hand.cardsInHand.get(0);
        hand.cardsInHand.remove(0);
        return c;
    }

    public void giveCard(Player p){
        Card c = hand.cardsInHand.get(0);
        hand.cardsInHand.remove(c);
        System.out.println(this.name+" gives "+c.toString()+ " to "+p.name);
        p.addCard(c);
    }

    public ArrayList<Card> getCards(){
        return  this.hand.getCards();
    }

}
