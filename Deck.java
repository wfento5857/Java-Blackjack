
/**
 * Write a description of class dECK here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Deck
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> cards;
    
    /**
     * Constructor for objects of class dECK
     */
    public Deck()
    {
        // initialise instance variables
        cards = new ArrayList<Card>(52);
        for(int i = 0; i <= 3; i++){
            for (int j = 0; j <= 12; j++){
                cards.add(new Card(j, i));
            }
        }
        this.shuffle();
    }
    
    public ArrayList<Card> getDeck(){
        return cards;
    }
    /*public Card getCard(int index){
        
    }*/
    public Card drawRandCard(){
        Random rand = new Random();
        int r = rand.nextInt(cards.size());
        Card c = cards.get(r);
        cards.remove(r);
        return c;
    }

    public void drawRandCards(int num){
        System.out.println("You drew:");
        Random rand = new Random();
        for (int i = 0; i < num; i++){
            int r = rand.nextInt(cards.size());
            Card c = cards.get(r);
            cards.remove(r);
            System.out.println("\t" + c);
        }
        System.out.println("There are " + cards.size() + " cards left in the deck.");
    }
    
    public ArrayList drawRandSplit(int num){
        ArrayList<Card> newPile = new ArrayList<Card>(num);
        Scanner input = new Scanner(System.in);
        System.out.println("You drew:");
        Random rand = new Random();
        for (int i = 0; i < num; i++){
            int r = rand.nextInt(cards.size());
            Card c = cards.get(r);
            cards.remove(r);
            cards.add(c);
            newPile.add(c);
            System.out.println("\t" + c);
        }
        boolean test = true;
        ArrayList<Card> c = new ArrayList<Card>();
        while(test){
            System.out.println("Split or discard? (s/d)");
            if (input.nextLine().equals("s")) {
                test = false;
                c = newPile;
            }
            else if (input.nextLine().equals("d")){ 
                test = false;
                c = cards;
            }
            else{
                test = true;
            }
        }
        return c;
    }
    
    public ArrayList<Card> shuffle(){
        Random rand = new Random();
        for (int i = 0; i < cards.size(); i++){
            int r = rand.nextInt(cards.size());
            Card c = cards.get(r);
            cards.remove(r);
            cards.add(c);
            //System.out.println("\t" + c);
        }
        return cards;
    }
    
    public void split(ArrayList<Card> g, int num){
        ArrayList<Card> pile1 = new ArrayList<Card>(g.size()/2);
        ArrayList<Card> pile2 = new ArrayList<Card>(g.size()/2);
        ArrayList<Card> master = g;
        Random rand = new Random();
        int m = master.size();
        System.out.println("Cards in master pile:\n " + master);
        System.out.println("Cards in pile 1");
        for (int i = 0; i < num; i++){
            int r = rand.nextInt(master.size());
            Card c = cards.get(r);
            master.remove(r);
            pile1.add(c);
            System.out.println("\t" + c);
        }
        System.out.println("Cards in pile 2");
        for (int i = 0; i < 52-num; i++){
            int r = rand.nextInt(master.size());
            Card c = cards.get(r);
            master.remove(r);
            pile2.add(c);
            System.out.println("\t" + c);
        }
    }
}

