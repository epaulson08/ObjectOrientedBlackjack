package main.java.com.ericpaulsondev.cards;

public abstract class Player extends Participant {
	
	public Player() { super(); }

	public Player(Hand hand) {
		this.hand = hand;
	}

}
