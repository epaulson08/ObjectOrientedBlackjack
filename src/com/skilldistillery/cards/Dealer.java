package com.skilldistillery.cards;

public abstract class Dealer {

	private Deck deck;
	private boolean winner = false;
	private boolean loser = false;
	private Hand hand;

	public Dealer() {
		Deck deck = new Deck();
		deck.shuffle();
	}

	public Dealer(Deck deck) {
		this.deck = deck;
	}

// begin special behavior
	
	public void shuffleDeck() {
		deck.shuffle();
	}
	
	public Card dealCard() {
		Card dealtCard = deck.getCard();
		return dealtCard;
	}

	public void makeNewDeck() {
		deck = new Deck();
	}
	
	public abstract Hand dealHand();
	
	public void dealPlayerHand(Player player) {
		player.setHand(dealHand());
	}
	
	public void dealSelfHand() {
		this.setHand(dealHand());
	}
	
// end special behavior

// begin getters and setters
	public Deck getDeck() {
		return deck;
	}
	
	public void setDeck(Deck deck) {
		this.deck = deck;
	}

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
// end getters and setters
	
} // close class

