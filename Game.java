public class Game {
	public Deck deck; //Deck of unknown cards that a player draws from
	public Deck discard; //Discard pile where players can take the top card &/or remove cards
	public Player p1; //Player 1
	public Player p2; //Player 2
	public int pNum; //Number of human players

	public Game(int x) { //Constructor that sets up the game
		p1 = new HumanP1(1); //Setup player 1
		deck = new Deck(52); //Setup deck
		discard = new Deck(42); //Setup discard
		pNum = x; //Setting number of human players
		if(x==1) { //Setting player 2
			p2 = new ComputerAI(); // If one human player
		}
		else if(x==2) { //If two human players
			p2 = new HumanP1(2);
		}
		deck.createDeck(); //Adding all 52 cards to the deck and shuffling
		deal(); //Giving each player 5 cards to start with
		discard.add(deck.takeTop()); //Moving top card of deck to discard to give players a choice of taking discard or drawing
	}

	public boolean check(Player x){ //Checking for winning hand
		int pair = 0; //Counting number of sets
		if(x.hand[0].getCVal() == x.hand[1].getCVal()) pair++; //Compares values of card 1 & 2
		if(x.hand[0].getCVal() == x.hand[2].getCVal()) pair++; //Compares values of card 1 & 3
		if(x.hand[0].getCVal() == x.hand[3].getCVal()) pair++; //Compares values of card 1 & 4
		if(x.hand[0].getCVal() == x.hand[4].getCVal()) pair++; //Compares values of card 1 & 5
		if(x.hand[1].getCVal() == x.hand[2].getCVal()) pair++; //Compares values of card 2 & 3
		if(x.hand[1].getCVal() == x.hand[3].getCVal()) pair++; //Compares values of card 2 & 4
		if(x.hand[1].getCVal() == x.hand[4].getCVal()) pair++; //Compares values of card 2 & 5
		if(x.hand[2].getCVal() == x.hand[3].getCVal()) pair++; //Compares values of card 3 & 4
		if(x.hand[2].getCVal() == x.hand[4].getCVal()) pair++; //Compares values of card 3 & 5
		if(x.hand[3].getCVal() == x.hand[4].getCVal()) pair++; //Compares values of card 4 & 5
		if(pair==4) return true; //1 for the 2 pair & 3 for the 3 pair & gives the okay to end the game
		else return false; //Continues the game if the hand is not a winning hand
	}


	public void tOrder() { //Determines who goes first
		if(pNum==2) { //If there are two human players
			int x = (int) (Math.random() * 10); //Randomly choose who goes first
			if (x%2==1) {
				System.out.println("Player 1 will go first");
				P1Turn(); //Player one goes first
			}
			else if(x%2==0) {
				System.out.println("Player 2 will go first");
				P2Turn(); //Player two goes first
			}
		}
		else if(pNum==1) { //If there is one human player, computer will automatically go first
			System.out.println("Computer is dealing so Computer will go first");
			P2Turn();
		}
	}

	public void P1Turn() { //Player 1's turn
		boolean check = ((HumanP1) p1).turn(deck, discard); //Runs the turn and stores if they want to check if they won
		boolean win = check(p1); //Checks hand
		if(check==false && win==true) { //If they don't want it checked and they actually won
			System.out.println("Is winning hand! Gin Rummy! Player 1 Wins! To play again, restart the program.");
			System.exit(0); //Terminates program
		}
		else if (win==true) { //If winning hand
			System.out.println("Gin Rummy! Player 1 Wins! To play again, restart the program.");
			System.exit(0); //Terminates program
		}
		else System.out.println("Not a winning hand"); //Continues game and says they didn't win
		P2Turn(); //Next player turn
	}

	public void P2Turn() {//Player 2's turn
		if(pNum == 2) { // If there are two human players
			boolean check = ((HumanP1) p2).turn(deck, discard);//Refer to P1Turn for info on this
			boolean win = check(p2); //Checks hand
			if(check==false && win==true) {
				System.out.println("Is winning hand! Gin Rummy! Player 2 Wins! To play again, restart the program.");
				System.exit(0);
			}
			else if (win==true) {
				System.out.println("Gin Rummy! Player 2 Wins! To play again, restart the program.");
				System.exit(0);
			}
			else System.out.println("Not a winning hand");
		}
		else if (pNum == 1) { //If there is one human player
			boolean check = ((ComputerAI) p2).turn(); // Same as P1Turn but with a computer
			if(check==true) {
				boolean win = check(p2);
				if (win==true) {
					System.out.println("Gin Rummy! Computer Wins! To play again, restart the program.");
					System.exit(0);
				}
				else System.out.println("Not a winning hand");
			}
		}
		P1Turn(); //Next player turn
	}

	private void deal() { //Gives 5 cards to each player
		for(int i=0; i<5; i++) {
			p1.add(deck.takeTop());
			p2.add(deck.takeTop());
		}
	}
}
