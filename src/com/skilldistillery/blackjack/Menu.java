package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;
import com.skilldistillery.cards.Rank;
import com.skilldistillery.cards.Suit;

public class Menu {
	private Scanner scanner;

	public Menu() {
	}

	public Menu(Scanner scanner) {
		this.scanner = scanner;
	}

	public void welcome() {
		Hand welcomeDisplayHand = new BlackjackHand();
		Card c1 = new Card(Rank.ACE, Suit.SPADES);
		Card c2 = new Card(Rank.ACE, Suit.HEARTS);
		Card c3 = new Card(Rank.ACE, Suit.CLUBS);
		Card c4 = new Card(Rank.ACE, Suit.DIAMONDS);
		welcomeDisplayHand.receiveCard(c1);
		welcomeDisplayHand.receiveCard(c2);
		welcomeDisplayHand.receiveCard(c3);
		welcomeDisplayHand.receiveCard(c4);
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("x              Welcome              x");
		System.out.println("x                 to                x");
		System.out.println("x               BLACKJACK           x");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println();
		welcomeDisplayHand.printCardArtHorizontal();
		
		c1 = null;
		c2 = null;
		c3 = null;
		c4 = null;
		welcomeDisplayHand = null;
	}

///

///

	public boolean doesPlayerWantToHit() {
		int choice = 0;
		boolean hit = false;

		System.out.println("Would you like to hit or stay? ");
		System.out.println("1: Hit");
		System.out.println("2: Stay");

		boolean invalidInput = false;
		boolean keepGoing = true;

		while (keepGoing) {
			do {
				try {
					System.out.print(">>> ");
					choice = scanner.nextInt();
					invalidInput = false;
				} catch (NumberFormatException nfe) {
					System.out.println("Sorry, I do not recognize that input. Please enter \"1\" or \"2\".");
					invalidInput = true;
				} catch (InputMismatchException ime) {
					System.out.println("Sorry, I do not recognize that input. Please enter \"1\" or \"2\"");
					invalidInput = true;
				} finally {
					scanner.nextLine(); // flush buffer
				}

			} while (invalidInput);

			switch (choice) {
			case 1:
				hit = true;
				keepGoing = false;
				break;
			case 2:
				hit = false;
				keepGoing = false;
				break;
			default:
				System.out.println("That was not one of the choices. Please enter 1 or 2.");
				keepGoing = true;
				break;
			}
		}

		return hit;

	} // close hitOrStay()

	public boolean doesUserWantToPlayAgain() {
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
	} // close doesPlayerWantToPlayAgain()

	public void gameOverMessage() {
		System.out.println("G A M E   O V E R");
	}
	public void dealerWinsMessage() {
		System.out.println();
		System.out.println();
		System.out.println("Dealer wins!!!!");
		System.out.println();
		System.out.println();
	}

	public void playerWinsMessage() {
		System.out.println();
		System.out.println();
		System.out.println("Player wins!!!!");
		System.out.println();
		System.out.println();
	}

	public void pause() {
		System.out.println("\n(Press ENTER to continue)\n");
		scanner.nextLine();
	}

	public void goodbye() {
		System.out.println();
		System.out.println();
		System.out.println("Thanks for playing! Goodbye!");
	}
}
