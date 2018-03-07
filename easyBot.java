
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
    public int cash, id;
    
    public easyBot(int x){
        Hand = new ArrayList<Card>();
        cash = 100;
        id = x;
    }
    void getMove(Deck d){
        cash -= 5;
        boolean check = false;
        int handValue = Hand.get(0).convert() + Hand.get(1).convert();       
        while (!check){
            if (handValue < 21){
                Card c = d.drawRandCard();
                Hand.add(c);
                handValue += c.convert();
            }
            else{
                check = true;
            }
        }
    }
    void addCard(Card c){
        Hand.add(c);
    }
    int getWager(){
        return 25;
    }
    void addMoney(int amt){
        cash += amt;
    }
    public String toString(){
        return "Player " + id + " (easy bot)";
    }
}
