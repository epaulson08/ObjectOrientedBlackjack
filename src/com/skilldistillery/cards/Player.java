package com.skilldistillery.cards;

public abstract class Player {
	private boolean winner = false;
	private boolean loser = false;
	private Hand hand;
	
	public Player() {}

	public Player(Hand hand) {
		this.hand = hand;
	}
	
// Get/set:
	public boolean isWinner() {
		return winner;
	}
	
	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public boolean isLoser() {
		return loser;
	}

	public void setLoser(boolean loser) {
		this.loser = loser;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
