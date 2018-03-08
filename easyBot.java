
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
        int handValue = getHandValue();
        if (cash >= 0){
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
        else{System.out.println(id + " OUT OF MONEY");}
    }

    int getHandValue() {
        int fin = 0;
        for (int i = 0; i < Hand.size(); i++){
            fin += Hand.get(i).convert();
        }
        return fin;
    }

    void addCard(Card c){
        Hand.add(c);
    }

    int getWager(){
        cash -= 25;
        return 25;
    }

    void addMoney(int amt){
        cash += amt;
    }

    public String toString(){
        return "Player " + id + " (easy bot)";
    }
}
