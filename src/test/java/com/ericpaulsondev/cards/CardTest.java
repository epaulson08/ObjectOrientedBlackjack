package test.java.com.ericpaulsondev.cards;

import main.java.com.ericpaulsondev.cards.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CardTest {

    private List<Card> allCards;
    private Card aceOfSpades;

    @BeforeEach
    void setUp() {
        allCards = new Deck().getCards();
        aceOfSpades = new Card(Rank.ACE, Suit.SPADES);
    }

    @AfterEach
    void tearDown() {
        allCards = null;
        aceOfSpades = null;
    }

    @Test
    @DisplayName("toPrettyString returns non-null value for all cards")
    void testPrettyStringReturnsNotNull() {
        for (Card card : allCards) {
            assertFalse(card.toPrettyString() == null);
        }
    }

    @Test
    @DisplayName("toPrettyString does not return empty string for all cards")
    void testPrettyStringReturnsNotEmptyString() {
        for (Card card : allCards) {
            assertFalse(card.toPrettyString().equals(""));
        }
    }

    @Test
    @DisplayName("Ace of Spades prettified display is as expected")
    void testPrettyStringReturnsAceOfSpades() {
        String expected = "", actual = "";

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("xxxxxxx");
        sb.append("x  A  x");
        sb.append("x  \u2660  x");
        sb.append("x  A  x");
        sb.append("xxxxxxx");
        sb.append("\n");

        expected = sb.toString();
        actual = aceOfSpades.toPrettyString();

        assertEquals(expected, actual);
    }

}
