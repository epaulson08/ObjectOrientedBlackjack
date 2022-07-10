package main.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.cards.Dealer;
import main.java.com.ericpaulsondev.cards.Participant;

public class BlackjackDealer extends Dealer implements BlackjackParticipant {

	@Override
	public BlackjackHand dealHand() {
		BlackjackHand blackjackHand = new BlackjackHand();
		blackjackHand.receiveCard(dealCard());
		blackjackHand.receiveCard(dealCard());
		return blackjackHand;
	}

	@Override
	public Participant dealHandTo(Participant participant) {
		participant.setHand(dealHand());
		return participant;
	}

	public void dealHit(BlackjackParticipant participant) {
		participant.getBlackjackHand().receiveCard(this.dealCard());
	}

	public boolean mustHit() {
		if (this.getBlackjackHand().calculateSum() < 17) {
			return true;
		}
		return false;
	}

	@Override
	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand) this.getHand();
	}

	@Override
	public boolean isBusted() {
		if (getBlackjackHand().isBust()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean has21() {
		if (getBlackjackHand().is21()) {
			return true;
		}
		return false;
	}
}
