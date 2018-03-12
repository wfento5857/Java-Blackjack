
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
    void clearHand(){
        Hand.clear();
    }   
    void getMove(Deck d) {
        boolean check = false;
        int handValue = getHandValue();
        if (cash >= 0){
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
        else{System.out.println(id + " OUT OF MONEY");}
        System.out.println(Hand);
        Hand.clear();
    }
    public int getCash(){
        return cash;
    }
    public int getId(){
        return id;
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
        cash -= 10;
        return 10;
    }

    void addMoney(int amt) {
        cash += amt;
    }

    public String toString() {
        return "Player " + id + " (hardBot)";
    }
}
