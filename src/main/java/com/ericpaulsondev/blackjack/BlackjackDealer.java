package main.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.cards.Dealer;

public class BlackjackDealer extends Dealer {

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
		this.getHand().receiveCard(dealCard());
	}

	public boolean mustHit() {
		if ((this.getBlackjackHand()).calculateSum() < 17) {
			return true;
		}
		return false;
	}

	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand) this.getHand();
	}
}
