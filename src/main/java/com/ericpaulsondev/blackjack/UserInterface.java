package main.java.com.ericpaulsondev.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import main.java.com.ericpaulsondev.cards.*;

public class UserInterface {
	private Scanner scanner;

	public UserInterface() {
		this.scanner = new Scanner(System.in);
	}

	public void welcome() {
		println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		println("x              Welcome              x");
		println("x                 to                x");
		println("x               BLACKJACK           x");
		println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		println();
		println(makeCardsForWelcomeDisplay().toPrettyString());
		pause();
	}

	public void pause() {
		println("\n(Press ENTER to continue)\n");
		scanner.nextLine();
	}

	public boolean promptHit() {
		println("Would you like to hit or stay?");
		println("1: Hit");
		println("2: Stay");

		if (validateInput() == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean promptPlayAgain() {
		boolean playAgain = false;

		System.out.print("Great game! Want to play another round? (Y/N) >>> ");
		String answer = scanner.nextLine();
		switch (answer) {
		case "Y":
		case "y":
		case "Yes":
		case "yes":
		case "yeah":
		case "yep":
		case "hit me":
		case "HIT ME!":
		case "Hit Me":
			playAgain = true;
			break;
		default:
			playAgain = false;
			break;
		}
		return playAgain;
	}

	public void goodbye() {
		println();
		println();
		println("Thanks for playing! Goodbye!");
		this.scanner = null;
	}

	public void displayHand(BlackjackHand hand) {
		println(hand.toString());
		println(hand.toPrettyString());
		println("Sum: " + hand.calculateSum() + "\n");
	}

	public void displayHandConcealFirstCard(BlackjackHand hand) {
		println("(One card is concealed)");
		hand.toString();
		hand.toPrettyStringHideFirstCard();
		println("Sum: (concealed)");
	}

	public void announceWinner(Participant winner, BlackjackDealer dealer, BlackjackPlayer player) {
		println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		println("x              GAME                 x");
		println("x                                   x");
		println("x               OVER                x");
		println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		println();

		println("Your hand: ");
		displayHand(player.getBlackjackHand());

		println();

		if (dealer.getBlackjackHand() != null) {
			println("Dealer's hand: ");
			displayHand(dealer.getBlackjackHand());
		}

		println();
		if (winner == null) {
			println("It's a tie.");
		}

		if (winner != null) {
			if (winner.equals(player)) {
				println("You won!!!!!!!!!");
			}
			if (winner.equals(dealer)) {
				println("Dealer won.");
			}
		}
		println("\n");
	}

	// Helper methods:
	private Hand makeCardsForWelcomeDisplay() {
		BlackjackHand welcomeCards = new BlackjackHand();
		welcomeCards.receiveCard(new Card(Rank.ACE, Suit.SPADES));
		welcomeCards.receiveCard(new Card(Rank.ACE, Suit.HEARTS));
		welcomeCards.receiveCard(new Card(Rank.ACE, Suit.CLUBS));
		welcomeCards.receiveCard(new Card(Rank.ACE, Suit.DIAMONDS));
		return welcomeCards;
	}

	private int validateInput() {
		boolean invalidInput = false;
		boolean keepGoing = true;
		int input = -1;

		while (keepGoing) {
			do {
				try {
					System.out.print(">>> ");
					input = scanner.nextInt();
					invalidInput = false;
				} catch (NumberFormatException nfe) {
					System.out.println("Sorry, I do not recognize that input. Please enter \"1\" or \"2\".");
					invalidInput = true;
				} catch (InputMismatchException ime) {
					System.out.println("Sorry, I do not recognize that input. Please enter \"1\" or \"2\".");
					invalidInput = true;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					scanner.nextLine(); // flush buffer
				}
			} while (invalidInput);

			switch (input) {
			case 1:
			case 2:
				keepGoing = false;
				break;
			default:
				System.out.println("That was not one of the choices. Please enter 1 or 2.");
				keepGoing = true;
				break;
			}
		}
		return input;
	}

	private void println() {
		System.out.println();
	}

	private void println(String msg) {
		System.out.println(msg);
	}

}
