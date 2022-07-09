package main.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.cards.Dealer;
import main.java.com.ericpaulsondev.cards.Deck;

public class BlackjackDealer extends Dealer {

	private Deck deck;

	public BlackjackDealer() {
		this.deck = new Deck();
	}

	public BlackjackDealer(Deck deck) {
		super(deck);
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
		if ((this.getBlackjackHand()).calculateSum() < 17) {
			return true;
		}
		else {
			return false;
		}
	}

	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand) this.getHand();
	}
}
