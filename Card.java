
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
    
    public int convert(){
        int fin = -1;
        String f = faces[face];
        switch(f){
            case "Ace": fin = 11;
            case "King": fin = 10;
            case "Queen": fin = 10;
            case "Jack": fin = 10;
            case "Ten": fin = 10;
            case "Nine": fin = 9;
            case "Eight": fin = 8;
            case "Seven": fin = 7;
            case "Six": fin = 6;
            case "Five": fin = 5;
            case "Four": fin = 4;
            case "Three": fin = 3;
            case "Two": fin = 2;
        }
        return fin;
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
