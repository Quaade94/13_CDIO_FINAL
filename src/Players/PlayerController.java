package Players;

import java.sql.Blob;

import desktop_resources.GUI;

public class PlayerController {
	
	private int playerAmount;
	private Player[] players;
	private boolean Bleh;

	
	/**
	 * Opretter et spillerarray af spillerne
	 * @param playerAmount Antallet af spillere
	 */
	public PlayerController(){
		playerAmount = GUI.getUserInteger("How many players?", 2, 6);
		players = new Player[playerAmount];
		
	}
	
	public void createPlayers(){
		
		for (int x = 0; x < playerAmount; x++){
			String name;
			boolean nameExists = false;
			do{
				nameExists = false;
				name = GUI.getUserString("Enter your name: ");
				for(int i = 0; i < x; i++){
					if(players[i].getName().equals(name)){
						nameExists = true;
					GUI.getUserButtonPressed("You can't be named the same as someone else!", "Type new name");
					}
				}
				if(name.length() < 3 || name.length() > 17){	
					nameExists = true;
					GUI.getUserButtonPressed("Your name needs to be minimum 3 characters short and 17 characters long", "Type new name");
				}
		
			}while(nameExists);

			Player player = new Player();
			player.setName(name);
			players[x] = player;
			System.out.println("spiller: "+players[x].getName());
			System.out.println("penge: "+players[x].getAccount().getBalance());
		}
	}
	
	public Player[] getPlayers(Player[] players){
		return players;
	}
}