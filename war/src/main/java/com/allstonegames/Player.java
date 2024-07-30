package com.allstonegames;

import java.util.LinkedList;

public class Player {

    Deck deck;
    String name;

    public Player(String name){
        this.deck = new Deck(false);
        this.name = name;
    }
    




    public Card getTopCard(){
        if(deck.hasCards()){
            return deck.giveTopCard();
        }else{
            return null;
        }
    }
        

    public LinkedList<Card> giveCardsForTie(){
        if(deck.hasCards()){
            LinkedList<Card> cards = new LinkedList<Card>();
            int deckSize = deck.getSize();
            if( deckSize< 4){
                for(int i=0; i < deckSize; i++){
                    cards.add(deck.giveTopCard());
                }
            }else{
                for(int i=0; i < 4; i++){
                    cards.add(deck.giveTopCard());
                }
            }
            return cards;
        }
        return null;
    }

    public LinkedList<Card> giveCardsForTie2(){
        if(deck.hasCards()){
            LinkedList<Card> cards = new LinkedList<Card>();
            // givess three face down cards, and a fourth face up
            // if it cant give 4 cards last card is face up
            for(int i=0; i < 4; i++){
                if(deck.hasCards()){
                    cards.add(deck.giveTopCard());
                }else{
                    break;
                }
            }
            return cards;
        }
        return null;
    }


    public void addCardToDeck(Card c){
        deck.addCard(c);
    }

    public void printDeck(){
        for(Card c : deck.getCards()){
            System.out.print(c.toString());
        }
    }

    public boolean hasCards(){
        return this.deck.hasCards();
    }

}
