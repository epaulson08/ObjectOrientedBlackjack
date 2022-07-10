package main.java.com.ericpaulsondev.blackjack;

public interface BlackjackParticipant {

    BlackjackHand getBlackjackHand();
    boolean isBusted();
    boolean has21();

}
