package com.allstonegames;



import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Deck {

    public LinkedList<Card>  cards;


    public Deck(boolean isFull){
        cards = new LinkedList<Card>();
        if(isFull){
            cards = new LinkedList<Card>();
            for(int s=1; s<=4; s++){
                for(int v=2; v<=14;v++){
                    cards.add(new Card(v, s));
                }
            }
        }
    }

    public void print(){
        for(Card c: cards){
            System.out.println(c.toString());
        }
    }

    public LinkedList<Card> getCards(){
        return this.cards;
    }

    public void shuffle(){
        Collections.shuffle(cards, new Random()); 
    }

    public boolean hasCards(){
        return cards.isEmpty();
    }
    public int getSize(){
        return cards.size();
    }

    public Card getTopCard(){
        return cards.pop();
    }
}
