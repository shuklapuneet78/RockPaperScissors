package com.wb.players;

import com.wb.game.GameStats;
import com.wb.game.InputType;

public interface Player {

	PlayerType getType();
	String getName();
	InputType getInput();
	GameStats getGameStats();
}
