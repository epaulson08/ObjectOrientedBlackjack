package com.skilldistillery.blackjack;

public class WinStateDecider {
	private boolean keepsGoing = false;
	private BlackjackDealer dealer;
	private BlackjackPlayer player1;
//	private BlackjackPlayer player2;
	private boolean debug = false;

	public WinStateDecider() {

	}

	public WinStateDecider(BlackjackDealer dealer, BlackjackPlayer player) {
		if (debug) {
			System.out.println();
			System.out.println("**********************************************");
			System.out.println("WARNING: WinStateDecider.java DEBUG MODE IS ON");
			System.out.println("**********************************************");
			System.out.println();
		}

		this.dealer = dealer;
		this.player1 = player;
	}

	public int compareHands() {
		int flag = 0;
		int dealerSum = (dealer.getBlackjackHand().calculateSum());
		int player1Sum = (player1.getBlackjackHand().calculateSum());

		if (debug) {
			System.out.println("\nDEBUG: dealerSum IS: " + dealerSum);
			System.out.println("DEBUG: player1Sum IS: " + player1Sum + "\n");
		}

		if (dealerSum > player1Sum) {
			flag = -1;
		} else if (dealerSum == player1Sum) {
			flag = 0;
		} else {
			flag = 1;
		}

		if (debug) {
			System.out.println("\nDEBUG: flag IS: " + flag + "\n");
		}
		return flag;
		// flag = -1: dealer > player
		// flag = 0: dealer == player
		// flag = 1: dealer < player
	}

	public boolean isPlayer1GameOver() {

		if (player1.getBlackjackHand().calculateSum() == 21) {
			player1.setWinner(true);
			this.keepsGoing = false;
		} else if (player1.getBlackjackHand().calculateSum() > 21) {
			player1.setLoser(true);
			this.keepsGoing = false;
		} else {
			this.keepsGoing = true;
		}

		return this.keepsGoing;
	}

	public boolean isDealerGameOver() {
		if (dealer.getHand() != null) {
			if (dealer.getBlackjackHand().calculateSum() == 21) {
				dealer.setWinner(true);
				this.keepsGoing = false;
			} else if (dealer.getBlackjackHand().calculateSum() > 21) {
				dealer.setLoser(true);
				this.keepsGoing = false;
			} else
				this.keepsGoing = true;
		}
		return this.keepsGoing;
	}

	public void announceWinner(boolean tieFlag) {
		System.out.println("=====================================");
		System.out.println("G A M E   O V E R\n");
		
		System.out.println("Your hand: ");
		player1.getHand().printCardArtHorizontal();
		player1.getBlackjackHand().showSum();
		System.out.println();
		
		if (dealer.getBlackjackHand() != null) {
			System.out.println("Dealer's hand: ");
			dealer.getHand().printCardArtHorizontal();
			dealer.getBlackjackHand().showSum();
		}
		
		String winner = "";

		if (tieFlag) {
			winner = "It's a tie!!!!!";
		} else {
			if (debug) {
				System.out.println("DEBUG: WinStateDecider.java: announceWinner()");
				System.out.println("dealer.isWinner() = " + dealer.isWinner());
				System.out.println("dealer.isLoser() = " + dealer.isLoser());
				System.out.println("player1.isLoser() = " + player1.isLoser());
				System.out.println("player1.isWinner() = " + player1.isWinner());
				System.out.println();
				
			}
			if (dealer.isWinner()) {
				winner = "DEALER WON!!!!!";
			} else if (player1.isWinner()) {
				winner = "YOU WON!!!!!";
			} else if (player1.isLoser()) {
				winner = "DEALER WON!!!!!";
			} else if (dealer.isLoser()) {
				winner = "YOU WON!!!!!";
			} else {
				if (debug) {
					System.out.println("DEBUG: within announceWinner(): ERROR: SHOULD NOT HAVE REACHED THIS");
				}
			}
		}
		System.out.println();
		System.out.println(winner);
		System.out.println();
		System.out.println();
	}

	public void setDealer(BlackjackDealer dealer) {
		this.dealer = dealer;
	}

	public BlackjackDealer getDealer() {
		return this.dealer;
	}

	public void setPlayer1(BlackjackPlayer player) {
		this.player1 = player;
	}

//	public void setPlayer2(BlackjackPlayer player) {
//		this.player2 = player;
//	}

} // class close
