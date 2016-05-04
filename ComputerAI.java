
public class ComputerAI extends Player {
	public boolean turn() { //Computer is incomplete so we exit the program to make sure we do not loop one player
		System.out.println("Computer Forfeits. Player 1 wins! To play again, restart the program.");
		System.exit(0);
		return false;
	}
}
