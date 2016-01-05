package Game;

import Boundary.GUIFieldPrice;
import Boundary.Gameboard;

public class Main {

	public static void main(String[] args) {
		
		Gameboard Gameboard = new Gameboard();
		GUIFieldPrice GUIFieldPrice = new GUIFieldPrice();
		Gameboard.setGameBoard();
		GUIFieldPrice.setPrice();
	
		
	}
}
