package Players;

import java.sql.Blob;

import desktop_resources.GUI;
import desktop_tests.CarTest;

import java.awt.Color;
import desktop_codebehind.Car;

import Game.Language;

public class PlayerController {
	
	private int playerAmount;
	private static Player[] players;
	private boolean Bleh;

	
	/**
	 * Opretter et spillerarray af spillerne
	 * @param playerAmount Antallet af spillere
	 */
	public PlayerController(){
		playerAmount = GUI.getUserInteger(Language.getLang("PLAYERNO"), 2, 6);
		players = new Player[playerAmount];
		
	}
	
	/**
	 * Opretter spillerne (Spiller objekter, spillerbiler mm.)
	 */
	public void createPlayers(){
		
		Car[] cars = CarBuilder.getCar();
		for (int x = 0; x < playerAmount; x++){
			String name;
			boolean nameExists = false;
			do{
				//Checks if the playerss name follows a certain criteria
				nameExists = false;
				name = GUI.getUserString(Language.getLang("WHATSNAME"));
				for(int i = 0; i < x; i++){
					if(players[i].getName().equals(name)){
						nameExists = true;
					GUI.getUserButtonPressed(Language.getLang("NAMEERRORSAME"), Language.getLang("TYPENEW"));
					}
				}
				if(name.length() < 3 || name.length() > 17){	
					nameExists = true;
					GUI.getUserButtonPressed(Language.getLang("NAMEERRORSHORTLONG"), Language.getLang("TYPENEW"));
				}
		
			}while(nameExists);
			
			//Creates the player and puts him into an array
			Player player = new Player();
			player.setName(name);
			players[x] = player;
			//Creates the player on the board
			GUI.addPlayer(players[x].getName(), players[x].getAccount().getBalance(), cars[x]);
			GUI.setCar(players[x].getPlace()+1, players[x].getName());
 		}
	}
	
	/**
	 * A method to get the playerarray for use in other classes
	 * @return An array of players
	 */
	public static Player[] getPlayers(){
		return players;
	}	
}
