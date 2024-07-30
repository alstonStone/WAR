package com.allstonegames;



import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    public LinkedList<Card>  cards;


    public Deck(boolean isFull){
        this.cards = new LinkedList<Card>();
        if(isFull){
            this.cards = new LinkedList<Card>();
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
        Collections.shuffle(this.cards);
    }

    public boolean hasCards(){
        return !this.cards.isEmpty();
    }
    public int getSize(){
        return this.cards.size();
    }

    public Card giveTopCard(){
        return this.cards.pop();
    }

    public void addCard(Card c){
        this.cards.add(c);
    }
    
    public Card getLastCard(){
        return this.cards.getLast();
    }

}
