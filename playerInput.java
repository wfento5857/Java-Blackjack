
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
    public playerInput(){
        Hand = new ArrayList<Card>();
    }
    void getMove(Deck d){
        boolean check = false;
        Scanner input = new Scanner(System.in);
        int r = -1; 
        
        while (!check){
            System.out.println("Your hand:\t"+Hand);
            System.out.println("Would you like to hit or pass? (0 to pass, 1 to hit)");
            r = input.nextInt();
            if (r == 1){
                Hand.add(d.drawRandCard());
            }
            else if (r == 0){
                check = true;
            }
            else{
                System.out.println("INCORRECT INPUT");
            }
        }
    }
}
