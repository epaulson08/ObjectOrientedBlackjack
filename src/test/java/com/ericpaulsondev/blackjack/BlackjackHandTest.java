package test.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.blackjack.BlackjackHand;
import main.java.com.ericpaulsondev.cards.Card;
import main.java.com.ericpaulsondev.cards.Rank;
import main.java.com.ericpaulsondev.cards.Suit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackHandTest {

    static String expectedThreeCardsDisplay;
    static String expectedThreeCardsConcealFirstDisplay;

    @BeforeAll
    static void beforeAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("xxxxxxx   xxxxxxx   xxxxxxx   \n");
        sb.append("x  A  x   x  8  x   x  X  x   \n");
        sb.append("x  \u2660  x   x  \u2663  x   x  \u2666  x   \n");
        sb.append("x  A  x   x  8  x   x  X  x   \n");
        sb.append("xxxxxxx   xxxxxxx   xxxxxxx   \n");
        sb.append("\n");
        expectedThreeCardsDisplay = sb.toString();

        sb = new StringBuilder();
        sb.append("\n");
        sb.append("xxxxxxx   xxxxxxx   xxxxxxx   \n");
        sb.append("xxxxxxx   x  8  x   x  X  x   \n");
        sb.append("xxxxxxx   x  \u2663  x   x  \u2666  x   \n");
        sb.append("xxxxxxx   x  8  x   x  X  x   \n");
        sb.append("xxxxxxx   xxxxxxx   xxxxxxx   \n");
        sb.append("\n");
        expectedThreeCardsConcealFirstDisplay = sb.toString();
    }

    @Test
    @DisplayName("Sum of two number cards follows rules of blackjack ")
    void testSumTwoNumberCards() {
        ArrayList<Card> twoNumbersCards = new ArrayList<>();
        twoNumbersCards.add(new Card(Rank.EIGHT, Suit.SPADES));
        twoNumbersCards.add(new Card(Rank.THREE, Suit.HEARTS));
        BlackjackHand twoNumbersHand = new BlackjackHand(twoNumbersCards);

        int expected = 8 + 3;
        int actual = twoNumbersHand.calculateSum();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sum of five number cards follows rules of blackjack ")
    void testSumFiveNumberCards() {
        ArrayList<Card> fiveNumbersCards = new ArrayList<>();
        fiveNumbersCards.add(new Card(Rank.FOUR, Suit.HEARTS));
        fiveNumbersCards.add(new Card(Rank.TWO, Suit.CLUBS));
        fiveNumbersCards.add(new Card(Rank.NINE, Suit.SPADES));
        fiveNumbersCards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        fiveNumbersCards.add(new Card(Rank.THREE, Suit.DIAMONDS));
        BlackjackHand fiveNumbersHand = new BlackjackHand(fiveNumbersCards);

        int expected = 4 + 2 + 9 + 2 + 3;
        int actual = fiveNumbersHand.calculateSum();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sum of three royal cards follows rules of blackjack")
    void testSumThreeRoyalCards() {
        ArrayList<Card> threeRoyalCards = new ArrayList<>();
        threeRoyalCards.add(new Card(Rank.JACK, Suit.HEARTS));
        threeRoyalCards.add(new Card(Rank.JACK, Suit.CLUBS));
        threeRoyalCards.add(new Card(Rank.QUEEN, Suit.SPADES));
        BlackjackHand threeRoyalHand = new BlackjackHand(threeRoyalCards);

        int expected = 10 + 10 + 10;
        int actual = threeRoyalHand.calculateSum();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sum of two mixed cards follows rules of blackjack")
    void testSumTwoMixedCards() {
        ArrayList<Card> twoMixedCards = new ArrayList<>();
        twoMixedCards.add(new Card(Rank.KING, Suit.DIAMONDS));
        twoMixedCards.add(new Card(Rank.TWO, Suit.HEARTS));
        BlackjackHand twoMixedHand = new BlackjackHand(twoMixedCards);

        int expected = 10 + 2;
        int actual = twoMixedHand.calculateSum();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sum with aces follows rules of blackjack, with aces as 11")
    void testSumWithAcesAs11() {
        ArrayList<Card> cardsWithAces = new ArrayList<>();
        cardsWithAces.add(new Card(Rank.ACE, Suit.HEARTS));
        cardsWithAces.add(new Card(Rank.TWO, Suit.SPADES));
        BlackjackHand handWithAces = new BlackjackHand(cardsWithAces);

        int expected = 11 + 2;
        int actual = handWithAces.calculateSum();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Size of a hand increases by 1 after receiving a card")
    void testReceivingOneCardIncrementsSize() {
        BlackjackHand hand1 = new BlackjackHand();
        assertTrue(hand1.getCards().size() == 0);

        hand1.receiveCard(new Card(Rank.EIGHT, Suit.DIAMONDS));
        assertTrue(hand1.getCards().size() == 1);

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.FIVE, Suit.CLUBS));
        BlackjackHand hand2 = new BlackjackHand(cards);
        assertTrue(hand2.getCards().size() == 1);

        hand2.receiveCard(new Card(Rank.ACE, Suit.HEARTS));
        assertTrue(hand2.getCards().size() == 2);
    }

    @Test
    @DisplayName("Hand with three cards displays as expected")
    void testPrettyStringThreeCards() {
        String expected = expectedThreeCardsDisplay;
        String expectedConcealed = expectedThreeCardsConcealFirstDisplay;
        String actual = "";

        ArrayList<Card> threeCards = new ArrayList<>();
        threeCards.add(new Card(Rank.ACE, Suit.SPADES));
        threeCards.add(new Card(Rank.EIGHT, Suit.CLUBS));
        threeCards.add(new Card(Rank.TEN, Suit.DIAMONDS));
        BlackjackHand threeCardsHand = new BlackjackHand(threeCards);

        actual = threeCardsHand.toPrettyString();
        assertEquals(expected, actual);

        actual = threeCardsHand.toPrettyStringHideFirstCard();
        assertEquals(expectedConcealed, actual);
    }
}
