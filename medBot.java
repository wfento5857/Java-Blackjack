
/**
 * Write a description of class medBot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class medBot extends Player
{
    public ArrayList<Card> Hand;
    public int cash;
    public medBot(){
        Hand = new ArrayList<Card>();
    }
    void getMove(Deck d) {
        boolean check = false;
        int handValue = Hand.get(0).convert() + Hand.get(1).convert();
        while(!check) {
            if(handValue <= 18) {
                Card c = d.drawRandCard();
                Hand.add(c);
                handValue += c.convert();
            }
            else {
                check = true;
            }
        }
    } 
    void addCard(Card c){
        Hand.add(c);
    }
    int getWager() {
        return 15;
    }
    void addMoney(int amt) {
        cash += amt;
    }
}
