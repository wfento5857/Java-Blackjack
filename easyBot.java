
/**
 * Write a description of class easybot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class easyBot extends Player
{
    // instance variables - replace the example below with your own
    public easyBot(){}
    void getMove(Hand h, Deck d){
        boolean check = false;
        ArrayList<Card> hand = h.getHand();
        int handValue = hand.get(0).convert() + hand.get(1).convert(); 
        
        while (!check){
            if (handValue < 21){
                Card c = d.drawRandCard();
                h.add(c);
                handValue += c.convert();
            }
            else{
                check = true;
            }
        }
    }
}
