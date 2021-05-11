package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> cardsInHand = new ArrayList<>();

	public Hand() {
	}

// start special behavior
	public void showAllButFirstCard() {
		System.out.println("(One card is concealed)");
		for (int i = 1; i < cardsInHand.size(); i++) {
			System.out.println(cardsInHand.get(i).toString());
		}
	}

	public void showAllCards() {
		for (Card c : cardsInHand) {
			System.out.println(c.toString());
		}
	}

	public void receiveCard(Card c) {
		cardsInHand.add(c);
	}

	public void printCardArtHorizontal() {
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (Card c : cardsInHand) {
				String[] lineArray = c.getLinesForCardArt();
					System.out.print(lineArray[i] + "   ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

// end special behavior	

// begin getters and setters
	public List<Card> getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(List<Card> cardsInHand) {
		this.cardsInHand = getCardsInHand();
	}
// end getters and setters

} // close class