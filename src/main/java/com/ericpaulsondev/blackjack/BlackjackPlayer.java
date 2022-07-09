package main.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.cards.Player;

public class BlackjackPlayer extends Player {

	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand)(this.getHand());
	}
	
}