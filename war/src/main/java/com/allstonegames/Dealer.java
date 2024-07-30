package com.allstonegames;

public class Dealer {

    Deck deck;

    public Dealer(){
        this.deck = new Deck(true);
        shuffleDeck();
    }

    public void shuffleDeck(){
        this.deck.shuffle();
    }

    public void reset(){
        this.deck = new Deck(true);
        shuffleDeck();
    }

    public void dealToPlayers(Player p1, Player p2){
        int count = 0;
        for(Card c : deck.getCards()){
            if(count%2 == 0){
                p1.addCardToDeck(c);
            }else{
                p2.addCardToDeck(c);
            }
            count++;
        }
        this.deck = new Deck(false);
    }

    public void giveToPlayer(Deck d, Player p){
        for(Card c: d.getCards()){
            p.addCardToDeck(c);
        }
    }

}
