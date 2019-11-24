package com.wb.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameStrategyTest {

	// Tie Cases
	@Test
	public void testTieFindResultWithRock() {
		assertEquals(GameResult.TIE, GameStrategy.findResult(InputType.R, InputType.R));
	}

	@Test
	public void testTieFindResultWithScissors() {
		assertEquals(GameResult.TIE, GameStrategy.findResult(InputType.S, InputType.S));
	}
	
	@Test
	public void testTieFindResultWithPaper() {
		assertEquals(GameResult.TIE, GameStrategy.findResult(InputType.P, InputType.P));
	}

	// Player 1 - winning Cases
	
	@Test
	public void testPlayer1WinFindResultWithRock() {
		assertEquals(GameResult.PLAYER1_WINS, GameStrategy.findResult(InputType.R, InputType.S));
	}

	@Test
	public void testPlayer1WinFindResultWithScissors() {
		assertEquals(GameResult.PLAYER1_WINS, GameStrategy.findResult(InputType.S, InputType.P));
	}
	
	@Test
	public void testPlayer1WinFindResultWithPaper() {
		assertEquals(GameResult.PLAYER1_WINS, GameStrategy.findResult(InputType.P, InputType.R));
	}
	
	// Player 2 - winning Cases
	
	@Test
	public void testPlayer2WinFindResultWithRock() {
		assertEquals(GameResult.PLAYER2_WINS, GameStrategy.findResult(InputType.R, InputType.P));
	}

	@Test
	public void testPlayer2WinFindResultWithScissors() {
		assertEquals(GameResult.PLAYER2_WINS, GameStrategy.findResult(InputType.S, InputType.R));
	}
	
	@Test
	public void testPlayer2WinFindResultWithPaper() {
		assertEquals(GameResult.PLAYER2_WINS, GameStrategy.findResult(InputType.P, InputType.S));
	}
	
	// Invalid Inputs
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidInputToFindResult() {
		assertEquals(GameResult.PLAYER2_WINS, GameStrategy.findResult(null, InputType.S));
	}
	
}