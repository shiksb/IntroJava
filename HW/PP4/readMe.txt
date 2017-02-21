Name: Shikhar Bakhda
UNI: ssb2189

Files:
1. Card.java
2. Deck.java
3. Player.java
4. Dealer.java
5. Game.java
6. Tester.java

Class Card
	
	This class is designed to hold card attributes.

		It has 2 instance variables:

			1. public int value: contains the card value, which is from 1 through 13
			2. public int shape: contains the card shape, which is from 1 through 4

		It has 1 constructor and 1 method:

			1. public Card(int val, int shp)
			2. public String printCard()

	Explanations:

	1. public Card(int val, int shp)

		This constructor initialises the instance variables whenever a card object is created. 

	2. public String printCard()

		This method prints out the card in an easy-to-read manner. The shape is printed as an actual shape using UNICODE characters, and the face value of the card (which, for example, for 11 is 'J', for 13 is 'K' etc). Since it can be called on any card it is useful in displaying the card to the user

Class Deck

	This class is designed to simulate a deck of 52 cards.

		It has 2 instance variables:

			1. int cardIndex: contains the index of the below array, the topmost card in the deck
			2. Card[] deck = new Card[52]: contains an array of 52 Card objects

		It has 1 constructor and 1 method:

			1. public Deck()
			2. pubilc void shuffle()

	Explanations: 

		This constructor does the following tasks:
			1. Initialising cardIndex
			cardIndex is set to 0, which points to the first card in the array deck

			2. Creating an ordered deck
			I used a simple for loop to do this. If card took values from 0 to 51 inclusive, card % 13 + 1 would return numbers from 1 to 14 four times, and card / 13 + 1 would return shapes from 1 to 4 thirteen times. This can be used to easily initialise the card with its value and shape

		pubilc void shuffle()

			To shuffle the deck, I swaped two random cards in the deck a thousand times. 1000 was an arbitrary number but seemed high enough to me since when I tested it the deck was almost random. To do this I save 2 random indices from 0 to 52 and swap the Card objects in those indices of the deck. 

Class Player

	This class contains variables and functions that a player will need while playing blackjack.

		It has 3 instance variables:

			1. private int handIndex: contains the index of the below array, the topmost card in the hand
			2. private Card[] hand = new Card[12]: contains an array of 12 Card objects
			The max size is 12 since that's the maximum cards you can have before getting busted: A, A, A, A, 2, 2, 2, 2, 3, 3, 3 and the next card surely busts you.
			3. public float balance: contains the money left in the player's balance. It is float since it might have to handle decimal values. 

		It has 1 constructor and 3 methods:

			1. public Player(int amt)
			2. public void pickCard(Deck deck)
			3. public int getSum()
			4. public String getCards()

		Explanations:

		1. public Player(int amt)
		This constructor initialises the player's balance with the amount amt provided by the user. It also initialises the handIndex as 0.

		2. public void pickCard(Deck deck)
		This method adds a card from the deck to the hand. The topmost card in the deck is referenced by cardIndex which points to a Card object in the deck array in class Deck. To access this Card object, we equalise hand[handIndex] with deck.deck[deck.cardIndex] so that hand[handIndex] now contains the topmost card in the deck. Now, we simply increment cardIndex and handIndex by 1 each so that they point to the next object in the array, which will be filled the next time. 

		3. public int getSum()
		This method returns the optimum sum of the cards in the player's hands. To find this sum, first sum is initialised to 0. Then the cards in hand[] are summed, except cases where the Card.value is greater than 10. When this is the case, the card is a face card and so 10 is summed. Ace is initially taken as 1 and summed. Next, we consider the aces. If an Ace in the hand was the value 11, and if after being 11 if the sum is still less than or equal to 21, then we could get closer to 21 by taking the Ace as 11. If this is the case then we just add 10 to the sum. This is beacuse we counted ace as 1 earlier and now adding 10 will make it the value 11. The sum is returned. 

		4. public String getCards()
		This method simply returns a string of all the cards in the hand. It is convenient to call this method while revealing the hand of the dealer to the player and printing the player's hand after every turn. It simply iterates through the hand[] array and prints cards using the Card.printCard() method in Card.java. 

