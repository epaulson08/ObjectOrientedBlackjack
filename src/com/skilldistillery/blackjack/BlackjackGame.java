package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Participant;

public class BlackjackGame {
	private Participant winner;
	private BlackjackDealer dealer;
	private BlackjackPlayer player;
	private UserInterface ui;
	private boolean gameOver = false;

	public BlackjackGame(UserInterface ui) {
		this.ui = ui;
		dealer = new BlackjackDealer();
		player = new BlackjackPlayer();
	}

	public void play() {

		turn1();

		if (!gameOver)
			turn2();

		if (!gameOver)
			turn3();

		if (!gameOver)
			turn4();

	}

	public void turn1() {
		dealer.makeNewDeck();
		dealer.shuffleDeck();

		System.out.println("Dealer deals to player: ");
		dealer.dealHandToPlayer(player);

		ui.displayHand(player.getBlackjackHand());
		ui.pause();

		gameOver = turn1CheckWinState();
	}

	public void turn2() {
		System.out.println("Dealer deals to self:");
		dealer.dealHandToSelf();

		ui.displayHandConcealFirstCard(dealer.getBlackjackHand());
		ui.pause();

		gameOver = turn2CheckWinState();
	}

	public void turn3() {
		boolean playerHits = false;

		do {
			playerHits = ui.promptHit();

			if (playerHits) {
				dealer.dealHit(player.getBlackjackHand());
				System.out.println("\n\nYou hit. Your hand now: ");
				ui.displayHand(player.getBlackjackHand());
				ui.pause();
				if (player.getBlackjackHand().calculateSum() > 21) {
					turn3PlayerBusts();
					break;
				}
			} else {
				System.out.println("You stay.");
				ui.pause();
			}

		} while (playerHits);

		gameOver = turn3CheckWinState();
	}

	public void turn4() {

		System.out.println("Dealer reveals cards: ");
		ui.displayHand(dealer.getBlackjackHand());
		ui.pause();

		while (true) {
			if (dealer.mustHit()) {
				dealer.hitSelf();
				ui.displayHand(dealer.getBlackjackHand());
				ui.pause();

				if (dealer.getBlackjackHand().calculateSum() > 21) {
					turn4DealerBusts();
					return;
				}

			} else {
				winner = compareHands(dealer, player);
				ui.announceWinner(winner, dealer, player);
				return;
			}
		}
	}

	public void resetGame() {
		gameOver = false;
		winner = null;
	}

	// Win check logic
	private boolean turn1CheckWinState() {
		if (player.getBlackjackHand().calculateSum() == 21) {
			winner = player;
			ui.announceWinner(winner, dealer, player);
			return true;
		}
		return false;
	}

	private boolean turn2CheckWinState() {
		if (dealer.getBlackjackHand().calculateSum() == 21) {
			winner = dealer;
			ui.announceWinner(winner, dealer, player);
			return true;
		}
		return false;
	}

	private void turn3PlayerBusts() {
		System.out.println("You bust!!");
		ui.pause();
		winner = dealer;
		ui.announceWinner(winner, dealer, player);
	}

	private boolean turn3CheckWinState() {
		if (player.getBlackjackHand().calculateSum() == 21) {
			winner = player;
			ui.announceWinner(winner, dealer, player);
			return true;
		} else if (dealer.getBlackjackHand().calculateSum() > player.getBlackjackHand().calculateSum()) {
			winner = dealer;
			ui.announceWinner(winner, dealer, player);
			return true;
		} else {
			return false;
		}
	}

	private void turn4DealerBusts() {
		System.out.println("Dealer busts!!");
		ui.pause();
		winner = player;
		ui.announceWinner(winner, dealer, player);
	}

	private Participant compareHands(BlackjackDealer dealer, BlackjackPlayer player) {
		int dealerSum = (dealer.getBlackjackHand().calculateSum());
		int playerSum = (player.getBlackjackHand().calculateSum());

		if (dealerSum > playerSum)
			return dealer;
		else if (dealerSum == playerSum)
			return null;
		else
			return player;
	}

}
