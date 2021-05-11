package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
	}

	public int calculateSum() {
		int sum = 0;
		for (Card c : this.getCards()) {
			sum += c.getValue();
		}
		return sum;
	}
}
