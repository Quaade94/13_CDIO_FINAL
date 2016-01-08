package Game;

import Players.PlayerController;
import Players.Player;

public class TurnSwitcher {
	static Player[] players = PlayerController.getPlayers();
	static int playerSize = players.length;
	private static int playerTurn = 1;
	
	public static void endTurn(){
		
		if(playerTurn <= playerSize){			
			playerTurn++;			
		}else if(playerTurn > playerSize){	
			playerTurn = 1;
		} else{
			System.out.println("Fejl i endTurn metode");
		}
	}
	public static Player getPlayerTurn(){
		return players[playerTurn-1];
	}
}
