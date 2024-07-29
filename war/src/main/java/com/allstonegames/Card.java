package com.allstonegames;


// Represents a card in a deck of cards
// A card's suit is determined by integers 1-4
// 1 - clubs
// 2 - spades
// 3 - diamonds
// 4 - hearts
public class Card {

    int value;
    int suit;


    public Card(int value, int suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){
        return this.value;
    }

    public int getSuite(){
        return this.suit;
    }

    public String toString(){
        String cardValue;
        String cardSuit = "X";

        //ace is low
        switch(this.value) {
            case 10:
                cardValue = "10";
                break;
            case 11:
                cardValue = "J ";
                break;
            case 12:
                cardValue = "Q ";
                break;
            case 13:
                cardValue = "K ";
                break;
            case 14:
                cardValue = "A ";
                break;
            default:
                cardValue = String.valueOf(this.value)+" ";
                break;
        }
        // 1 - clubs
        // System.out.println("\u0005 This should be a Clubs suit symbol.");
        // 2 - spades
        // System.out.println("\u0006 This should be a Spades suit symbol.");
        // 3 - diamonds
        // System.out.println("\u0004 This should be a Diamonds suit symbol.");
        // 4 - hearts
        // System.out.println("\u0003 This should be a Hearts suit symbol.");
        switch(this.suit) {
            case 1:
                cardSuit = "\u0005";
                break;
            case 2:
                cardSuit = "\u0006";
                break;
            case 3:
                cardSuit = "\u0004";
                break;
            case 4:
                cardSuit = "\u0003";
                break;

        }
        return "["+cardValue+cardSuit+"]";
    }



}
