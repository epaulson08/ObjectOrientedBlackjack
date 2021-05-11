package com.skilldistillery.blackjack;

public class BlackjackGame {
	private BlackjackDealer dealer;
	private BlackjackPlayer player;
	private UserInterface ui;
	private boolean gameKeepsGoing = true;
	private WinStateDecider check;

	public BlackjackGame(UserInterface ui) {
		this.ui = ui;
		dealer = new BlackjackDealer();
		player = new BlackjackPlayer();
		check = new WinStateDecider();
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

	public void turn1() {
		dealer.makeNewDeck();
		dealer.shuffleDeck();
		
		System.out.println("Dealer deals to player: ");
		dealer.dealHandToPlayer(player);

		ui.displayHand(player.getBlackjackHand());
		ui.pause();

		gameKeepsGoing = !check.isPlayerGameOver(player);
		if (!gameKeepsGoing) {

		}
	}

	public void turn2() {
		System.out.println("Dealer deals to self:");
		dealer.dealHandToSelf();

		ui.displayHandConcealFirstCard(dealer.getBlackjackHand());
		ui.pause();

		gameKeepsGoing = !check.isDealerGameOver(dealer);
		if (!gameKeepsGoing) {
			endGame();
		}
	}

	public void turn3() {
		boolean playerHits = true;
		
		while (playerHits) {
			playerHits = ui.promptHit();

			dealer.dealHit(player.getBlackjackHand());

			System.out.println("\n\nYou hit. Your hand now: ");
			ui.displayHand(player.getBlackjackHand());
			ui.pause();

			this.gameKeepsGoing = !check.isPlayerGameOver(player);

			if (!gameKeepsGoing) {
				endGame();
				return;
			} else {
				playerHits = ui.promptHit();
			}
		}

		System.out.println("\n\nYou stay. ");
		ui.pause();

		int flag = check.compareHands(dealer, player); // -1 for dealer > player, 0 tie, 1 dealer < player
		if (flag == 0) {
			ui.announceWinner(0, player.getBlackjackHand(), dealer.getBlackjackHand());
			this.gameKeepsGoing = false;
		}
		if (flag == -1) {
			ui.announceWinner(-1, player.getBlackjackHand(), dealer.getBlackjackHand());
			this.gameKeepsGoing = false;
		}
	}

	public void turn4() {

		System.out.println("Dealer reveals cards: ");

		ui.displayHand(dealer.getBlackjackHand());
		ui.pause();

		while (gameKeepsGoing && dealer.mustHit()) {
			dealer.hitSelf();

			ui.displayHand(dealer.getBlackjackHand());
			ui.pause();

			gameKeepsGoing = check.isDealerGameOver(dealer);
			if (!gameKeepsGoing)
				endGame();
		}

		if (!dealer.mustHit()) {
			int largerHand = check.compareHands(dealer, player);
			if (largerHand == -1) {
				if (dealer.getBlackjackHand().calculateSum() <= 21) {
					ui.announceWinner(-1, player.getBlackjackHand(), dealer.getBlackjackHand());
				} else {
					ui.announceWinner(1, player.getBlackjackHand(), dealer.getBlackjackHand());
				}
			} else {
				ui.announceWinner(largerHand, player.getBlackjackHand(), dealer.getBlackjackHand());
			}
		}
		
	}

	private void endGame() {
		int winnerFlag = check.determineWinner(dealer, player);
		ui.announceWinner(winnerFlag, player.getBlackjackHand(), dealer.getBlackjackHand());
	}

	public void resetGame() {
		dealer.setLoser(false);
		dealer.setWinner(false);
		player.setLoser(false);
		player.setWinner(false);
		this.gameKeepsGoing = true;
	}

}