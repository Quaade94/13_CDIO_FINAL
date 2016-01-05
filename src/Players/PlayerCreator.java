package Players;

import Boundary.GUIPlayer;

public class PlayerCreator {
	
	private int playerAmount;
	private Player[] players;
	
	/**
	 * Opretter et spillerarray af spillerne
	 * @param playerAmount Antallet af spillere
	 */
	public PlayerCreator(int playerAmount){
		players = new Player[playerAmount];
		
		for (int i = 0; i < playerAmount; i++){
			players[i] = new Player();
		}
	}
	

	
	public void createPlayers(){
		GUIPlayer guiplayer = new GUIPlayer();
		
		for (int x = 0; x < playerAmount; x++){
			String name = guiplayer.enteredName();
			while(players[x].getName()=null ){
				
			}
			players[x].setName(name);
			
		}
	}
	

	
	

}
