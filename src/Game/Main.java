package Game;

import Fields.ChanceCard;

public class Main {

	public static void main(String[] args) {
		
		Setup Setup = new Setup();
		Setup.runSetup();
		
		ChanceCard.getLucky();
		
	}
}
