package Game;

import desktop_resources.GUI;
import Fields.FieldController;

public class GUISetupManager {

	public GUISetupManager(FieldController fieldController) {
		createFields(fieldController);
	}

	public void createFields(FieldController fieldController){

		//OWNABLE
		
		for (int ArrayNr = 0 ; ArrayNr <28 ; ArrayNr++){

			int number = fieldController.getFieldNumber(ArrayNr);

			//Creates field price
			GUI.setSubText(number, Language.getLang("PRI")+fieldController.getPrice(ArrayNr));

			//Creates street name
			GUI.setTitleText(number, fieldController.getName(ArrayNr));
			GUI.setDescriptionText(number, fieldController.getName(ArrayNr));

		}
		
		//NON-OWNABLE
		
		for (int ArrayNr = 29 ; ArrayNr <=33 ; ArrayNr++){
			int number = fieldController.getFieldNumber(ArrayNr);
			//Try your luck field
			GUI.setSubText(number,fieldController.getSubText(ArrayNr) );
			GUI.setDescriptionText(number,fieldController.getDesText(ArrayNr));
		}

		//Go to jail field
		GUI.setSubText(31, Language.getLang("PRISONS"));
		GUI.setDescriptionText(31, Language.getLang("PRISOND"));

		//Visit jail field
		GUI.setSubText(11, Language.getLang("PRISON"));
		GUI.setDescriptionText(11, Language.getLang("PRISONV"));

		//Start field
		GUI.setSubText(1, Language.getLang("STARTS"));
		GUI.setDescriptionText(1, Language.getLang("STARTD"));

		//Parking
		GUI.setSubText(21, Language.getLang("PARKS"));
		GUI.setDescriptionText(21, Language.getLang("PARKD"));
		GUI.setTitleText(21, Language.getLang("PARKT"));

		//Tax1 before START
		GUI.setSubText(39, Language.getLang("TAX1S"));
		GUI.setDescriptionText(39, Language.getLang("TAX1D"));
		GUI.setTitleText(39, Language.getLang("TAX1T"));

		//Tax2 after START
		GUI.setSubText(5, Language.getLang("TAX2S"));
		GUI.setDescriptionText(5, Language.getLang("TAX2D"));
		GUI.setTitleText(5, Language.getLang("TAX2T"));
	}
}