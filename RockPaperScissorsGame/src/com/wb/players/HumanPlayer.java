package com.wb.players;

import java.util.Scanner;

import com.wb.game.GameStats;
import com.wb.game.InputType;

public class HumanPlayer implements Player {
	String name;
	Scanner scanner;
	GameStats gameStats;

	public HumanPlayer(String name) {
		this.name = name;
		this.scanner = new Scanner(System.in);
		gameStats = new GameStats();
	}
	
	@Override
	public PlayerType getType() {
		return PlayerType.HUMAN;
	}

	@Override
	public String getName() {
		return "Person - " + name;
	}

	@Override
	public InputType getInput() {
		return ask();
	}
	
	private InputType ask(){
		String in;
		boolean isValidInput = false;
		InputType input = null;
		
		do {
			System.out.print("Please Enter Inputs: " + InputType.displayOptions());
			try {
			in = scanner.next();
			if (null != in && !"".equals(in)) {
				input = InputType.valueOf(in.toUpperCase());
				isValidInput = true;
				}
			} catch (IllegalArgumentException iaEx){
				System.out.println("Invalid Input. Please Retry!!");
			}
		} while (!isValidInput);
		
		return input; 
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		scanner.close();
	}

	@Override
	public GameStats getGameStats() {
		return gameStats;
	}
	
	/*public static void main(String[] args){
		HumanPlayer hp = new HumanPlayer("Puneet");
		InputType in;
		
		for (int i = 0; i< 5; i++){
			in = hp.getInput();
			System.out.println("You typed:" + in);
		}
	}*/
}