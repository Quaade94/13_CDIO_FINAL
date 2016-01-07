package Game;

import Players.PlayerController;
import Players.Player;

public class TurnSwitcher {
	static Player[] players = PlayerController.getPlayers();
	static int playerSize = players.length;
	private static int playerTurn =1;
	
	public static void endTurn(){
		
		if(playerTurn<=playerSize){			
			playerTurn++;			
		}
			
		if(playerTurn>playerSize){	
			playerTurn = 1;
		}
	}
	public static Player getPlayerTurn(){
		System.out.println(players[0].getName());
		return players[playerTurn-1];
	}
}
