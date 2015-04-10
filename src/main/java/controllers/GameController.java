package controllers;

import models.GameInfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	private GameInfo gameInfo = new GameInfo();
	
	@RequestMapping("/addgame")
	public ResponseEntity<GameInfo> addGame(@RequestParam(value="game", defaultValue = "") String newGame) {
		if (newGame == null || newGame.isEmpty()) {
			return new ResponseEntity<GameInfo>(HttpStatus.BAD_REQUEST);
		}
		synchronized(gameInfo) {
			gameInfo.getCurrentGames().add(newGame);
			return new ResponseEntity<GameInfo>(gameInfo, HttpStatus.OK);	
		}
	}
	
	@RequestMapping("/addplayer")
	public ResponseEntity<GameInfo> addPlayer(@RequestParam(value = "player", defaultValue = "") String newPlayer) {
		if (newPlayer == null || newPlayer.isEmpty()) {
			return new ResponseEntity<GameInfo>(HttpStatus.BAD_REQUEST);
		}
		synchronized(gameInfo) {
			gameInfo.getCurrentPlayers().add(newPlayer);
			return new ResponseEntity<GameInfo>(gameInfo, HttpStatus.OK);
		}
	}
	
	@RequestMapping("/show")
	public ResponseEntity<GameInfo> show() {
		synchronized(gameInfo) {
			return new ResponseEntity<GameInfo>(gameInfo, HttpStatus.OK);
		}
	}
	
	@RequestMapping("/clear")
	public ResponseEntity<GameInfo> clear() {
		synchronized(gameInfo) {
			gameInfo.getCurrentGames().clear();
			gameInfo.getCurrentPlayers().clear();
			return new ResponseEntity<GameInfo>(HttpStatus.OK);
		}
	}
	
	@RequestMapping("/start")
	public ResponseEntity<String> start() {
		synchronized(gameInfo) {
			return new ResponseEntity<String>("Token sent", HttpStatus.OK);
		}
	}
}
