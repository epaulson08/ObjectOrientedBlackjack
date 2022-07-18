package main.java.com.ericpaulsondev.blackjack;

public class BlackjackApplication {
	
	public static void main(String[] args) {
		new BlackjackApplication().run();
	}

	public void run() {
		UserInterface ui = new UserInterface(System.in);
		BlackjackGame game = new BlackjackGame(ui);
		boolean playAgain = false;

		ui.welcome();
			
		do {
			game.play();
			playAgain = ui.promptPlayAgain();
			game.resetGame();
		} while (playAgain);

		ui.goodbye();
	
	} 
} 