Class Dealer

	This class simulates the game of a dealer based on the rules given by Prof Cannon. 

		It has 2 instance variables: 

			1. private int handIndex: contains the index of the below array, the topmost card in the hand
			2. private Card[] hand = new Card[12]: contains an array of 12 Card objects

		It has 1 constructor and 4 methods:

			1. public Dealer(int amt)
			2. public String myDecision()
			3. public void pickCard(Deck deck)
			4. public int getSum()
			5. public String getCards()

		Explanation: 

		1. public Dealer(int amt)
		This constructor initialises the handIndex as 0.

		2. public String myDecision()
		This method makes the dealer's decisions. It returns 'hit' if the sum of the dealer's cards is 16 or below and returns 'stand' if the sum of the dealer's cards is 17 or above. To find the sum, we simply use the getSum() function. 

		All methods from 3 - 5 inslusive are repeated word to word, (except comments), in the Player class, thus saving me the trouble of explanation. 

Class Game

	This class contains the flow of the game and menu-diven user interface that makes the game fun and smooth for the user. 

		It has 3 instance variables: 

			1. private Player player: contains the player object for the game
			2. private Dealer dealer: contains the dealer object for the game
			3. private Deck deck: contains the deck object for the game

		It has 1 constructor and 3 methods:

			1. public Game()
			2. public void play()
			3. private String newHand()
			4. private void settleEarnings(String whoWon, int bet)

		Explanation:

		1. public Game()
		This constructor warmly welcomes the user and then prompts for the buy-in, which must be at least $100. After it saves the valid input, it initialises the instance variables, instantiating the deck object, the dealer object, and the player object. The amount bought-in is passed as a parameter to the player object.

		2. public void play()
		This contains the main flow of the game. The flow goes as follows:

			1. Get new deck if cards < 12
			This is done by creating a new deck object. Doing this again makes the array to be randomly recreated. 

			2. Place bet
			The user is asked to enter a valid bet, one that is at least as much as his current balance and one that is between $10 and $1000. Till the bet is valid, the user keeps getting prompted. 

			3. Get outcome from hand
			At this point the method newHand() is called and the outcome of that hand is saved in a String outcome. To see the flow of newHand() check the newHand explanation. 

			4. Conduct transactions based on outcome and bet
			The outcome and player's bet are passed into the function settleEarnings(String whoWon, int bet) that processes changes to the account based on the outcome of the hand. 

			5. Prompt for new hand/Quit if insufficient funds
			The user is prompted to play a new hand if he has sufficient balance. If he chooses to not play the next hand, or if he has insufficient funds, the game quits automatically. But if he does choose to play the next hand, then the loop starts all over agin and steps 1-5 are repeated till he loses the game or patience. 

		3. private String newHand()
		This method simulates a hand and returns the outcome of that hand. The flow goes as follows:

			1. Distributing 2 cards
			Two cards are given to the dealer and player each using the player.pickCard(deck) method. 

			2. Check for natural blackjacks
			If player has a natural blackjack, "PlayerBlackjack" is returned. 
			If dealer has a natural blackjack, "DealerBlackjack" is returned. 
			If both have a natural blackjack, "Push" is returned. 

			3. Player's turn till he stands/ quit if gets busted
			The player can 'hit' as many times as he likes, and each time a new card will be added to his hand using the player.pickCard(deck) method. The player's hand is checked for a bust every time he picks a card. Upon getting busted, "Dealer" is returned. If he stands, it's the dealer's chance.  

			4. Dealer's turn till he stands/ quits if gets busted
			The dealer 'hits' according to the makeDecision() function, and each time a new card will be added to his hand using the dealer.pickCard(deck) method. The dealer's hand is checked for a bust every time he picks a card. Upon getting busted, "Player" is returned. If the makeDecision() method returns 'stand', go to the next step. 

			5. If none are busted, comparing sums and returning outcome
			Sums are compared and the person with the greater one is returned. 


		4. private void settleEarnings(String whoWon, int bet)
		This method updates the player's balance after a hand. These are the all possible outcomes and their consequences:
				"Player": player wins, balance = balance + bet
				"Dealer": dealer wins, balance = balance - bet
				"PlayerBlackjack": player gets blackjack, balance = balance + 1.5*bet
				"DealerBlackjack": dealer gets blackjack, balance = balance + 1.5*bet
				"Push": a tie, nothing happens.
		It also displays a nice hand summary so that you can see what happened in the game and verify that your balance is correctly evalutated based on the correct outcome of the game. 

Tester.java

		The tester simply tests the game by creating a Game object in main() and then calling game.play(). 