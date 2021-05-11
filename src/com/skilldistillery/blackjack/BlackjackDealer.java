package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Dealer;
import com.skilldistillery.cards.Deck;

public class BlackjackDealer extends Dealer {

	private Deck deck;

	public BlackjackDealer() {
		this.deck = new Deck();
	}

	public BlackjackDealer(Deck deck) {
		this.deck = deck;
	}

	@Override
	public BlackjackHand dealHand() {
		BlackjackHand blackjackHand = new BlackjackHand();
		blackjackHand.receiveCard(dealCard());
		blackjackHand.receiveCard(dealCard());
		return blackjackHand;
	}

	public void dealHit(BlackjackHand blackjackHand) {
		blackjackHand.receiveCard(this.dealCard());
	}

	public void hitSelf() {
		System.out.println("Dealer hits: ");
		this.getHand().receiveCard(dealCard());
	}

	public boolean mustHit() {
		if (((BlackjackHand) this.getHand()).calculateSum() < 17)
			return true;
		return false;
	}

	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand) this.getHand();
	}
}
