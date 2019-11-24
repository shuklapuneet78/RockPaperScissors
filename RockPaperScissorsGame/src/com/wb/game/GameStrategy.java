package com.wb.game;

public class GameStrategy {

	public static GameResult findResult (InputType inputPlayer1,  InputType inputPlayer2){
		GameResult result ;
		if (inputPlayer1 == null || inputPlayer2 == null){
			throw new IllegalArgumentException("Inputs received are invalid. inputPlayer1:" + inputPlayer2 + ", inputPlayer2:" + inputPlayer2);
		}
		
		if(inputPlayer1 == inputPlayer2){
			result = GameResult.TIE;
		} else {
			result = 
				(inputPlayer1 == InputType.R  && inputPlayer2 == InputType.S) ||
				(inputPlayer1 == InputType.P  && inputPlayer2 == InputType.R) ||
				(inputPlayer1 == InputType.S  && inputPlayer2 == InputType.P) ?
					GameResult.PLAYER1_WINS : GameResult.PLAYER2_WINS;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(findResult(InputType.R, InputType.R).getResult());
		System.out.println(findResult(InputType.R, InputType.S).getResult());
		System.out.println(findResult(InputType.R, InputType.P).getResult());
	}
}
