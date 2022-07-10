package test.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.blackjack.BlackjackDealer;
import main.java.com.ericpaulsondev.blackjack.BlackjackHand;
import main.java.com.ericpaulsondev.blackjack.BlackjackPlayer;
import main.java.com.ericpaulsondev.cards.Card;
import main.java.com.ericpaulsondev.cards.Rank;
import main.java.com.ericpaulsondev.cards.Suit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackjackParticipantTest {
    BlackjackDealer dealer;
    BlackjackPlayer player;

    @BeforeEach
    void beforeEach() {
        dealer = new BlackjackDealer();
        player = new BlackjackPlayer();
    }

    @AfterEach
    void afterEach() {
        dealer = null;
        player = null;
    }

    @Test
    @DisplayName("Participant isBusted when sum is 22")
    void testIsBusted22() {
        List<Card> sum22 = new ArrayList();
        sum22.add(new Card(Rank.NINE, Suit.CLUBS));
        sum22.add(new Card(Rank.SEVEN, Suit.HEARTS));
        sum22.add(new Card(Rank.SIX, Suit.HEARTS));
        dealer.setHand(new BlackjackHand(sum22));
        player.setHand(new BlackjackHand(sum22));
        assertTrue(dealer.isBusted());
        assertTrue(player.isBusted());
    }

    @Test
    @DisplayName("Participant is not busted when sum is 21")
    void testIsBusted21() {
        List<Card> sum21 = new ArrayList();
        sum21.add(new Card(Rank.NINE, Suit.HEARTS));
        sum21.add(new Card(Rank.NINE, Suit.CLUBS));
        sum21.add(new Card(Rank.THREE, Suit.SPADES));
        dealer.setHand(new BlackjackHand(sum21));
        player.setHand(new BlackjackHand(sum21));
        assertFalse(dealer.isBusted());
        assertFalse(player.isBusted());
    }

    @Test
    @DisplayName("Participant is not busted when sum is 8")
    void testIsBusted8() {
        List<Card> sum8 = new ArrayList();
        sum8.add(new Card(Rank.FOUR, Suit.SPADES));
        sum8.add(new Card(Rank.FOUR, Suit.CLUBS));
        dealer.setHand(new BlackjackHand(sum8));
        player.setHand(new BlackjackHand(sum8));
        assertFalse(dealer.isBusted());
        assertFalse(player.isBusted());
    }

    @Test
    @DisplayName("Participant has21 when sum is 21")
    void testHas21When21() {
        List<Card> sum21 = new ArrayList();
        sum21.add(new Card(Rank.ACE, Suit.SPADES));
        sum21.add(new Card(Rank.KING, Suit.CLUBS));
        dealer.setHand(new BlackjackHand(sum21));
        player.setHand(new BlackjackHand(sum21));
        assertTrue(dealer.has21());
        assertTrue(player.has21());
    }

    @Test
    @DisplayName("Participant !has21 when sum is 28")
    void testHas21When28() {
        List<Card> sum28 = new ArrayList();
        sum28.add(new Card(Rank.TEN, Suit.SPADES));
        sum28.add(new Card(Rank.JACK, Suit.SPADES));
        sum28.add(new Card(Rank.EIGHT, Suit.CLUBS));
        dealer.setHand(new BlackjackHand(sum28));
        player.setHand(new BlackjackHand(sum28));
        assertFalse(dealer.has21());
        assertFalse(player.has21());
    }

    @Test
    @DisplayName("Participant !has21 when sum is 5")
    void testHas21When5() {
        List<Card> sum5 = new ArrayList();
        sum5.add(new Card(Rank.THREE, Suit.HEARTS));
        sum5.add(new Card(Rank.TWO, Suit.CLUBS));
        dealer.setHand(new BlackjackHand(sum5));
        player.setHand(new BlackjackHand(sum5));
        assertFalse(dealer.has21());
        assertFalse(player.has21());
    }

}
