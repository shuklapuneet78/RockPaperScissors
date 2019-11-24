package com.wb.players;

public class PlayerFactory {
	
	public static Player getPlayer(PlayerType playerType, String name){
		if (playerType == PlayerType.COMPUTER)
			return new ComputerPlayer(name);
		else
			return new HumanPlayer(name);
	}
}
