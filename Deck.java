
public class Deck {
	public Card[] pile;
	public int numC;
	private int shuffle = 0;
	//Set with max. In this case 6 for pickup
	public Deck(int max) {
		pile = new Card[max];
		numC = 0;
	}
	//add each suit and each value to add up to a full deck
	public void createDeck() {
		for(int i=1; i<14; i++) {
			add('H', i);
			add('D', i);
			add('C', i);
			add('S', i);
		}
		shuffle();
	}
	//Add to complete deck. one of each type/
	private void add(char s, int v) {
		pile[numC] = new Card(s, v);
		numC++;
	}
	//used to add to hand
	public void add(Card x) {
		pile[numC] = x;
		numC++;
	}//take two then swap the two then repeated a couple of times
	public void shuffle() {
		int x = 0; 
		int y = 0;
		for(int i=0; i<53; i++) {
			x = (int) (52 * Math.random());
			y = (int) (52 * Math.random());
			Card h = pile[x];
			pile[x] = pile[y];
			pile[y] = h;
			if(shuffle < 2) {
				shuffle++;
				shuffle();
			}
		}
		for(int i=0; i<43; i++) {
			x = (int) (42 * Math.random());
			y = (int) (42 * Math.random());
			Card h = pile[x];
			pile[x] = pile[y];
			pile[y] = h;
		}
	}
	//picks up from the top of pickup card
	public Card takeTop() {
		numC--;
		Card h = pile[numC];
		pile[numC] = null;
		return h;
	}
	public String getTop() { //Returns the card on the top of the deck
		return "Top: " + pile[numC-1];
	}
}
