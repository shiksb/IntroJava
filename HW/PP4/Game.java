//------------------------------------------------------//
//Author: Shikhar Bakhda
//UNI: ssb2189
//Game.java
//This class contains the user interface for the game
//------------------------------------------------------//

import java.util.*; //to include the Scanner and Math class

public class Game{


	//Defining the Player, Dealer, and Deck objects
	private Player player;
	private Dealer dealer;
	private Deck deck;

	Scanner input = new Scanner(System.in); //For scanning inputs


	//This constructor initialises the objects and gets the buy-in
	public Game() {

		//Welcome message
		System.out.println("\n\tWelcome to the game of Blackjack!" 
			+ "I'm your dealer today.");

		//This while loop takes a valid buy-in amount from the user
		int buyIn;
		while(true){
	    	System.out.print("\nWhat's your buy-in? $");
	   		buyIn = input.nextInt();
	   		if(buyIn < 100) //Buy-in must be greater than $100
	   			System.out.println("You must buy-in at least $100.");
	   		else {
	   			break;
	   		}
    	}

    	//Initialising the objects
    	dealer = new Dealer();
    	player = new Player(buyIn); //buy-in passed as an argument
    	deck = new Deck();
	}
	

	//This method has the general gameplay:
	//1. Get new deck if cards < 12
	//2. Place bet
	//3. Get outcome from hand
	//4. Conduct transactions based on outcome and bet
	//5. Prompt for new hand/Quit if insufficient funds
	public void play() {

		//This while loop quits either when the user chooses to quit
					//or the user doesn't have enough balance 
		while(true) {

			//If the deck has less than 12 cards, create a new deck object
			if(52 - (deck.cardIndex + 1) < 12)
				deck.shuffle();

			//Placing bet
			System.out.print("\n\n\t-----Place Bet-----");
			System.out.print("\nYour balance is: $" + player.balance);
			//Getting a bet that the player can afford and is <=10 and <=1000
			int bet = 0;
			while(true) {
				if(bet >= 10 && bet <= 1000) {
					if((player.balance - bet) >= 0)
						break;
					else
						System.out.print("You can only bet" 
							+ "up to $" + player.balance + "\n");
				}
				else
					System.out.print("\nPlace your bet between $10 " 
						+ "and $1000: $");
				bet = input.nextInt();
			}
			System.out.print("You have bet $" + bet);
			System.out.print("\n\t-------------------\n");


			//Getting an outcome from a new hand
			String outcome = newHand();

			//Using the outcome of the game and bet to update player's balance
			settleEarnings(outcome, bet);

			//Prompting for the next hand and quitting if balance < $10
			if(player.balance >= 10) { //prompt if balance >= $10
				System.out.println("\n\nDo you want to play the " 
					+ "next hand? \n1. Yes\t2. No");
				int choice = input.nextInt();
				//if player plays new hand initialise player and dealer again
				if(choice == 1){ 
					dealer = new Dealer();
					//old balance passed into the new player object
					player = new Player(player.balance); 
				}
				else {
					System.out.println("\nThanks for playing!\n");
					break;
				}
			}
			else { 
				//Quit game if balance < $10
				System.out.println("\n\nGame over. Your balance" 
					+ " is below $10 :(\n");
				break;
			}

		}
	}


