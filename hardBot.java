
/**
 * Write a description of class hardBot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class hardBot extends Player
{
    public ArrayList<Card> Hand;
    public int cash, id;
    public hardBot(int x) {
        Hand = new ArrayList<Card>();
        cash = 100;
        id = x;
    }

    void getMove(Deck d) {
        boolean check = false;
        int handValue = Hand.get(0).convert() + Hand.get(1).convert();
        while(!check){
            if(handValue <= 16){
                Card c = d.drawRandCard();
                Hand.add(c);
                handValue += c.convert();
            }
            else {
                check = true;
            }
        }
    }

    int getHandValue() {
        int fin = 0;
        for (int i = 0; i < Hand.size(); i++){
            fin += Hand.get(i).convert();
        }
        return fin;
    }

    void addCard(Card c) {
        Hand.add(c);
    }

    int getWager() {
        return 10;
    }

    void addMoney(int amt) {
        cash += amt;
    }

    public String toString() {
        return "Player " + id + " (hardBot)";
    }
}
