
public class Player{
	protected Card[] hand;
	protected int hC = 0;
	//set hand to six, for adding to the hand with pickup
	public Player() {
		hand = new Card[6];
	}//adds the card
	public void add(Card x) {
		hand[hC] = x;
		hC++;
	}//gets rid of certain number linked to card.
	protected Card discard(int p) {
		p--;
		Card h = hand[p];
		for(int i=p; i<hand.length; i++) {
			if(i==hand.length-1) {
				hand[i] = null;
				hC--;
				break;
			}
			else hand[i] = hand[i+1];
		}
		return h;
	}
//gets cards from array and adds number linked to them for human convince.
	public String getHand() {
		if (hC==6) return "1." + hand[0] + "   2." + hand[1] + "   3." + hand[2] + "   4." + hand[3] + "   5." + hand[4] + "   6." + hand[5];
		else return "1." + hand[0] + "   2." + hand[1] + "   3." + hand[2] + "   4." + hand[3] + "   5." + hand[4];
	}
}
