
/**
 * Write a description of class easybot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class easyBot extends Player
{
    public ArrayList<Card> Hand;
    public int cash, id, handValue;

    public easyBot(int x){
        Hand = new ArrayList<Card>();
        cash = 100;
        id = x;
    }

    void getMove(Deck d){
        boolean check = false;
        int heck = 0;
        for (int i = 0; i < Hand.size(); i++){
            handValue += Hand.get(i).convert();
        }
        if (cash > 0){
            while (!check){
                if (handValue < 21){
                    Card c = d.drawRandCard();
                    Hand.add(c);
                    handValue += c.convert();
                }
                else if (handValue == 21){
                    check = true;
                }
                else if (handValue > 21){
                    check = true;
                    Hand.clear();
                }
            }
        }
        else{System.out.println(id + " OUT OF MONEY");}
        System.out.println(Hand);
    }

    int getHandValue() {
        return handValue;
    }

    public int getCash(){
        return cash;
    }

    public int getId(){
        return id;
    }

    void addCard(Card c){
        Hand.add(c);
    }

    void clearHand(){
        Hand.clear();
    }

    int getWager(){
        int wager = 30;
        if (cash <= wager){
            wager = cash;
        }

        return wager;
    }

    void addMoney(int amt){
        cash += amt;
    }

    public String toString(){
        return "Player " + id + " (easy bot)";
    }
}
