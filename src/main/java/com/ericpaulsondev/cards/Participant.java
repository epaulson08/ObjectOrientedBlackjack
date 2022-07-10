package main.java.com.ericpaulsondev.cards;

public abstract class Participant {

	protected Hand hand;

	private int winCount = 0;
	
	public int getWinCount() {
		return this.winCount;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
