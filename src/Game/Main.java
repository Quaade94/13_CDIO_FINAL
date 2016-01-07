package Game;

public class Main {

	public static void main(String[] args) {
		
		Setup Setup = new Setup();
		Setup.runSetup();
		
		GameController gameController = new GameController();
		gameController.runGame();
	}
}
