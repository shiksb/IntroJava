public class Card {
	
	private int suit; // use integers 1-4 to encode the suit
	private int value; // use integers 1-13 to encode the value
    private int score; // blackjack score
    private final int ACE_LOW = 1;
    private final int ACE_HIGH = 11;
	
	public Card(int s, int v){
	//make a card with suit s and value v
        suit = s;
        value = v;
        if (value == ACE_LOW) {
            score = ACE_HIGH;           // default set aces to high
        } else if (value > 10) {
            score = 10;
        } else {
            score = value;
        }
	}
	
	public String toString(){
		// use this method to easily print a Card object
        String s = "";
        String v = "";
        switch(suit)
        {
            case 1:
                s = "Clubs";
                break;
            case 2:
                s = "Diamonds";
                break;
            case 3:
                s = "Hearts";
                break;
            case 4:
                s = "Spades";
                break;
        }

        switch(value)
        {
            case 1:
                v = "Ace";
                break;
            case 2:
                v = "Two";
                break;
            case 3:
                v = "Three";
                break;
            case 4:
                v = "Four";
                break;
            case 5:
                v = "Five";
                break;
            case 6:
                v = "Six";
                break;
            case 7:
                v = "Seven";
                break;
            case 8:
                v = "Eight";
                break;
            case 9:
                v = "Nine";
                break;
            case 10:
                v = "Ten";
                break;
            case 11:
                v = "Jack";
                break;
            case 12:
                v = "Queen";
                break;
            case 13:
                v = "King";
                break;
        }

        return v +" of "+ s;
    }

    public int getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    // returns blackjack score (jack, queen king have value 10)
    public int getScore()
    {
        return score;
    }

    public void flipAce()
    {
        if (value == 1)
        {
            if (score == 11)
            {
                score = 1;
            }
            else if (score == 1)
            {
                score = 11;
            }
        }
    }

}
