package com.wb.game;

public enum GameResult {
	TIE ("Its a Tie!"), 
	PLAYER1_WINS ("Player 1 Wins!!"), 
	PLAYER2_WINS ("Player 2 Wins!!");
	
	String result;
	
	private GameResult(String result) {
		this.result = result;
	}
	
	public String getResult(){
		return result;
	}
}
