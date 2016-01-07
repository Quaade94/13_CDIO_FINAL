package Fields;

import Game.Language;

public class ChanceCard {

	private static String[] card = {Language.getLang("CARD1"),Language.getLang("CARD2"),Language.getLang("CARD3"),Language.getLang("CARD4"),Language.getLang("CARD5"),Language.getLang("CARD6"),Language.getLang("CARD7"),Language.getLang("CARD8")};
	
	//READ ME:
	//ChanceCard.getLucky(); selects a random card from the deck.
	public static String[] getLucky(){
		
		return card;
	}
}