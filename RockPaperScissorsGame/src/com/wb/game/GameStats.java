package com.wb.game;

public class GameStats {
	long wins = 0;
	long losses = 0;
	long ties = 0;
	long totalPlayed = 0;
	
	public long getWins() {
		return wins;
	}
	public long getLosses() {
		return losses;
	}
	public long getTies() {
		return ties;
	}
	public long getTotalPlayed() {
		return totalPlayed;
	}
	
	public void incrementWins() {
		this.wins++;
	}
	public void incrementLosses() {
		this.losses++;
	}
	public void incrementTies() {
		this.ties++;
	}
	public void setTotalPlayed(long totalPlayed) {
		this.totalPlayed = totalPlayed;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("Results: ");
		sb.append("{").append("Total Played: ").append(totalPlayed).append("}");
		sb.append("{").append("Wins: ").append(wins).append("}");
		sb.append("{").append("Losses: ").append(losses).append("}");
		sb.append("{").append("Ties: ").append(ties).append("}");
		return sb.toString();
	}
}
