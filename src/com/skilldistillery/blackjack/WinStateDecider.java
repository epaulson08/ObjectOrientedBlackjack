package com.skilldistillery.blackjack;

public class WinStateDecider {

	public WinStateDecider() {
	}

	public int compareHands(BlackjackDealer dealer, BlackjackPlayer player) {
		int flag = 0;
		int dealerSum = (dealer.getBlackjackHand().calculateSum());
		int playerSum = (player.getBlackjackHand().calculateSum());

		if (dealerSum > playerSum) {
			flag = -1;
		} else if (dealerSum == playerSum) {
			flag = 0;
		} else {
			flag = 1;
		}
		return flag;
	}

	public boolean isPlayerGameOver(BlackjackPlayer player) {
		if (player.getBlackjackHand().calculateSum() == 21) {
			player.setWinner(true);
			return true;
		} else if (player.getBlackjackHand().calculateSum() > 21) {
			player.setLoser(true);
			return true;
		} else {
			return false;
		}
	}

	public boolean isDealerGameOver(BlackjackDealer dealer) {
		if (dealer.getHand() != null) {
			if (dealer.getBlackjackHand().calculateSum() == 21) {
				dealer.setWinner(true);
				return true;
			} else if (dealer.getBlackjackHand().calculateSum() > 21) {
				dealer.setLoser(true);
				return true;
			} else
				return false;
		}
		return false;
	}

	public int determineWinner(BlackjackDealer dealer, BlackjackPlayer player) {
		if (dealer.isWinner())
			return -1;
		else if (player.isWinner())
			return 1;
		else if (player.isLoser())
			return -1;
		else if (dealer.isLoser())
			return 1;
		else
			return 0;
	}

}
