package main.java.com.ericpaulsondev.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

    private final int TOTAL_DISPLAY_LINES = 5;

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public Hand receiveCard(Card card) {
        cards.add(card);
        return this;
    }

    public Hand receiveCards(List<Card> cards) {
        for (Card c : cards) {
            cards.add(c);
        }
        return this;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toPrettyString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < TOTAL_DISPLAY_LINES; i++) {
            for (Card card : cards) {
                String[] lines = card.toPrinterLineArray();
                sb.append(lines[i] + "   ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String toPrettyStringHideFirstCard() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < TOTAL_DISPLAY_LINES; i++) {
            for (Card card : cards) {
                String[] lines = card.toPrinterLineArray();
                if (card.equals(cards.get(0))) {
                    sb.append("xxxxxxx   ");
                } else {
                    sb.append(lines[i] + "   ");
                }
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public String toStringHideFirstCard() {
        StringBuilder sb = new StringBuilder("(First card is concealed)\n");
        int handSize = cards.size();

        if (handSize <= 1) {
            return sb.toString();
        }

        for (int i = 1; i < handSize; i++) {
            sb.append(this.cards.get(1).toString());
            if (i < handSize - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i).toString());
            if (i < cards.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}