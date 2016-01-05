package Game;

import Boundary.GUITeritorryPrice;
import Boundary.Gameboard;

public class Main {

	public static void main(String[] args) {
		
		Gameboard Gameboard = new Gameboard();
		GUITeritorryPrice GUITeritorryPrice = new GUITeritorryPrice();
		Gameboard.setGameBoard();
		GUITeritorryPrice.setPrice();
	
		
	}
}
