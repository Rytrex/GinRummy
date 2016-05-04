import java.util.InputMismatchException;
import java.util.Scanner;
public class Tester {
	public static void main(String[] args) {
		System.out.println("\u2764 To win this game you must acquire a pair of two and mighty mighty group of three."); //Lists the rules of this version of the game
		System.out.println("\u25C6 To do this you must pick up a new card and then discard one from your hand.");
		System.out.println("\u2660 Although this may be a tough task, I have faith that you will be able to overcome the challenges that you may face.");
		System.out.println("\u2663 Good luck, Warrior.");
		int p = 0; //Number of human players
		Scanner scan = new Scanner(System.in);
		while (p<1 || p>2) { //If p is not 1 or 2, it asks for number of human players again
			try { //Makes sure the input is a number
				System.out.println("How many human players? [1-2] (Only 2P works at the moment)");
				p = scan.nextInt(); //Stores number of human players
			} catch (InputMismatchException e){String hold = scan.next();} //If input is not a number, it stores the input here.
		}

		Game g1 = new Game(p); //Sets up the game
		g1.tOrder(); //Starts turn order
	}	
}
