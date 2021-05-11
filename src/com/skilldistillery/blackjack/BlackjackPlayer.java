package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Player;

public class BlackjackPlayer extends Player {

	public BlackjackPlayer() {
	}
	
	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand)(this.getHand());
	}
	
}