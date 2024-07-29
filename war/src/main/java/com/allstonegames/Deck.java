package com.allstonegames;


import java.util.ArrayList;

public class Deck {

    public ArrayList<Card>  cards;


    public Deck(){
        cards = new ArrayList<Card>();
        for(int s=1; s<=4; s++){
            for(int v=2; v<=14;v++){
                cards.add(new Card(v, s));
            }
        }
    }

    public void print(){
        for(Card c: cards){
            System.out.println(c.toString());
        }
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }




}
