
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
    public int cash, id, handValue;
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
        int ch = 0;
        for (int i = 0; i < Hand.size(); i++){
            handValue += Hand.get(i).convert();
        }
        if (cash > 0){
            while (!check){
                if (handValue <= 16){
                    Card c = d.drawRandCard();
                    Hand.add(c);
                    handValue += c.convert();
                }
                else if (handValue > 16 && handValue <= 21){
                    check = true;
                }
                else if (handValue > 21){
                    String faceVal;
                    if (ch > 0){
                        for (Card g : Hand){
                            if (g.getFace().contains("Ace")){
                                handValue -= 10;
                                ch++;
                            }
                        }
                    }
                    else if (handValue > 21){
                        check = true;
                        clearHand();
                    }
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
        int wager = 10;
        if (cash <= wager){
            wager = cash;
        }
        return wager;
    }

    void addMoney(int amt) {
        cash += amt;
    }

    public String toString() {
        return "Player " + id + " (hardBot)";
    }
}
