package models;

import java.util.ArrayList;
import java.util.List;

public class GameInfo {
	private List<String> currentGames = new ArrayList<>();
	private List<String> currentPlayers = new ArrayList<>();;
	
	public List<String> getCurrentGames() {
		return currentGames;
	}
	public List<String> getCurrentPlayers() {
		return currentPlayers;
	}
}
