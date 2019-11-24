package com.wb.players;

import java.util.Random;

import com.wb.game.GameStats;
import com.wb.game.InputType;

public class ComputerPlayer implements Player {
	String name;
	GameStats gameStats;
	
    private Random random;
    private static int MAX_OPTIONS = InputType.values().length;

	public ComputerPlayer(String name) {
		this.name = name;
		this.random = new Random();
		gameStats = new GameStats();
	}
	
	@Override
	public PlayerType getType() {
		return PlayerType.COMPUTER;
	}

	@Override
	public String getName() {
		return "Computer -" + name;
	}

	@Override
	public InputType getInput() {
		int in = random.nextInt(MAX_OPTIONS);
        InputType input = InputType.valueOf(in);       
		return input;
	}

	@Override
	public GameStats getGameStats() {
		return gameStats;
	}
	
	/*public static void main(String[] args){
		ComputerPlayer hp = new ComputerPlayer("iMac");
		InputType in;
		
		for (int i = 0; i< 5; i++){
			in = hp.getInput();
			System.out.println("You typed:" + in);
		}
	}*/
}