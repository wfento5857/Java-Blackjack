
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
    public Hand house,p1,p2,p3,p4;
    public Deck deck;
    public Blackjack(){
        deck = new Deck();
        house = new Hand(); 
        p1 = new Hand(); 
        p2 = new Hand();
        p3 = new Hand(); 
        p4 = new Hand();       
    }
    
    public void deal(){
        Random rand = new Random();
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 5; j++){
                switch(j){
                    case 0: house.add(deck.drawRandCard());
                    case 1: p1.add(deck.drawRandCard());
                    case 2: p2.add(deck.drawRandCard());
                    case 3: p3.add(deck.drawRandCard());
                    case 4: p4.add(deck.drawRandCard());
                }
            }
        }
    }
}
