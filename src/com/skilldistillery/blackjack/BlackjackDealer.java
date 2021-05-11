package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Dealer;
import com.skilldistillery.cards.Deck;

public class BlackjackDealer extends Dealer {
	
	public BlackjackDealer() {
	}

	public BlackjackDealer(Deck deck) {
		this.setDeck(deck);
	}

// begin special behavior
	@Override
	public BlackjackHand dealHand() {
		BlackjackHand blackjackHand = new BlackjackHand();		
		blackjackHand.receiveCard(dealCard());
		blackjackHand.receiveCard(dealCard());
		return blackjackHand;
	}
	
	public void dealHit(BlackjackHand blackjackHand) {
		blackjackHand.receiveCard(this.dealCard());
// TODO: add logic for deck empty?
	}
	
	@Override
	public void dealSelfHand() {
		System.out.println("Dealer deals to self: ");
		this.setHand(this.dealHand()); 
	}
	
	public void displayCardsExceptFirst() {
		this.getHand().showAllButFirstCard();
		this.getBlackjackHand().printCardArtHideFirstCard();
		System.out.println("Sum: (concealed)");
	}
	
	

	public void hitSelf () {
		System.out.println("Dealer hits: ");
		this.getHand().receiveCard(dealCard());
	}

	public boolean mustHit() {
		boolean hitMe = false;
		BlackjackHand currentHand = (BlackjackHand) this.getHand();
		if (currentHand.calculateSum() < 17) {
			hitMe = true;
		} else {
			hitMe = false;
		}

		return hitMe;
	}
	
	public BlackjackHand getBlackjackHand() {
		return (BlackjackHand)(this.getHand());
	}
	
	public void displayAllCards() {
		this.getHand().showAllCards();
		this.getHand().printCardArtHorizontal();
		this.getBlackjackHand().showSum();		
	}
	
//	
	
} // close class

//	public void dealHit(BlackjackHand playerHand) {
//		// TODO adapt logic for deck empty
//		
//			int numCardsRemaining = this.getDeck().checkDeckSize();
//			if (1 > numCardsRemaining) {
//				System.out.println("The deck is out of cards!");
//			}
//			
//			Card dealtCard = null;
//			int sum = 0; //
//			dealtCard = deck.dealCard();
//				sum += dealtCard.getRank().getValue();
//				System.out.println("Dealer dealt a: " + dealtCard.toString());
//			}
//
//		return sum;
//			
//
//		} // close deal()