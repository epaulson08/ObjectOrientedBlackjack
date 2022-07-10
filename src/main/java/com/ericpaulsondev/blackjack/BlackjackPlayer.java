package main.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.cards.Player;

public class BlackjackPlayer extends Player implements BlackjackParticipant {

	@Override
	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand)(this.getHand());
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