
/**
 * Write a description of class playerInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class playerInput extends Player
{
    public ArrayList<Card> Hand;
    public int cash, id;
    public playerInput(int x){
        Hand = new ArrayList<Card>();
        cash = 100;
        id=x;
    }
    void getMove(Deck d){
        boolean check = false;
        Scanner input = new Scanner(System.in);
        int r = -1; 
        if (cash >= 0){
            do{
                System.out.println("Your hand:\t"+Hand);
                System.out.println("Would you like to hit or pass? (0 to pass, 1 to hit)");
                r = input.nextInt();
                if (r == 1){
                    Hand.add(d.drawRandCard());
                    if (getHandValue() > 21){
                        Hand.clear();
                        System.out.println("BUSTED BOIIII");
                        check = true;
                    }
                }
                else if (r == 0){
                    check = true;
                }
                else{
                    System.out.println("INCORRECT INPUT");
                }
            }while (!check);
        }
        
    }
    void addCard(Card c){
        Hand.add(c);
    }
    void clearHand(){
        Hand.clear();
    }   
    int getWager(){
        Scanner input = new Scanner(System.in);
        boolean check = false;
        int fin = 0;
        if (cash == 0){
            System.out.println("NO MONEY");
            Hand.clear();
        }
        while(!check){
            System.out.println("Wager?");
            int w = input.nextInt();
            input.nextLine();
            if (w > cash){
                System.out.println("ERROR: NO MONEY FOR BET");
            }
            else{
                System.out.println("YOUR BET HAS BEEN ACCEPTED");
                cash -= w;
                fin = w;
                check = true;
            }
        }
        
        return fin + 5;
    }
    void addMoney(int amt){
        cash += amt;
    }
    public int getHandValue(){
        int fin = 0;
        for (int i = 0; i < Hand.size(); i++){
            fin += Hand.get(i).convert();
        }
        return fin;
    }
    public String toString(){
        return "Player " + id + " (player)";
    }
    public int getCash(){
        return cash;
    }
    public int getId(){
        return id;
    }
}
