package Boundary;

import Game.Language;
import desktop_resources.GUI;

public class GUIFieldPrice {
	
	private int[] Fields = {2,4,6,7,9,10,12,13,14,15,16,17,19,20,22,24,25,26,27,28,29,30,32,33,35,36,38,40};

	
	public void setPrice(){

		for (int ArrayNr = 0 ; ArrayNr <=27 ; ArrayNr++){

			GUI.setSubText(Fields[ArrayNr], Language.getLang("PRI"));

		}
	}
}
