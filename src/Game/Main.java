package Game;

import Boundary.GUITeritorryPrice;
import Boundary.Gameboard;
import Boundary.GUIPlayer;

public class Main {

	public static void main(String[] args) {
		
		Gameboard Gameboard = new Gameboard();
		GUITeritorryPrice GUITeritorryPrice = new GUITeritorryPrice();
		GUIPlayer addplayer = new GUIPlayer();
		Gameboard.setGameBoard();
		GUITeritorryPrice.setPrice();
	
		
	}
}
