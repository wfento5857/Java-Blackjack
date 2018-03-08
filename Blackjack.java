
/**
 * Write a description of class Blackjack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Blackjack
{
    // instance variables - replace the p4.getHandValue()ample below with your own
    private static Player house,p1,p2,p3,p4;
    public static Deck deck;
    public Blackjack(){

    }

    public static int checkWinner(){
        int winner = -1;
        if (p1.getHandValue() > house.getHandValue() && p1.getHandValue() > p2.getHandValue() && p1.getHandValue() > p3.getHandValue() && p1.getHandValue() > p4.getHandValue()){
            if (p1.getHandValue() <= 21){
                winner = 1;
            }
            else winner = -1;
        }
        else if (house.getHandValue() > p1.getHandValue() && house.getHandValue() > p2.getHandValue() && house.getHandValue() > p3.getHandValue() && house.getHandValue() > p4.getHandValue()){
            if (house.getHandValue() <= 21) winner = 0;
            else winner = -1;
        }
        else if (p2.getHandValue() > house.getHandValue() && p2.getHandValue() > p1.getHandValue() && p2.getHandValue() > p3.getHandValue() && p2.getHandValue() > p4.getHandValue()){
            if(p2.getHandValue() <= 21) winner = 2;
            else winner = -1;            
        }
        else if(p3.getHandValue() > house.getHandValue() && p3.getHandValue() > p1.getHandValue() && p3.getHandValue() > p2.getHandValue() && p3.getHandValue() > p4.getHandValue()){
            if(p3.getHandValue() <= 21) winner = 3;
            else winner = -1;
        }
        else if(p4.getHandValue() > house.getHandValue() && p4.getHandValue() >  p1.getHandValue() && p4.getHandValue() > p2.getHandValue() && p4.getHandValue() > p3.getHandValue()){
            if(p4.getHandValue() <= 21) winner = 4;
            else winner = -1;
        }
        return winner;
    }

    public static Player Blackjack(){
        deck = new Deck();
        
        deal();
        house.getMove(deck);
        p1.getMove(deck);
        p2.getMove(deck);
        p3.getMove(deck);
        p4.getMove(deck);
        int winner = checkWinner();
        Player win = new easyBot(-1);
        int cashPool = house.getWager() + p1.getWager() + p2.getWager() + p3.getWager() + p4.getWager();
        switch(winner){
            case 0: 
            house.addMoney(cashPool);
            win = house;
            case 1: 
            p1.addMoney(cashPool);
            win = p1;
            case 2: 
            p2.addMoney(cashPool);
            win = p2;
            case 3: 
            p3.addMoney(cashPool);
            win = p3;
            case 4:
            p4.addMoney(cashPool);
            win = p4;
        }
        return win;
    }

    public static void deal(){
        Random rand = new Random();
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 4; j++){
                switch(j){
                    case 0: house.addCard(deck.drawRandCard());
                    case 1: p1.addCard(deck.drawRandCard());
                    case 2: p2.addCard(deck.drawRandCard());
                    case 3: p3.addCard(deck.drawRandCard());
                    case 4: p4.addCard(deck.drawRandCard());
                }
            }
        }
    }

    public static void main (String args[]){
        System.out.println("Input: \n 1 for easy \n 2 for medium \n 3 for hard");
        boolean check = false;
        Scanner input = new Scanner(System.in);
        while(!check){
            int c = input.nextInt();
            input.nextLine();
            if (c == 1){
                house = new easyBot(0);
                p1 = new playerInput(1);
                p2 = new easyBot(2);
                p3 = new easyBot(3);
                p4 = new easyBot(4);
                check = true;
            }
            else if (c == 2){
                house = new medBot(0);
                p1 = new playerInput(1);
                p2 = new medBot(2);
                p3 = new medBot(3);
                p4 = new medBot(4);
                check = true;
            }
            else if (c == 3){
                house = new hardBot(0);
                p1 = new playerInput(1);
                p2 = new hardBot(2);
                p3 = new hardBot(3);
                p4 = new hardBot(4);
                check = true;
            }
        }
        boolean playAgain = true;
        do{
            Player p = Blackjack();
            System.out.println("Player " + p.getId() + " has won.");
            System.out.println("Would you like to play again? You have $" + p1.getCash() + "\ny for yes, n for no.");
            String z = input.nextLine();
            if (z.equals("y")) playAgain = true;
            else playAgain = false;
        }   while(playAgain);
    }
}
