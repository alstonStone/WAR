package com.allstonegames;

public class Game {

    Player p1;
    Player p2;
    Dealer d;
    int winner;
    public void newGame(){
        this.p1 = new Player("P1");
        this.p2 = new Player("P2");
        this.d = new Dealer();
        d.dealToPlayers(this.p1, this.p2);
    }

    public void start(){
      
      boolean playing = true;
      int gameWinner;
      while(playing){
        Round currentRound = new Round(p1, p2);
        currentRound.getCardsFromPlayers();
        //check who wins and give them the cards
        switch (currentRound.compareCards()) {
          case 1:
            printRoundWinner(1);
            currentRound.getWinnings().shuffle();
            currentRound.getWinnings().print();
            System.out.println();
            d.giveToPlayer(currentRound.getWinnings(), p1);

            break;
          case 2:
            printRoundWinner(2);
            currentRound.getWinnings().shuffle();
            currentRound.getWinnings().print();
            System.out.println();
            d.giveToPlayer(currentRound.getWinnings(), p2);
            break;
        }
        gameWinner = currentRound.checkForWinner();
        switch (gameWinner) {
          case 0:
            break;
          case 1:
            printGameWinner(1);
            p1.printDeck();
            playing = false;
            break;
          case 2:
          printGameWinner(2);
          p2.printDeck();
          playing = false;
            break;
        }
      }
    }

    public void printRoundWinner(int x){
      System.out.println("Player "+String.valueOf(x)+" Wins the Round");
    }
    public void printGameWinner(int x){
      System.out.println("Player "+String.valueOf(x)+" Wins the Game");

    }


}
