package com.ericpaulsondev.blackjack;

import com.ericpaulsondev.cards.Card;
import com.ericpaulsondev.cards.Hand;

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
