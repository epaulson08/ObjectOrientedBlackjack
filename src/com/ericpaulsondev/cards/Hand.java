package com.ericpaulsondev.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	private List<Card> cards = new ArrayList<>();

	public Hand() {
	}

	public Hand(List<Card> cards) {
		this.cards = cards;
	}

	public Hand receiveCard(Card card) {
		cards.add(card);
		return this;
	}

	public Hand receiveCards(List<Card> cards) {
		for (Card c : cards)
			cards.add(c);
		return this;
	}

	public List<Card> getCards() {
		return cards;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < cards.size(); i++) {
			sb.append(cards.get(i).toString());
			if (i < cards.size() - 1) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}