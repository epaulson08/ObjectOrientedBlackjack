package com.skilldistillery.cards;

public abstract class Dealer {

	private Deck deck;
	private boolean winner = false;
	private boolean loser = false;
	private Hand hand;

	public Dealer() {
	}

	public Dealer(Deck deck) {
		this.deck = deck;
	}
	
	public void shuffleDeck() {
		this.deck.shuffle();
	}
	
	public Card dealCard() {
		Card dealtCard = this.deck.getCard();
		return dealtCard;
	}

	public void makeNewDeck() {
		this.deck = new Deck();
	}
	
	public void useDeck(Deck deck) {
		this.deck = deck;
	}
	
	public abstract Hand dealHand();
	
	public void dealHandToPlayer(Player player) {
		player.setHand(dealHand());
	}
	
	public void dealHandToSelf() {
		this.setHand(dealHand());
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

