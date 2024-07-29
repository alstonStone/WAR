package com.allstonegames;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
    Deck deck;
    Player p1;
    Player p2;
    Card p1Card;
    Card p2Card;
    ArrayList<Card> winnings = new ArrayList<Card>();


    public Dealer(){
        deck = new Deck();
        shuffleDeck();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck.cards);
    }

    public void deal(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
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

    public void giveWinningsTo(Player p){
        for(Card c : this.winnings){
            p.addCard(c);
        }
        this.winnings = new ArrayList<Card>();
    }
    public void reportWinnings(Player p){
        System.out.println("Player: "+p.name+" Wins");
        System.out.print("Player: "+p.name+" Gets ");
        for(Card c: winnings){
            System.out.print(c.toString());
        }
        System.out.println();
    }

    public void startRound(int round){
        // try {
        //     TimeUnit.SECONDS.sleep(1);
        // } catch (Exception e) {
        // }
        Boolean active = true;
        System.out.println("Round: "+ String.valueOf(round));
        collectCards();
        while(active){
            int result =compare(this.p1Card, this.p2Card);
            switch (result) {
                case 1:
                    reportWinnings(p1);
                    giveWinningsTo(p1);
                    active = false;
                    break;
                case 2:
                    reportWinnings(p2);
                    giveWinningsTo(p2);
                    active = false;
                    break;
                case 0:
                    System.out.println("Holy Fuck a Tie has happened");
                    collectCards(p1.giveCardsForTie(), p2.giveCardsForTie());
                    judgeRound();
                    active = false;
                    break;
                default:
                    System.out.println("ERROR: "+String.valueOf(compare(p2Card, p2Card)));
                    active = false;
            }

        }
        System.out.println("End Round");
        System.out.println("Player1s");
        p1.mainHand.print();
        System.out.println("");
        System.out.println("Player2s");
        p2.mainHand.print();
        System.out.println("");
        System.out.println("");
    }

    public void judgeRound(){
        int result =compare(this.p1Card, this.p2Card);
        switch (result) {
            case 1:
                reportWinnings(p1);
                giveWinningsTo(p1);
                break;
            case 2:
                reportWinnings(p2);
                giveWinningsTo(p2);
                break;
            case 0:
                System.out.println("Holy Fuck a Tie has happened");
                collectCards(p1.giveCardsForTie(), p2.giveCardsForTie());
                judgeRound();
                break;
            default:
                System.out.println("ERROR: "+String.valueOf(compare(p2Card, p2Card)));
        }
    }

    // 1 p1 wins
    // 2 p2 wins
    // 0 tie
    // -1 ERROR
    public int compare(Card c1, Card c2){
        if (c1.value > c2.value){
            return 1;
        }
        if(c1.value < c2.value){
            return 2;
        }
        if(c1.value == c2.value){
            return 0;
        }
        return -1;
    }

    public void collectCards(){
        this.p1Card = this.p1.giveTopCard();
        this.p2Card = this.p2.giveTopCard();
        winnings.add(this.p1Card);
        winnings.add(this.p2Card);
    }
    public void collectCards(ArrayList<Card> c1, ArrayList<Card> c2){
        for(Card cc1:c1){
            winnings.add(cc1);
        }
        this.p1Card = winnings.getLast();
        for(Card cc2:c2){
            winnings.add(cc2);
        }
        this.p2Card = winnings.getLast();
    }

}
