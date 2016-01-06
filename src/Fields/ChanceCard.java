package Fields;

import Boundary.GUIChanceCard;
import Game.Language;
import Game.getPlayerName;

public class ChanceCard {

	private static String card[] = {Language.getLang("CARD1"),Language.getLang("CARD2"),Language.getLang("CARD3"),Language.getLang("CARD4"),Language.getLang("CARD5"),Language.getLang("CARD6"),Language.getLang("CARD7"),Language.getLang("CARD8"),Language.getLang("CARD9"),Language.getLang("CARD10")};
	
	//ChanceCard.Luck(); selects a random card from the deck.
	public void luck(){

		int randomCard = (int) (Math.random() * 10);
				
		GUIChanceCard.setCard(card[randomCard]);
		
	}
	
	

}
