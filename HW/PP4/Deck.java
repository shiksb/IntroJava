//------------------------------------------------------//
//Author: Shikhar Bakhda
//UNI: ssb2189
//Deck.java
//This program defines a class Deck that contains 
//an array of 52 objects of class Card. When initialised,
//it automatically shuffles itself to provide a random
//deck. 
//------------------------------------------------------//

import java.util.*; //to include Math.random()

public class Deck{

	//Defining the instance variables cardIndex and deck
	public int cardIndex; //contains the deck's topmost card's index
	public Card[] deck = new Card[52]; //deck is an array of 52 card objects

	//This constructor sets the cardIndex to 0 and 
		//generates an ordered pack of cards
	public Deck() {
		cardIndex = 0; 

		//Populating 'deck' with an ordered set of 52 cards
		for(int card=0; card<52; card++){
			//(card%13 + 1) yields the value and (card/13 + 1) yeilds suite
			deck[card] = new Card((card % 13) + 1, (card / 13) + 1); 
		}

		//Shuffle the deck
		shuffle();
	}

	//This function shuffles the deck
	public void shuffle(){
		
		//Resetting cardIndex to 0 since it has no meaning after the deck is shuffled
		cardIndex = 0; 

		//Shuffling the deck by making 1000 quick card swaps
		for(int i=0; i<1000; i++) {
			//randomCard1 stores the index of a random card
			int randomCard1 = (int) (Math.random() * 52); 
			//Card tempCard temporarily stores the card at randomCard1
			Card tempCard = deck[randomCard1]; 
			//randomCard2 stores the index of a random card
			int randomCard2 = (int) (Math.random() * 52); 
			//swapping the cards using the tempCard object
			deck[randomCard1] = deck[randomCard2]; 
			deck[randomCard2] = tempCard;
		}
	}

}