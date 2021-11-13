package com.ericpaulsondev.cards;

public abstract class Dealer extends Participant {

	private Deck deck;
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
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
}