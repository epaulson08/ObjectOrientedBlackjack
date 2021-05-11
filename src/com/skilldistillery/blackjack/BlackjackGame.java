package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Deck;

public class BlackjackGame {
	private Deck deck;
	private BlackjackDealer dealer;
	private BlackjackPlayer player1;
	private Menu menu;
	private boolean gameKeepsGoing = true;
	private WinStateDecider check;
	private boolean debug = false;

	public BlackjackGame() {
		Menu menu = new Menu();
		this.menu = menu;
	}

	public BlackjackGame(Menu menu) {
		this.menu = menu;
		this.deck = new Deck();
		deck.shuffle();
		dealer = new BlackjackDealer(deck);
		player1 = new BlackjackPlayer();
		check = new WinStateDecider(dealer, player1);
		if (debug) {
			System.out.println("********************************************");
			System.out.println("WARNING: BlackjackGame.java DEBUG MODE IS ON");
			System.out.println("********************************************");
		}
	}

	public void play() {

		turn1();

		if (this.gameKeepsGoing) {
			turn2();
		}

		if (this.gameKeepsGoing) {
			turn3();
		}

		if (this.gameKeepsGoing) {
			turn4();
		}

	}

//////////
	public void turn1() {
		if (debug)
			System.out.println("\nDEBUG: TURN 1\n");

		// Turn 1: Deal to player. If player gets 21, player wins.

		System.out.println("Dealer deals to player: ");
		dealer.dealPlayerHand(player1);

		player1.displayCards();

		menu.pause();

		this.gameKeepsGoing = check.isPlayer1GameOver();
		if (!gameKeepsGoing) {
			check.announceWinner(false); // false is tag to designate not a tie
		}
	}
//////////

//////////	
	public void turn2() {
		if (debug)
			System.out.println("\nDEBUG: TURN 2\n");

		// Turn 2: Deal to dealer. If dealer gets 21, dealer wins.
		// Note the logic is same as Turn 1.
		dealer.dealSelfHand();
		dealer.displayCardsExceptFirst();

		menu.pause();

		this.gameKeepsGoing = check.isDealerGameOver();
		if (!gameKeepsGoing) {
			check.announceWinner(false);
		}
	} // close dealerTurn1()
//////////

//////////
	public void turn3() {
		if (debug)
			System.out.println("DEBUG: TURN 3");

		// Turn 3: Player decides whether to hit.
		boolean playerHits = menu.doesPlayerWantToHit();

		// Turn 3: If player hits:
		while (playerHits) {
			if (debug)
				System.out.println("\nDEBUG: ENTERING TURN 3 while(playerHits)\n");

			dealer.dealHit(player1.getBlackjackHand());

			System.out.println("\n\nYou hit. Your hand now: ");
			player1.displayCards();

			menu.pause();

			this.gameKeepsGoing = check.isPlayer1GameOver();
			if (debug)
				System.out.println("DEBUG: gameKeepsGoing is: " + gameKeepsGoing);

			if (!gameKeepsGoing) {
				check.announceWinner(false);
				break;
			} // exit here if player gets == 21 and wins, or > 21 and loses

			else {
				playerHits = menu.doesPlayerWantToHit();
				// Return to top of while loop if player hits again
				// Exit while loop if player doesn't hit again
			}
		} // close while(playerHits)

		// Player is now done hitting. Possible states:
		// Player == 21 and wins, gameKeepsGoing false
		// Player > 21 and loses, gameKeepsGoing false
		// Player < 21 and < dealer: player loses
		// Player < 21 and > dealer: go on
		// Player < 21 and == dealer: tie unless dealer hits -deal with this in turn 4

		if (gameKeepsGoing) {
			System.out.println("\n\nYou stay. ");
			menu.pause();

			int flag = check.compareHands(); // -1 for dealer > player, 0 tie, 1 dealer < player
			if (flag == 0) {
				check.announceWinner(true); // This logic is a little oversimplified; maybe dealer hits on a tie
			}

			if (flag == -1) {
				dealer.setWinner(true);
				check.announceWinner(false);
				this.gameKeepsGoing = false;
			}
		} // close if

	} // close turn3()
//////////

//////////
	public void turn4() {
		if (debug)
			System.out.println("\nDEBUG: TURN 4\n");

		System.out.println("Dealer reveals cards: ");
		dealer.displayAllCards();
		menu.pause();

		// if dealer must hit:
		while (gameKeepsGoing && dealer.mustHit()) { // i.e. while dealer sum < 17
			if (debug) {
				System.out.println("\nDEBUG: ENTERED TURN 4 WHILE LOOP");
				System.out.println("gameKeepsGoing IS: " + gameKeepsGoing);
				System.out.println("dealer.mustHit() IS: " + dealer.mustHit() + "\n");
			}
			dealer.hitSelf();
			dealer.displayAllCards();
			menu.pause();

			gameKeepsGoing = check.isDealerGameOver(); // check if dealer == 21 or > 21
			if (!gameKeepsGoing)
				check.announceWinner(false);

		} // end while loop
			// if gameKeepsGoing = false: exit loop
			// if gameKeepsGoing = true AND dealer.mustHit() = false: exit loop

		if (debug)
			System.out.println("DEBUG: EXITED TURN 4 while (dealer.mustHit())");

		if (debug)
			System.out.println("DEBUG: dealer.mustHit() is: " + dealer.mustHit());
		if (!dealer.mustHit()) {
			int flag = check.compareHands();
			if (debug)
				System.out.println("DEBUG: int flag = check.compareHands() is: " + check.compareHands());

			if (flag == 0) {
				check.announceWinner(true);
			} else if (flag == 1) {
				player1.setWinner(true);
				check.announceWinner(false);
			} else if (flag == -1 && dealer.getBlackjackHand().calculateSum() <= 21) {
				dealer.setWinner(true);
				check.announceWinner(false);
			} else if (flag == -1 && dealer.getBlackjackHand().calculateSum() > 21) {
				dealer.setLoser(true);
				check.announceWinner(false);
			}
		}
	}// close turn4()
//////////

	public void resetGame() {
		dealer.setLoser(false);
		dealer.setWinner(false);
		player1.setLoser(false);
		player1.setWinner(false);
		this.gameKeepsGoing = true;
	}

	public void setGameKeepsGoing(boolean b) {
		gameKeepsGoing = b;
	}

	public boolean getGameKeepsGoing() {
		return this.gameKeepsGoing;
	}

} // close class