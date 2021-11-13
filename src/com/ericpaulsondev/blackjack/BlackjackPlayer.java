package com.ericpaulsondev.blackjack;

import com.ericpaulsondev.cards.Player;

public class BlackjackPlayer extends Player {

	public BlackjackPlayer() {
	}
	
	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand)(this.getHand());
	}
	
}