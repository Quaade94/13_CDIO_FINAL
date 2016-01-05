package Boundary;

import Fields.ChanceCard;
import desktop_resources.GUI;
import Game.Language;

public class GUIChanceCard {

	public static void card(){
		
		GUI.displayChanceCard(Language.getLang("LUCK"));
		GUI.setChanceCard(ChanceCard.luck());
		
	}
	
}
