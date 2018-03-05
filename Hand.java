
/**
 * Write a description of class Hand here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Hand
{
    // instance variables - replace the example below with your own
    public int size;
    private ArrayList<Card> hand;
    public Hand(){
        hand = new ArrayList<Card>();
        size = 0;
    }
    
    public void add(Card c){
        hand.add(c);
        size++;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }
}
