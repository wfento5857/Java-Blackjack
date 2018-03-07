
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Player
{
    abstract void getMove(Deck d);
    abstract void addCard(Card c);
    abstract int getWager();
    abstract void addMoney(int amt);
    abstract int getHandValue();
}
