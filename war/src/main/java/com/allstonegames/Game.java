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
        start();
    }

    public void start(){
      
      boolean playing = true;
      while(playing){
        Round currentRound = new Round(p1, p2);
        winner = currentRound.checkForWinner();
        if(winner != 0){
          playing = false;
        }
        int result = currentRound.startRound();
        printRoundWinner(result);
      }
      printGameWinner(winner);
    }

    public void printRoundWinner(int x){
      System.out.println("Player "+String.valueOf(x)+" Wins the Round");
    }
    public void printGameWinner(int x){
      System.out.println("Player "+String.valueOf(x)+" Wins the Game");

    }


}
