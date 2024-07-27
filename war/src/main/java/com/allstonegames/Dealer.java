package com.allstonegames;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
    Deck deck;
    Player p1;
    Player p2;

    public Dealer(){
        deck = new Deck();
        shuffleDeck();
    }

    public Deck shuffleDeck(Deck d){
        Collections.shuffle(this.deck.cards);
        return  this.deck;
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck.cards);
    }

    public void deal(Player p1, Player p2){
        int count = 0;
        for(Card c : this.deck.cards){
            if(count%2 == 0){
                p1.addCard(c);
            }else{
                p2.addCard(c);
            }
            count++;
        }
    }

    public void givetO(ArrayList<Card> cards, Player p){
        for(Card c: cards){
            p.addCard(c);
        }
        
    }

}
