package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApplication {
	public static void main(String[] args) {
		BlackjackApplication app = new BlackjackApplication();
		app.run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu(scanner);
		BlackjackGame game = new BlackjackGame(menu);
		boolean playAgain = false;

		menu.welcome();
		menu.pause();
			
		do {
			game.play();
			playAgain = menu.doesUserWantToPlayAgain();
			game.resetGame();
		} while (playAgain);

		menu.goodbye();
		scanner.close();
	} 

} 
