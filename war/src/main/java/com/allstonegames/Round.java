package com.allstonegames;



public class Round {
    Player p1;
    Player p2;
    Deck winnings;
    Card p1Card;
    Card p2Card;

    public Round(Player p1,Player p2){
        this.p1 = p1;
        this.p2 = p2;
        this.winnings = new Deck(false);
        
    }

        //maybe return ints to 
    public void getCardsFromPlayers(){
        /// if cant give a card enter win condition
        winnings.addCard(p1.getTopCard());
        this.p1Card = winnings.getLastCard();
        winnings.addCard(p2.getTopCard());
        this.p2Card = winnings.getLastCard();
    }


    public int checkForWinner(){
        if(!p2.hasCards()){
            return 1;
        }
        else if(!p1.hasCards()){
            return 2;
        }else{
            return 0;
        }
    }


    public int startRound(){
        getCardsFromPlayers();
        return compareCards();
    }


    public int compareCards(){
        if(p1Card.getValue() > p2Card.getValue()){
            return 1;
        }
        if(p2Card.getValue() > p1Card.getValue()){
            return 2;
        }
        return war();
    }


    public Deck getWinnings(){
        return this.winnings;
    }


    public int war(){
        System.out.println("WAR");
        if(checkForWinner() != 0){
            return checkForWinner();
        }
        for(Card c: p1.giveCardsForTie()){
            this.winnings.addCard(c);
        }
        this.p1Card = winnings.getLastCard();
        for(Card c: p2.giveCardsForTie()){
            this.winnings.addCard(c);
        }
        this.p2Card = winnings.getLastCard();
        return compareCards();
    }


}
