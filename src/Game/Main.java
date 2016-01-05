package Game;

import Cars.Creator;

public class Main {

	public static void main(String[] args) {
		
		GameBoardCreator GameBoardCreator = new GameBoardCreator();
		GameBoardCreator.setGameBoard();
		
		Creator Creator = new Creator();		
		
		
		Creator.getCar();
		
	}
}
