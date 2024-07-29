package com.allstonegames;

public class Game {

    Player p1;
    Player p2;
    Dealer d;

    public void newGame(){
        this.p1 = new Player("P1");
        this.p2 = new Player("P2");
        this.d = new Dealer();
        
        d.deal(p1, p2);
        p1.print();
        p2.print();
    }

    public void Start(){
        boolean playing = true;
        int roundCount = 1;
        String winner ="";
        while(playing){
            if(p1.mainHand.isEmpty()){
                playing = false;
                winner = p2.name;
                break;
            }
            if(p2.mainHand.isEmpty()){
                playing = false;
                winner = p1.name;
                break;
            }
            d.startRound(roundCount);
            roundCount++;
        }
    System.out.println(winner+" WINS!!!");

    }




}
