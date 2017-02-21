import java.util.Scanner;

public class Game {

	private Player player;
	private Dealer dealer;
	private Deck deck;
	private Scanner input;
	private final int MIN_BALANCE = 10;
	private final int BUST = 22;
	private final int ACE_LOW = 1;
	private final int ACE_HIGH = 11;

	public Game() {
		player = new Player();
		dealer = new Dealer();
		deck = new Deck();
		input = new Scanner(System.in);
	}

	// play the game!
	public void play() {
		System.out.println("Note: Please write 1/0 for yes/no questions.");
		doBuyIn();

		int playAgain = 1;
		while (playAgain == 1) {
			System.out.println("Your balance is: " + player.getBalance());
			int bet = getPlayerBet();
			playHand(bet);

			if (player.getBalance() < MIN_BALANCE) {
				System.out.println("You're out of money!");
				playAgain = 0;
			}
			else {
				System.out.println("Play again?");
				playAgain = input.nextInt();
			}
		}
	}

	// ask the player for their buy-in amount
	public void doBuyIn() {
		int buyIn = 0;
		while (buyIn < 100) {
			System.out.println("How much are you buying-in for? Min is $100.");
			buyIn = input.nextInt();
		}
		player.win(buyIn);
	}

	// ask they player how much they want to bet
	public int getPlayerBet() {
		int bet = 0;
		while (bet < 10 || bet > 1000 || bet > player.getBalance()) {
			System.out.println("How much to bet? Min is $10, max $1000.");
			bet = input.nextInt();
		}
		return bet;
	}

	// play one hand of the game
	// deal two cards to dealer and player
	public void playHand(int bet) {
		player.clearHand();
		player.addCard(deck.deal());
		player.addCard(deck.deal());
		dealer.clearHand();
		dealer.addCard(deck.deal());
		dealer.addCard(deck.deal());

		System.out.println("Your cards are: " + player.getHandString());
		System.out.println("The dealer's top card is: " + dealer.getTopCard());

		playerHit();

		if (player.getScore() >= BUST) {
			System.out.println("You bust! Too bad.");
			player.lose(bet);
			return;
		}

		System.out.println("The dealer's hand is: " + dealer.getHandString());

		dealerHit();

		checkResults(bet);
	}

	// ask the player if they want to hit
	// print out their cards
	// on each hit, ask the player what score they want their aces to be
	public void playerHit() {
		int takeHit = 1;
		while (takeHit == 1 && player.getScore() < BUST) {
			System.out.println("Do you want to hit?");
			takeHit = input.nextInt();
			if (takeHit == 1) {
				player.addCard(deck.deal());
			}
			System.out.println("Your cards are: " + player.getHandString());
			for (Card c : player.getAces()) {
				System.out.println("Your " + c + " has score " + c.getScore());
				System.out.println("Would you like to flip it?");
				int flipAce = input.nextInt();
				if (flipAce == 1)
				{
					c.flipAce();
				}
			}
		}
	}

	// make the dealer hit and print out their hand
	// set all the dealer's aces to value 11
	// dealer will flip his aces to value 1 in an effort not to bust
	public void dealerHit() {
		for (Card c : dealer.getAces()) {
			if (c.getScore() == ACE_LOW)
			{
				c.flipAce();
			}
		}

		while (dealer.takeHit())
		{
			System.out.println("The dealer hits.");
			dealer.addCard(deck.deal());
			System.out.println("The dealer's hand is: " 
											+ dealer.getHandString());
		}

		for (Card c : dealer.getAces()) {
			int flipAce = 0;
			if (dealer.getScore() < BUST - ACE_HIGH) {
				flipAce = 1;
			}
			if (flipAce == 1)
			{
				c.flipAce();
			}
		}
	}

	// check to see the results of the hand
	// player wins 1x in normal win, 1.5x in a blackjack
	// loses their bet in a loss, and loses nothing in a tie.
	public void checkResults(int bet) {
		if (dealer.getScore() >= BUST) {
			if (player.hasBlackjack()) {
				System.out.println("Dealer busts. Blackjack! You win!");
				player.blackjackWin(bet);
			}
			else {
				System.out.println("Dealer busts. You win!");
				player.win(bet);
			}
		} else if (player.getScore() > dealer.getScore()) {
			if (player.hasBlackjack()) {
				System.out.println("Blackjack! You win!");
				player.blackjackWin(bet);
			}
		} else if (player.getScore() < dealer.getScore()) { 
			System.out.println("Dealer wins...");
			player.lose(bet);
		} else if (player.getScore() == dealer.getScore()) {
			System.out.println("That's a tie.");
		}
	}
}