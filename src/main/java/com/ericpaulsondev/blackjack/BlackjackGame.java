package main.java.com.ericpaulsondev.blackjack;

public class BlackjackGame {
    private BlackjackParticipant winner;
    private BlackjackDealer dealer;
    private BlackjackPlayer player;
    private UserInterface ui;
    private boolean gameOver = false;

    public BlackjackGame() {
    }

    public BlackjackGame(UserInterface ui) {
        this.ui = ui;
        dealer = new BlackjackDealer();
        player = new BlackjackPlayer();
    }

    public void play() {

        dealToPlayer();

        if (!gameOver) {
            dealToDealer();
        }

        if (!gameOver) {
            letPlayerHit();
        }

        if (!gameOver) {
            checkHands();
        }

        if (!gameOver) {
            letDealerHit();
        }

        if (!gameOver) {
            finishGame();
        }
    }

    public void resetGame() {
        gameOver = false;
        winner = null;
        dealer.setHand(null);
        player.setHand(null);
    }

    private void dealToPlayer() {
        dealer.makeNewDeck();
        dealer.shuffleDeck();

        ui.dealerDealsToPlayer();
        dealer.dealHandTo(player);

        ui.displayHand(player);
        ui.pause();

        if (player.has21()) {
            playerWins();
        }
    }

    private void dealToDealer() {
        ui.dealerDealsToSelf();
        dealer.dealHandTo(dealer);

        ui.displayHandConcealFirstCard(dealer);
        ui.pause();

        if (dealer.has21()) {
            dealerWins();
        }
    }

    private void letPlayerHit() {
        while (true) {

            boolean playerHits = ui.promptHit();

            if (!playerHits) {
                ui.youStay();
                ui.pause();
                return;
            }

            dealer.dealHit(player);

            ui.youHit();
            ui.displayHand(player);
            ui.pause();

            if (player.isBusted()) {
                playerBusts();
                return;
            }

            if (player.has21()) {
                playerWins();
                return;
            }
        }
    }

    private void checkHands() {
        if (dealerHasHigherSum()) {
            dealerWins();
        }
    }

    private boolean dealerHasHigherSum() {
        if (getParticipantWithHigherSum(dealer, player).equals(dealer)) {
            return true;
        }
        return false;
    }

    private void letDealerHit() {
        ui.dealerRevealsCards();
        ui.displayHand(dealer);
        ui.pause();

        while (dealer.mustHit()) {
            ui.dealerHits();
            dealer.dealHit(dealer);

            ui.displayHand(dealer);
            ui.pause();

            if (dealer.isBusted()) {
                dealerBusts();
                return;
            }
        }
    }

    private void finishGame() {
        gameOver = true;
        winner = getParticipantWithHigherSum(dealer, player);

        ui.announceWinner(winner, dealer, player);
    }

    private void playerBusts() {
        gameOver = true;
        winner = dealer;

        ui.youBust();
        ui.pause();
        ui.announceWinner(winner, dealer, player);
    }

    private void dealerBusts() {
        gameOver = true;
        winner = player;

        ui.dealerBusts();
        ui.pause();
        ui.announceWinner(winner, dealer, player);
    }

    private void playerWins() {
        gameOver = true;
        winner = player;

        ui.announceWinner(winner, dealer, player);
    }

    private void dealerWins() {
        gameOver = true;
        winner = dealer;

        ui.announceWinner(winner, dealer, player);
    }

    private BlackjackParticipant getParticipantWithHigherSum(BlackjackParticipant p1, BlackjackParticipant p2) {
        int p1Sum = p1.getBlackjackHand().calculateSum();
        int p2Sum = p2.getBlackjackHand().calculateSum();

        if (p2Sum > p1Sum) {
            return p2;
        }
        if (p1Sum > p2Sum) {
            return p1;
        }
        return null;
    }

}