package main.java.com.ericpaulsondev.cards;

public abstract class Dealer extends Participant {

	protected Deck deck;

	public Dealer() { }

	public Dealer(Deck deck) {
		this.deck = deck;
	}
	
	public void shuffleDeck() {
		this.deck.shuffle();
	}
	
	public Card dealCard() {
		Card dealtCard = this.deck.getCard();
		return dealtCard;
	}

	public void makeNewDeck() {
		this.deck = new Deck();
	}
	
	public void useDeck(Deck deck) {
		this.deck = deck;
	}
	
	public abstract Hand dealHand();

	public Participant dealHandTo(Participant participant) {
		participant.setHand(dealHand());
		return participant;
	}

}