	//This method simulates a hand
	// 1. Distributing 2 cards
	// 2. Check for natural blackjacks
	// 3. Player's turn till he stands/ quit if gets busted
	// 4. Dealer's turn till he stands/ quits if gets busted
	// 5. If none are busted, comparing sums and returning outcome
	private String newHand() {

		//Dealing cards, the right way player-dealer-player-dealer lol
		player.pickCard(deck);
	    dealer.pickCard(deck);

		player.pickCard(deck);
	    dealer.pickCard(deck);

	    //Check if both have a natural blackjack
	    if(player.getSum() == 21 && dealer.getSum() == 21){
	    	return "Push"; //return Push as outcome
	    }
	    //Check if player has a natural blackjack
	   	else if (player.getSum() == 21){
	   		return "PlayerBlackjack"; //return "PlayerBlackjack" as outcome
	   	}
	    //Check if dealer has a natural blackjack
	   	else if (dealer.getSum() == 21){
	   		return "DealerBlackjack"; //return "DealerBlackjack" as outcome
	   	}

	   	//Player's turn
		System.out.print("\n\n\t-----Your Turn-----");
		int choice;
		//Using do-while loop ensures at least one execution
		do {
			//Displaying details of the player's game
			System.out.print("\nYour cards are: " + player.getCards());
			System.out.print("\nDealer's top card: " 
									+ dealer.getCards().substring(0,2));
			System.out.print("\nYour best sum is: " + player.getSum());

			//This while loop takes a valid choice '1' or '2' from the user
			while (true) {
				System.out.println("\nChoose your next move."
					+ " Enter 1 or 2: \n1. Hit\t2. Stand");
				choice = input.nextInt();
				if(choice == 1 || choice == 2)
					break;
				else
					System.out.println("Enter a valid choice.");
			}

			//Picking a card if choice is 'hit'
			if(choice == 1)
				player.pickCard(deck);

			//Checking if player is busted. If yes, while loop breaks
			if(player.getSum() > 21){
				System.out.println("\nYou got busted!");
				System.out.println("Your cards were: " + player.getCards());
				System.out.println("Your best sum was: " + player.getSum());
				System.out.print("\t-------------------\n");
				return "Dealer"; //Returning the outcome as 'Dealer'
			}
		//loop goes indefinitely till player busts or chooses to stand
		} while (choice != 2); 
		System.out.print("\t-------------------\n");


		//Dealer's turn 
		System.out.print("\n\n\t---Dealer's Turn---");
		String decision;
		//Using do-while loop ensures at least one execution
		do {	
			//Displaying the dealer's moves
			System.out.print("\nDealer's cards are: " + dealer.getCards());
			System.out.print("\nDealer's best sum is: " + dealer.getSum());
			//Getting the dealer's decision
			decision = dealer.myDecision();

			//Picking a card if choice is 'hit'
			if(decision == "hit"){
				dealer.pickCard(deck);
			}

			//Printing dealer's decision
			System.out.println("\nThe dealer chose to " + decision);
			
			//Checking if dealer is busted. If yes, while loop breaks
			if(dealer.getSum() > 21){ 
				System.out.println("\nDealer got busted!");
				System.out.println("Dealer's cards were: "+ dealer.getCards());
				System.out.println("Dealer's best sum was: "+ dealer.getSum());
				System.out.print("\t-------------------\n");
				return "Player"; //Returning the outcome as 'Player'
			}
		//loop goes indefinitely till dealer busts or chooses to stand
		} while (decision != "stand");
		System.out.print("\t-------------------\n");

		//If no one's busted, we reach here and compare sums
		if(dealer.getSum() > player.getSum()){
			return "Dealer";//return outcome as 'Dealer' if his sum is greater
		}
		if(player.getSum() > dealer.getSum()){
			return "Player";//return outcome as 'Player' if his sum is greater
		}
		else{
			return "Push";//return 'Push' if both have the same sum
		}
	}


	//Settling the earnings/losses of the player
	//1. Print hand summary 
	//2. Printing the winner 
	//3. Calculating changes to player's account balance
	//4. Printing new balance
	private void settleEarnings(String whoWon, int bet) {

		//Displaying hand summary 
		System.out.print("\n\n\t---Hand Summary---\n");
		System.out.println("Your cards were: " + player.getCards());
		System.out.println("Your best sum was: " + player.getSum());
		System.out.println("Dealer's cards were: " + dealer.getCards());
		System.out.println("Dealer's best sum was: " + dealer.getSum());
		System.out.print("\t------------------\n");

		//Displaying outcome of game
		System.out.print("\n\n\t---Game Outcome---");
		System.out.print("\nYour old balance was $" + player.balance);
		System.out.println("\nYou had bet $" + bet);

		//Deciding what to do based on whoWon
		switch(whoWon) {
			case "Player": {
				System.out.println("\nCongratulations! You won this hand!");
				player.balance += bet; //Player wins bet if he wins
			} break;

			case "Dealer": {
				System.out.println("\nAww... you lost this hand.");
				player.balance -= bet; //Player loses bet if he loses
			} break;

			case "PlayerBlackjack": {
	   			System.out.println("\nWoohoo! You had a blackjack!");
	   			//Player wins 1.5*bet if player gets blackjack
				player.balance += 1.5*bet; //rounding floats
			} break;

			case "DealerBlackjack": {
	   			System.out.println("\nUnlucky :( Dealer had a blackjack.");
	   			//Player loses his bet if dealer gets blackjack
				player.balance -= bet; //rounding floats
			} break;

			case "Push":	
				//nothing happens if the outcome was a push
				System.out.println("\nThis hand was a push.");
			break;
		}
		System.out.print("\nYour new balance is therfore $" + player.balance);
		System.out.print("\n\t------------------\n");
	} 
	    
}
	



