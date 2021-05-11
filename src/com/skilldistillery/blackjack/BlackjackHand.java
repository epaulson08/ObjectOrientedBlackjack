package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand {
	// inherits field:
	// List<Card> cardsInHand

	public BlackjackHand() {}
	

// begin special behavior
	public int calculateSum() {
		int sum = 0;
		for (Card c : this.getCardsInHand()) {
			sum += c.getValue();
		}
		return sum;
	}
	
	public void showSum() {
		System.out.println("Sum: " + this.calculateSum());
		System.out.println();

	}
	public void printCardArtHideFirstCard() {
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (Card c : this.getCardsInHand()) {
				String[] lineArray = c.getLinesForCardArt();
					if (c.equals(this.getCardsInHand().get(0))) {
						System.out.print("xxxxxxx   ");						
					}
					else {						
						System.out.print(lineArray[i] + "   ");
					}
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	
// end special behavior
	
} // class close
