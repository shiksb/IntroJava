//------------------------------------------------------//
//Author: Shikhar Bakhda
//UNI: ssb2189
//Player.java
//This class simulates the Player.
//------------------------------------------------------//

public class Player{ 

	//Defining the private instance variables
	private int handIndex; //contains the index of the last card in hand[]
	private Card[] hand = new Card[12]; //'hand' as an array of card objects

	//Defining the public instance variable balance
	public float balance; //This maintains the balance $$ from hand to hand


	//This constructor initialises the handIndex and balance to 0
	public Player(float amt) {
		handIndex = 0; //handIndex is initialised to 0 on object instantiation
		balance = amt; //The constructor initialises the balance
	}


	//This method appends the the topmost card of the deck into player's hand
	public void pickCard(Deck deck) {
		// new card from the deck copied into hand. 
		hand[handIndex] = deck.deck[deck.cardIndex]; 
		//incrementing cardIndex of the deck to update topmost card position
		deck.cardIndex++; 
		//incrementing handIndex of the hand to update last card's position
		handIndex++; 
	}


	//This method returns the optimum sum of the hand
	public int getSum() {
		//Summing cards treating aces as 1 and face cards as 10
		int sum = 0;
		for(int i = 0; i < handIndex; i++) {
			if(hand[i].value >= 11){ //Summing the value 10 for face cards
				sum += 10;
			}
			else{
				sum += hand[i].value; //Otherwise summing the card value
			}
		}

		//Special checking for value of ace
		for(int i = 0; i < handIndex; i++){
			if(hand[i].value == 1) { //Check if a card is an Ace
				//check if Ace = 11 gets you closer to 21 without busting
				if((sum+10) <= 21){ 
					sum += 10; //adding 10 makes value of ace go from 1 to 11
				}
			}
		}
		return sum; //return the optimum sum
	}


	//This method prints the hand using the printCard() method of class Card
	public String getCards() {
		String cards = ""; //initialising the string as a blank string
		for(int i = 0; i < handIndex; i++){
			cards += hand[i].printCard(); //appending each card in the hand
		}
		return cards; //returning the string of cards in the hand
	}


}