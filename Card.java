
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables - replace the example below with your own
    private int face, suit;
    private String[] faces = {"Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
    private String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
    /**
     * Constructor for objects of class Card
     */
    public Card(int face1, int suit1)
    {
        // initialise instance variables
        face = face1;
        suit = suit1;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        String fin = faces[face] + " of " + suits[suit];
        return fin;
    }
}
