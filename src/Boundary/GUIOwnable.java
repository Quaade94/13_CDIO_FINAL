package Boundary;

import Game.Language;
import Fields.FieldController;
import desktop_resources.GUI;

public class GUIOwnable {
		
	public void GUIOwnablePrice(){

		for (int ArrayNr = 0 ; ArrayNr <=25 ; ArrayNr++){
			
			//Creates field price
			GUI.setSubText(FieldController.getFieldNumber(ArrayNr), Language.getLang("PRI")+FieldController.getPrice(ArrayNr));
			
			//Creates street name
			GUI.setTitleText(FieldController.getFieldNumber(ArrayNr), FieldController.getName(ArrayNr));
			GUI.setDescriptionText(FieldController.getFieldNumber(ArrayNr), FieldController.getName(ArrayNr));
			
		}
	}
}
