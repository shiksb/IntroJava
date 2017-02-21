import java.util.ArrayList;

public class Player {

	private double balance;
	ArrayList<Card> hand;
	private final int INIT_SIZE = 2;
	private final int BLACKJACK = 21;
	private final int ACE = 1;

	// construct player with inital balance of 0
	public Player() {
		balance = 0;
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

	// check if the player has a blackjack, a score of 21 with only two cards
	public boolean hasBlackjack() {
		return (getScore() == BLACKJACK && hand.size() == INIT_SIZE);
	}

	// get the aces from the hand
	public ArrayList<Card> getAces() {
		ArrayList<Card> aces = new ArrayList<Card>();
		for (Card c : hand) {
			if (c.getValue() == ACE) {
				aces.add(c);
			}
		}
		return aces;
	}

	// get the player's balance
	public double getBalance() {
		return balance;
	}

	// normal win
	public void win(int bet) {
		balance += bet;
	}

	// normal loss
	public void lose(int bet) {
		balance -= bet;
	}

	// blackjack win
	public void blackjackWin(int bet) {
		balance += bet * 1.5;
	}
}