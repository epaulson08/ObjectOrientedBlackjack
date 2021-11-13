package com.ericpaulsondev.cards;

public class Card {
	
	private Rank rank;
	private Suit suit;
	private String displayChar;
	private char symbol;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.displayChar = rank.getDisplayChar();
		this.suit = suit;
		this.symbol = suit.getSymbol();
	}
	
	public int getValue() {
		return rank.getValue();
	}
	
	public Rank getRank() {
		return rank;
	}
	
	public String getDisplayChar() {
		return this.displayChar;
	}
	
	public char getSymbol() {
		return this.symbol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank);
		builder.append(" of ");
		builder.append(suit);
		return builder.toString();
	}

}
