package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Player;

public class BlackjackPlayer extends Player {

	public BlackjackPlayer() {
	}
	
	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand)(this.getHand());
	}
	
	public void displayCards() {
		this.getHand().showAllCards();
		this.getHand().printCardArtHorizontal();
		this.getBlackjackHand().showSum();		
	}
	
}