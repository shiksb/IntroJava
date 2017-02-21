import java.util.ArrayList;

public class Dealer {

	ArrayList<Card> hand;
	private final int ACE = 1;

	public Dealer() {
		hand = new ArrayList<Card>();
	}

	// remove all cards from hand
	public void clearHand() {
		hand.clear();
	}

	// add a card to the hand
	public void addCard(Card c) {
		hand.add(c);
	}

	// get the top card to show it
	public Card getTopCard() {
		return hand.get(0);
	}

	// get the aces from hand
	public ArrayList<Card> getAces() {
		ArrayList<Card> aces = new ArrayList<Card>();
		for (Card c : hand) {
			if (c.getValue() == ACE) {
				aces.add(c);
			}
		}
		return aces;
	}

	// returns the hand as a nice string
	public String getHandString() {
		String s = "";
		for (Card c : hand) {
			s += c.toString() + " ";
		}
		return s;
	}

	// get the score of the hand
	public int getScore() {
		int score = 0;
		for (Card c : hand) {
			score += c.getScore();
		}
		return score;
	}

	// choose to take a hit or not
	public boolean takeHit() {
		if (getScore() > 17)
			return false;
		else
			return true;
	}


}