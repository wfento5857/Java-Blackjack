
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
        if (cash > 0){
            while (!check){
                int handValue = getHandValue();
                if (handValue <= 16){
                    Card c = d.drawRandCard();
                    Hand.add(c);
                }
                else if (handValue > 16 && handValue <= 21){
                    check = true;
                }
                else if (handValue > 21){
                    Hand.clear();
                    check = true;
                }
            }
        }
        else{System.out.println(id + " OUT OF MONEY");}
        System.out.println(Hand);
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
        return 10 + 5;
    }

    void addMoney(int amt) {
        cash += amt;
    }

    public String toString() {
        return "Player " + id + " (hardBot)";
    }
}
