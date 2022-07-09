package main.java.com.ericpaulsondev.cards;

public abstract class Player extends Participant {
	private Hand hand;
	
	public Player() {}

	public Player(Hand hand) {
		this.hand = hand;
	}
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
