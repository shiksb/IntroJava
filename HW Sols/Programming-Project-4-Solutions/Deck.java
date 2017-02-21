import java.util.Random;
public class Deck {
	
	private Card[] theDeck;
	private int top; // the index of the top of the deck
    private final int DECK_SIZE = 52;
    private final int RESHUFFLE_LIMIT = 12;
	
	public Deck() {
	// make a 52 card deck here
        theDeck = new Card[DECK_SIZE];
        top = 0;
        int count = 0;

        for(int s=0; s<4; s++)
        {
            for(int v=0; v<13; v++)
            {
                theDeck[count] = new Card(s+1, v+1);
                count++;
            }
        }
        shuffle();
	}
	
	// fisher-yates shuffle
	// pick a random position and swap cards with the current one
	public void shuffle() {
        Random r = new Random();
        for(int i = DECK_SIZE - 1; i >=0; i--)
        {
            int pos = r.nextInt(i+1);
            Card temp = theDeck[i];
            theDeck[i] = theDeck[pos];
            theDeck[pos] = temp;
        }
	}

	// deals the top card, shuffles if there are less than 12 cards
	public Card deal() {
		if (top > DECK_SIZE - RESHUFFLE_LIMIT) {
            reset();
        	return deal();
        } else {
            return theDeck[top++];
        }
	}
	
    public void reset()
    {
        top = 0;
        shuffle();
    }
}
