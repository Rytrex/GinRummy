import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanP1 extends Player{
	private Scanner scan = new Scanner(System.in); //Input
	public int px; //Player Number
	public HumanP1(int x) { 
		super(); //Sets up basic player
		px = x; //Sets player number
	}
	public boolean turn(Deck deck, Deck discard){
		boolean nCheck=false; //Discard Number Check
		boolean dCheck=false; //Draw Check
		int remC = 0; //Stores discard number
		System.out.println("-------------------------------Player " + px + "----------------------------------");
		System.out.println(discard.getTop()); //Shows top of discard pile to player
		System.out.println(getHand()); //Shows hand to player
		while(dCheck==false){ //Makes sure they want to take from discard or deck and not something else
			System.out.println("Would you like to take the top of the discard?");
			String in = scan.next(); //Takes in what they want to do
			if(in == null) turn(deck, discard); //Makes sure the code doesn't break from using .equals
			else if(in.equalsIgnoreCase("Yes") || in.equalsIgnoreCase("Y")) { //If wants to take from discard pile
				add(discard.takeTop()); //Adds top of discard to hand
				while(nCheck==false){ //Makes sure the number is within the allowed range
					try { //Makes sure the input is a number
						System.out.println("Which card would you like to discard? [1-5]");
						int rem = scan.nextInt(); //Stores input number
						if(rem > 0 && rem < 6) { //Makes sure the input is within the allowed range
							nCheck = true; //Allows the loop to break
							remC = rem; //Store the number elsewhere to be used later.
						}
					} catch (InputMismatchException e){String hold = scan.next();} //If not a number, stored here.
				}
				discard.add(discard(remC)); //Discards the number chosen
				dCheck = true; //Allows the pass if they choose to take from discard or deck
				return wCheck(); //Sees if they want to check if they won
			}
			else if(in.equalsIgnoreCase("No") || in.equalsIgnoreCase("N")) { //If they want to take from deck
				add(deck.takeTop()); //Adds top card of deck to player hand
				while (nCheck == false) { //Makes sure the number is within the allowed range
					try { //Makes sure the input is a number
						System.out.println("\nWhich card would you like to discard? [1-6]");
						System.out.println(getHand()); //Shows hand with new card drawn
						int rem = scan.nextInt(); //Stores the inputed number
						if(rem > 0 && rem < 7) { //Allowed range
							nCheck = true;  //Allows the loop to break
							remC = rem; //Stores the number elsewhere to be used later
						}
					} catch (InputMismatchException e){String hold = scan.next();} //If the input is not a number, the input is stored here
				}
				discard.add(discard(remC)); //Removes the card chosen by the player
				dCheck = true; //Allows the pass if they choose to take from discard or deck
				return wCheck();//Sees if they want to check if they won
			}
		}
		return false; //Never reaches this, but creates an error if this is not here.
	}
	private boolean wCheck() { //Asks if they want to check for a win
		boolean wC = false; //Correct input check
		while(wC==false) { //Makes sure the input is yes or no
			System.out.println("Do you think you've won?");
			String win = scan.next(); //Stored input
			if(win.equalsIgnoreCase("Yes") || win.equalsIgnoreCase("Y")) { //If they want it checked.
				wC = true; //Breaks the loop
				return true; //Tells game to check the player's hand
			}
			else if(win.equalsIgnoreCase("No") || win.equalsIgnoreCase("N")) {
				wC = true; //Breaks the loop
				return false; //Goes to next player's turn
			}
		}
		return false;
	}
}
