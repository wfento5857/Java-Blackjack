
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
        System.out.println(p1.getHandValue());
        System.out.println(house.getHandValue());
        System.out.println(p2.getHandValue());
        System.out.println(p3.getHandValue());
        System.out.println(p4.getHandValue());
        if (p1.getHandValue() > house.getHandValue() && p1.getHandValue() > p2.getHandValue() && p1.getHandValue() > p3.getHandValue() && p1.getHandValue() > p4.getHandValue()){
            winner = 1;
        }
        else if (house.getHandValue() >= p1.getHandValue() && house.getHandValue() >= p2.getHandValue() && house.getHandValue() >= p3.getHandValue() && house.getHandValue() >= p4.getHandValue()){
            winner = 0;
        }
        else if (p2.getHandValue() > house.getHandValue() && p2.getHandValue() > p1.getHandValue() && p2.getHandValue() > p3.getHandValue() && p2.getHandValue() > p4.getHandValue()){
            winner = 2;
        }
        else if(p3.getHandValue() > house.getHandValue() && p3.getHandValue() > p1.getHandValue() && p3.getHandValue() > p2.getHandValue() && p3.getHandValue() > p4.getHandValue()){
            winner = 3;
        }
        else if(p4.getHandValue() > house.getHandValue() && p4.getHandValue() >  p1.getHandValue() && p4.getHandValue() > p2.getHandValue() && p4.getHandValue() > p3.getHandValue()){
            winner = 4;
        }
        return winner;
    }

    public static int Blackjack(){
        deck = new Deck();
        p1.clearHand();
        p2.clearHand();
        p3.clearHand();
        p4.clearHand();
        house.clearHand();
        deal();
        Player win = new easyBot(-1);
        int c1 = p1.getCash();
        int c2 = p2.getCash();
        int c3 = p3.getCash();
        int c4 = p4.getCash();
        int w1 = p1.getWager();
        int w2 = p2.getWager();
        int w3 = p3.getWager();
        int w4 = p4.getWager();
        int totalCash = w1 + w2 + w3 + w4;
        house.getMove(deck);
        p1.getMove(deck);
        if (c2 > w2){
            p2.getMove(deck);
        }
        if (c3 > w3){
            p3.getMove(deck);
        }
        if (c4 > w4){
            p4.getMove(deck);
        }
        int winner = checkWinner();
        switch (winner){
            case 1: p1.addMoney(totalCash);
            case 2: p2.addMoney(totalCash);
            case 3: p3.addMoney(totalCash);
            case 4: p4.addMoney(totalCash);
        }
        return winner;
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
            int p = Blackjack();
            System.out.println("Player " + p + " has won.");
            System.out.println("Would you like to play again? You have $" + p1.getCash() + "\ny for yes, n for no.");
            String z = input.nextLine();
            if (z.equalsIgnoreCase("y")) playAgain = true;
            else playAgain = false;
        }   while(playAgain);
    }
}
