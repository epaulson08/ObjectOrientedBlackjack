package com.skilldistillery.cards;

import java.util.List;

public class AsciiArt {

	public static void print(Card card) {
		System.out.println();
		for (String line : horizontalize(card))
			System.out.println(line);
		System.out.println();
	}

	public static void print(Hand hand) {
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (Card card : hand.getCards()) {
				String[] lines = horizontalize(card);
				System.out.print(lines[i] + "   ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	public static void print(List<Card> cards) {
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (Card card : cards) {
				String[] lines = horizontalize(card);
				System.out.print(lines[i] + "   ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	
	public static void printHideFirstCard(Hand hand) {
		System.out.println();
		for (int i = 0; i < 5; i++) {
			for (Card card : hand.getCards()) {
				String[] lines = horizontalize(card);
					if (card.equals(hand.getCards().get(0))) {
						System.out.print("xxxxxxx   ");						
					}
					else {						
						System.out.print(lines[i] + "   ");
					}
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	private static String[] horizontalize(Card card) {
		String[] lines = new String[5];
		lines[0] = "xxxxxxx";
		lines[1] = "x  " + card.getDisplayChar() + "  x";
		lines[2] = "x  " + card.getSymbol() + "  x";
		lines[3] = "x  " + card.getDisplayChar() + "  x";
		lines[4] = "xxxxxxx";
		return lines;
	}

}
