package Players;

import Boundary.GUIPlayer;

public class PlayerCreator {
	
	private int playerAmount;
	private Player[] players;
	
	GUIPlayer guiplayer = new GUIPlayer();
	
	/**
	 * Opretter et spillerarray af spillerne
	 * @param playerAmount Antallet af spillere
	 */
	public PlayerCreator(int playerAmount){
		this.playerAmount = playerAmount;
		players = new Player[playerAmount];
		
		for (int i = 0; i < playerAmount; i++){
			players[i] = new Player();
		}
	}
	

	
	public void createPlayers(){
		
		for (int x = 0; x < playerAmount; x++){
			String name = guiplayer.enterName();
			players[x].setName(name);
				if (players[x].getName().equals(players[x].getName()) ){
					name = guiplayer.enterName();
			}
			
			
		}
	}
	
}