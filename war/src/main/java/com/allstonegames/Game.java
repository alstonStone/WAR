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
        while(true){
            battle();
            if(getWinner() == 0){
                continue;
            }else{
                break;
            }
        }
        System.out.println("Player:"+String.valueOf(getWinner()+" Wins!!!"));
    }

    public void battle(){
        int result = compare(p1.getCard(), p2.getCard());
        switch(result){
            case 1:
                p2.giveCard(p1);
                break;
            case 2:
                p1.giveCard(p2);
                break;
            default:
                p2.giveCard(p1);
                break;
        }
        
    }

    //detrimins what card wins .
    //returns 1 for first car, 2 for second
    public int compare(Card c1, Card c2){
        if(c1.value > c2.value){
            return 1;
        }
        if(c2.value > c1.value){
            return 2;
        }
        return 1;
    }

    public int getWinner(){
        if(p1.getCards().size() == 0){
            return 1;
        }
        if(p2.getCards().size() == 0){
            return 2;
        }
        return 0;
    }



}
