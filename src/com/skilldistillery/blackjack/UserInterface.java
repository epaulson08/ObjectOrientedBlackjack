package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.AsciiArt;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Rank;
import com.skilldistillery.cards.Suit;

public class UserInterface {
	private Scanner scanner;

	public UserInterface() {
		this.scanner = new Scanner(System.in);
	}

	public void welcome() {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("x              Welcome              x");
		System.out.println("x                 to                x");
		System.out.println("x               BLACKJACK           x");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println();
		AsciiArt.print(makeCardsForWelcomeDisplay());

		pause();
	}

	public void pause() {
		System.out.println("\n(Press ENTER to continue)\n");
		scanner.nextLine();
	}

	public boolean promptHit() {
		System.out.println("Would you like to hit or stay? ");
		System.out.println("1: Hit");
		System.out.println("2: Stay");

		if (validateInput() == 1)
			return true;
		else
			return false;
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

	public void printGameOver() {
		System.out.println("*** GAME OVER ***");
	}

	public void printDealerWins() {
		System.out.println();
		System.out.println();
		System.out.println("Dealer wins!!!!");
		System.out.println();
		System.out.println();
	}

	public void printPlayerWins() {
		System.out.println();
		System.out.println();
		System.out.println("Player wins!!!!");
		System.out.println();
		System.out.println();
	}

	public void goodbye() {
		System.out.println();
		System.out.println();
		System.out.println("Thanks for playing! Goodbye!");
		this.scanner = null;
	}

	public void displayHand(BlackjackHand hand) {
		System.out.println(hand.toString());
		AsciiArt.print(hand);
		printBlackjackSum(hand.calculateSum());
	}

	public void displayHandConcealFirstCard(BlackjackHand hand) {
		System.out.println("(One card is concealed)");
		for (int i = 1; i < hand.getCards().size(); i++) {
			System.out.println(hand.getCards().get(i).toString());
		}
		AsciiArt.printHideFirstCard(hand);
		printBlackjackSum(hand.calculateSum());
	}

	private void printBlackjackSum(int sum) {
		System.out.println("Sum: " + sum);
		System.out.println();
	}

	public void announceWinner(int winner, BlackjackHand playerHand, BlackjackHand dealerHand) {

		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("x              GAME                 x");
		System.out.println("x                                   x");
		System.out.println("x               OVER                x");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println();

		System.out.println("Your hand: ");
		displayHand(playerHand);

		System.out.println();

		if (dealerHand != null) {
			System.out.println("Dealer's hand: ");
			displayHand(dealerHand);
		}

		System.out.println();
		if (winner == 1)
			System.out.println("You won!!!!!!!!!");
		if (winner == 0)
			System.out.println("It's a tie.");
		if (winner == -1)
			System.out.println("Dealer won.");
		System.out.println();
		System.out.println();
	}

	// Helper methods:
	private List<Card> makeCardsForWelcomeDisplay() {
		List<Card> welcomeCards = new ArrayList<>();
		welcomeCards.add(new Card(Rank.ACE, Suit.SPADES));
		welcomeCards.add(new Card(Rank.ACE, Suit.HEARTS));
		welcomeCards.add(new Card(Rank.ACE, Suit.CLUBS));
		welcomeCards.add(new Card(Rank.ACE, Suit.DIAMONDS));
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
					System.out.println("Sorry, I do not recognize that input. Please enter \"1\" or \"2\"");
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
}
