
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public abstract class Player
{
    int cash, id;
    ArrayList<Card> Hand;
    abstract void getMove(Deck d);
    abstract void addCard(Card c);
    abstract int getWager();
    abstract void addMoney(int amt);
    abstract int getHandValue();
    abstract int getCash();
    abstract int getId();
    abstract void clearHand();
}
