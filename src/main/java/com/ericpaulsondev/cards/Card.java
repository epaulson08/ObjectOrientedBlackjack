package main.java.com.ericpaulsondev.cards;

public class Card {

    private Rank rank;
    private Suit suit;
    private String displayChar;
    private char symbol;
    private final int TOTAL_DISPLAY_LINES = 5;

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

    public String toPrettyString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (String line : toPrinterLineArray()) {
            sb.append(line);
        }
        sb.append("\n");
        return sb.toString();
    }

    String[] toPrinterLineArray() {
        String[] lines = new String[TOTAL_DISPLAY_LINES];
        lines[0] = "xxxxxxx";
        lines[1] = "x  " + this.getDisplayChar() + "  x";
        lines[2] = "x  " + this.getSymbol() + "  x";
        lines[3] = "x  " + this.getDisplayChar() + "  x";
        lines[4] = "xxxxxxx";
        return lines;
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
