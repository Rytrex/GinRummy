
public class Card {
	private char suit;
	public int val;
	
	public int getCVal() {
		return val;
	}
	//0 < val < 14
	public Card(char s, int v) {
		suit = s;
		val = v;
	}
	@Override
	public String toString() {
		String value;
		if(val==1) value = "A";//Ace
		else if(val==11) value = "J";//Jack
		else if(val==12) value = "Q";//Queen
		else if(val==13) value = "K";//King
		else value = Integer.toString(val);
		
		if(suit =='H') return "\u2764" + value; //Hearts
		else if(suit =='D') return "\u25C6" + value; //Diamonds
		else if(suit =='S') return "\u2660" + value; //Spades
		else return "\u2663" + value; //Clubs
		//each returns Suit and then the value which could be a string.
	}
	
}
