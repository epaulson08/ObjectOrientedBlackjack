package main.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.cards.Card;
import main.java.com.ericpaulsondev.cards.Hand;

import java.util.List;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
	}

	public BlackjackHand(List<Card> cards) {
		super(cards);
	}

	public int calculateSum() {
		int sum = 0;
		for (Card c : this.getCards()) {
			sum += c.getValue();
		}
		return sum;
	}

	public boolean isBust() {
		return calculateSum() > 21;
	}

	public boolean is21() {
		return calculateSum() == 21;
	}

}
