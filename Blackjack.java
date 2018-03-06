
/**
 * Write a description of class Blackjack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Blackjack
{
    // instance variables - replace the example below with your own
    public Player house,p1,p2,p3,p4;
    public Deck deck;
    public Blackjack(){
        deck = new Deck();
    }
    
    public void deal(){
        Random rand = new Random();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 5; j++){
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
        
    }
}
