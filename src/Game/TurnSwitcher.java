package Game;

import Players.PlayerController;
import Players.Player;

public class TurnSwitcher {
	//FIXME static
	Player[] players;
	private int currentPlayer;
	
	public TurnSwitcher(Player[] players) {
		super();
		this.players = players;
	}
	//TODO merge endTurn and getGextPlayer
	public void endTurn(){
		
		if(currentPlayer <= players.length){			
			currentPlayer++;			
		}else if(currentPlayer > players.length){	
			currentPlayer = 1;
		} else{
			System.out.println("Fejl i endTurn metode");
		}
	}
	public Player getNextPlayer(){
		return players[currentPlayer-1];
	}
}
