package com.skilldistillery.blackjack.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.skilldistillery.blackjack.BlackjackGame;
import com.skilldistillery.blackjack.Menu;

public class BlackjackGameTest {
private BlackjackGame game;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
		@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		game = new BlackjackGame();
	}

	@After
	public void tearDown() throws Exception {
		game = null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
}