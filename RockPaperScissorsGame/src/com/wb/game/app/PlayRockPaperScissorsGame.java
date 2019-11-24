package com.wb.game.app;

import java.util.Scanner;

import com.wb.game.GameResult;
import com.wb.game.GameStrategy;
import com.wb.game.InputType;
import com.wb.players.Player;
import com.wb.players.PlayerFactory;
import com.wb.players.PlayerType;

public class PlayRockPaperScissorsGame {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Welcome to Rock-Paper-Scissors Game!!");
		// Number of Rounds To Play
		System.out.print("Please Enter Number of Rounds You Want To Play: ");
		int numberOfRounds = scanner.nextInt();
		
		// Choose Name
		System.out.print("Please Choose a Name: ");
		String playerName = scanner.next();
		
		// Choose Opponent
		System.out.print("Please Choose Opponent Type:\n1 - Human\n2 - Computer");
		int opponent = scanner.nextInt();

		String player2Name = "RandomComp";
		if (opponent == 1){
			// Choose Opponents Name
			System.out.print("Please Choose a Name: ");
			player2Name = scanner.next();
		}
		
		// Create Players
		Player player1 = PlayerFactory.getPlayer(PlayerType.HUMAN, playerName);
		Player player2 = PlayerFactory.getPlayer(
				opponent == 1 ? PlayerType.HUMAN : PlayerType.COMPUTER, player2Name);
		
		// Set initial Stats
		player1.getGameStats().setTotalPlayed(numberOfRounds);
		player2.getGameStats().setTotalPlayed(numberOfRounds);
				
		InputType inputPlayer1;
		InputType inputPlayer2;
		
		// Play in loop till a given count
		int count = 0;
		while (count < numberOfRounds)
		{
			// Fetch ser Inputs
			inputPlayer1 = player1.getInput();
			inputPlayer2 = player2.getInput();
			
			// Pass inputs to algo to get the winner
			GameResult result = GameStrategy.findResult(inputPlayer1, inputPlayer2);

			// Update Stats
			updateStatsFromResult(result, player1, player2);

			count++;
		}
		// Output the result 
		printResult(player1, player2);
	}
	
	private static void printResult (Player...players){
		System.out.println();
		System.out.println("Printing Results:");
		for(Player player : players) {
			System.out.println(player.getName() + ": " + player.getGameStats());
		}
	}
	
	private static void updateStatsFromResult(GameResult result, Player player1, Player player2){
		switch (result){
			case TIE:
				player1.getGameStats().incrementTies();
				player2.getGameStats().incrementTies();
				break;
				
			case PLAYER1_WINS:
				player1.getGameStats().incrementWins();
				player2.getGameStats().incrementLosses();
				break;
				
			case PLAYER2_WINS:
				player1.getGameStats().incrementLosses();
				player2.getGameStats().incrementWins();
				break;
				
			default:
				throw new IllegalArgumentException("Invalid Input recieved: " + result);
		}
	}
}
