
/**
 * Write a description of class playerInput here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class playerInput extends Player
{
    // instance variables - replace the example below with your own
    public playerInput(){}
    void getMove(Hand h, Deck d){
        boolean check = false;
        Scanner input = new Scanner(System.in);
        int r = -1; 
        while (!check){
            System.out.println("Would you like to hit or pass? (0 to pass, 1 to hit)");
            r = input.nextInt();
            
            if (r == 1){
                h.add(d.drawRandCard());
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
