package test.java.com.ericpaulsondev.blackjack;

import main.java.com.ericpaulsondev.blackjack.BlackjackDealer;
import main.java.com.ericpaulsondev.blackjack.BlackjackHand;
import main.java.com.ericpaulsondev.cards.Card;
import main.java.com.ericpaulsondev.cards.Deck;
import main.java.com.ericpaulsondev.cards.Rank;
import main.java.com.ericpaulsondev.cards.Suit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackDealerTest {

    BlackjackDealer dealer;

    @BeforeEach
    void beforeEach() {
        dealer = new BlackjackDealer();
    }

    @AfterEach
    void afterEach() {
        dealer = null;
    }

    @Test
    @DisplayName("Dealer must hit if sum of hand is 16 with two cards")
    void testMustHitSum16TwoCards() {
        List<Card> sum16TwoCards = new ArrayList();
        sum16TwoCards.add(new Card(Rank.NINE, Suit.SPADES));
        sum16TwoCards.add(new Card(Rank.SEVEN, Suit.HEARTS));
        dealer.setHand(new BlackjackHand(sum16TwoCards));
        assertTrue(dealer.mustHit());
    }

    @Test
    @DisplayName("Dealer must hit if sum of hand is 16 with five cards")
    void testMustHitSum16FiveCards() {
        List<Card> sum16FiveCards = new ArrayList();
        sum16FiveCards.add(new Card(Rank.TWO, Suit.SPADES));
        sum16FiveCards.add(new Card(Rank.THREE, Suit.HEARTS));
        sum16FiveCards.add(new Card(Rank.FIVE, Suit.HEARTS));
        sum16FiveCards.add(new Card(Rank.TWO, Suit.CLUBS));
        sum16FiveCards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        dealer.setHand(new BlackjackHand(sum16FiveCards));
        assertTrue(dealer.mustHit());
    }

    @Test
    @DisplayName("Dealer must hit if sum of hand is 4")
    void testMustHit4() {
        List<Card> sum4TwoCards = new ArrayList();
        sum4TwoCards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        sum4TwoCards.add(new Card(Rank.TWO, Suit.CLUBS));
        dealer.setHand(new BlackjackHand(sum4TwoCards));
        assertTrue(dealer.mustHit());
    }

    @Test
    @DisplayName("Dealer must NOT hit if sum of hand is 17")
    void testMustNotHit17() {
        List<Card> sum17Cards = new ArrayList<>();
        sum17Cards.add(new Card(Rank.KING, Suit.SPADES));
        sum17Cards.add(new Card(Rank.SEVEN, Suit.HEARTS));
        dealer.setHand(new BlackjackHand(sum17Cards));
        assertFalse(dealer.mustHit());
    }

    @Test
    @DisplayName("Dealer must NOT hit if sum of hand is 21")
    void testMustNotHit21() {
        List<Card> sum21ThreeCards = new ArrayList<>();
        sum21ThreeCards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        sum21ThreeCards.add(new Card(Rank.SEVEN, Suit.CLUBS));
        sum21ThreeCards.add(new Card(Rank.JACK, Suit.CLUBS));
        dealer.setHand(new BlackjackHand(sum21ThreeCards));
        assertFalse(dealer.mustHit());
    }

    @Test
    @DisplayName("Dealer must NOT hit if sum of hand is 18")
    void testMustNotHit18() {
        List<Card> sum18Cards = new ArrayList<>();
        sum18Cards.add(new Card(Rank.NINE, Suit.DIAMONDS));
        sum18Cards.add(new Card(Rank.NINE, Suit.HEARTS));
        dealer.setHand(new BlackjackHand(sum18Cards));
        assertFalse(dealer.mustHit());
    }

    @Test
    @DisplayName("Dealer must NOT hit if sum of hand is 25")
    void testMustNotHit25() {
        List<Card> sum25Cards = new ArrayList<>();
        sum25Cards.add(new Card(Rank.TEN, Suit.DIAMONDS));
        sum25Cards.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        sum25Cards.add(new Card(Rank.QUEEN, Suit.SPADES));
    }

    @Test
    @DisplayName("dealHand returns two cards")
    void dealHandGivesTwoCards() {
        dealer.makeNewDeck();
        BlackjackHand hand = dealer.dealHand();
        assertEquals(2, hand.size());
    }
}
