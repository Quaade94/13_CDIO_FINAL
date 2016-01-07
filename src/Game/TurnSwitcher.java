package Game;

import Players.PlayerController;
import Players.Player;

public class TurnSwitcher {
	static Player[] players = PlayerController.getPlayers();
	int playerSize = players.length;
	private static int playerTurn =1;
	
	public void endTurn(){
		
		if(playerTurn<=playerSize){			
			playerTurn++;			
		}
			
		if(playerTurn>playerSize){	
			playerTurn = 1;
		}
	}
	public static Player getPlayerTurn(){	
		return players[playerTurn-1];
	}
}
