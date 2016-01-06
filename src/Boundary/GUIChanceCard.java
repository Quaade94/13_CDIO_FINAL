package Boundary;

import desktop_resources.GUI;
import Game.Language;

public class GUIChanceCard {

	public static void setCard(String card){
		
		GUI.displayChanceCard(Language.getLang("LUCK"));
		GUI.setChanceCard(card);
		
	}
	
}
