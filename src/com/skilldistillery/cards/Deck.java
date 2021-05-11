package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cardList;

	public Deck() {
		cardList = new ArrayList<>();

		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				Card card = new Card(r, s);
				cardList.add(card);
			} // close inner for-each
		} // close outer for-each
	} // close Deck()

	public int checkDeckSize() {
		return cardList.size();
	}

	public Card getCard() {
		return cardList.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cardList);
	}


} // close class