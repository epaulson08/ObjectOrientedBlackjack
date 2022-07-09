package main.java.com.ericpaulsondev.cards;

public enum Suit {
  HEARTS("Hearts", '\u2665'), SPADES("Spades", '\u2660'), CLUBS("Clubs", '\u2663'), DIAMONDS("Diamonds", '\u2666');
  private String name;
  private char symbol;

  Suit(String name, char symbol) {
    this.name = name;
    this.symbol = symbol;
  }
  
  public char getSymbol() {
	  return symbol;
  }
  
  @Override
  public String toString() {
    return name;
  }
}