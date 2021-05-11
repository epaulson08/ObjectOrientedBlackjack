package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		this.cards = new ArrayList<>();
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				Card card = new Card(r, s);
				this.cards.add(card);
			}
		}
	}

	public int checkDeckSize() {
		return this.cards.size();
	}

	public Card getCard() {
		return this.cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}