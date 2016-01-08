package Game;

import desktop_resources.GUI;
import Fields.FieldController;

public class GUIManager {

	public void createFields(){

		for (int ArrayNr = 0 ; ArrayNr <=39 ; ArrayNr++){
			
			// Ownable
			
			if (FieldController.getFieldNumber(ArrayNr) == 2 || FieldController.getFieldNumber(ArrayNr) == 4 || FieldController.getFieldNumber(ArrayNr) == 7 || 
				FieldController.getFieldNumber(ArrayNr) == 9 || FieldController.getFieldNumber(ArrayNr) == 10 || FieldController.getFieldNumber(ArrayNr) == 12 || 
				FieldController.getFieldNumber(ArrayNr) == 13 || FieldController.getFieldNumber(ArrayNr) == 14 || FieldController.getFieldNumber(ArrayNr) == 15 || 
				FieldController.getFieldNumber(ArrayNr) == 17 || FieldController.getFieldNumber(ArrayNr) == 19 || FieldController.getFieldNumber(ArrayNr) == 20 || 
				FieldController.getFieldNumber(ArrayNr) == 22 || FieldController.getFieldNumber(ArrayNr) == 24 || FieldController.getFieldNumber(ArrayNr) == 25 || 
				FieldController.getFieldNumber(ArrayNr) == 27 || FieldController.getFieldNumber(ArrayNr) == 28 || FieldController.getFieldNumber(ArrayNr) == 29 || 
				FieldController.getFieldNumber(ArrayNr) == 30 || FieldController.getFieldNumber(ArrayNr) == 32 || FieldController.getFieldNumber(ArrayNr) == 33 || 
				FieldController.getFieldNumber(ArrayNr) == 35 || FieldController.getFieldNumber(ArrayNr) == 38 || FieldController.getFieldNumber(ArrayNr) == 40){
				
				int number = FieldController.getFieldNumber(ArrayNr);

				//Creates field price
				GUI.setSubText(number, Language.getLang("PRI")+FieldController.getPrice(ArrayNr));

				//Creates street name
				GUI.setTitleText(number, FieldController.getName(ArrayNr));
				GUI.setDescriptionText(number, FieldController.getName(ArrayNr));
			}
			
			if (FieldController.getFieldNumber(ArrayNr) == 6 || FieldController.getFieldNumber(ArrayNr) == 16 || 
				FieldController.getFieldNumber(ArrayNr) == 26 || FieldController.getFieldNumber(ArrayNr) == 36){
				int number = FieldController.getFieldNumber(ArrayNr);

				//Creates field price
				GUI.setSubText(number, Language.getLang("PRI")+FieldController.getPrice(ArrayNr));

				//Creates street name
				GUI.setTitleText(number, FieldController.getName(ArrayNr));
				GUI.setDescriptionText(number, FieldController.getName(ArrayNr));
			}
			
			if (FieldController.getFieldNumber(ArrayNr) == 3 || FieldController.getFieldNumber(ArrayNr) == 8 || FieldController.getFieldNumber(ArrayNr) == 18 || 
				FieldController.getFieldNumber(ArrayNr) == 23 || FieldController.getFieldNumber(ArrayNr) == 34 || FieldController.getFieldNumber(ArrayNr) == 37){
				int number = FieldController.getFieldNumber(ArrayNr);
				//Try your luck field
				GUI.setSubText(number,FieldController.getSubText(ArrayNr) );
				GUI.setDescriptionText(number,FieldController.getDesText(ArrayNr));				
			}
			if (FieldController.getFieldNumber(ArrayNr) == 31){
				//Go to jail field
				GUI.setSubText(31, Language.getLang("PRISONS"));
				GUI.setDescriptionText(31, Language.getLang("PRISOND"));
			}
			if (FieldController.getFieldNumber(ArrayNr) == 11){
				//Visit jail field
				GUI.setSubText(11, Language.getLang("PRISON"));
				GUI.setDescriptionText(11, Language.getLang("PRISONV"));
			}
			if (FieldController.getFieldNumber(ArrayNr) == 1){
				//Start field
				GUI.setSubText(1, Language.getLang("STARTS"));
				GUI.setDescriptionText(1, Language.getLang("STARTD"));
			}
			if (FieldController.getFieldNumber(ArrayNr) == 21){
				//Parking
				GUI.setSubText(21, Language.getLang("PARKS"));
				GUI.setDescriptionText(21, Language.getLang("PARKD"));
				GUI.setTitleText(21, Language.getLang("PARKT"));
			}
			if (FieldController.getFieldNumber(ArrayNr) == 39){
				//Tax1 before START
				GUI.setSubText(39, Language.getLang("TAX1S"));
				GUI.setDescriptionText(39, Language.getLang("TAX1D"));
				GUI.setTitleText(39, Language.getLang("TAX1T"));
			}
			if (FieldController.getFieldNumber(ArrayNr) == 5){
				//Tax2 after START
				GUI.setSubText(5, Language.getLang("TAX2S"));
				GUI.setDescriptionText(5, Language.getLang("TAX2D"));
				GUI.setTitleText(5, Language.getLang("TAX2T"));
			}
		}
	}
}


//		//NON-OWNABLE
//		
//		for (int ArrayNr = 29 ; ArrayNr <=33 ; ArrayNr++){
//
//		}

//		//Go to jail field
//		GUI.setSubText(31, Language.getLang("PRISONS"));
//		GUI.setDescriptionText(31, Language.getLang("PRISOND"));

//		//Visit jail field
//		GUI.setSubText(11, Language.getLang("PRISON"));
//		GUI.setDescriptionText(11, Language.getLang("PRISONV"));

//		//Start field
//		GUI.setSubText(1, Language.getLang("STARTS"));
//		GUI.setDescriptionText(1, Language.getLang("STARTD"));

//		//Parking
//		GUI.setSubText(21, Language.getLang("PARKS"));
//		GUI.setDescriptionText(21, Language.getLang("PARKD"));
//		GUI.setTitleText(21, Language.getLang("PARKT"));

//		//Tax1 before START
//		GUI.setSubText(39, Language.getLang("TAX1S"));
//		GUI.setDescriptionText(39, Language.getLang("TAX1D"));
//		GUI.setTitleText(39, Language.getLang("TAX1T"));

//		//Tax2 after START
//		GUI.setSubText(5, Language.getLang("TAX2S"));
//		GUI.setDescriptionText(5, Language.getLang("TAX2D"));
//		GUI.setTitleText(5, Language.getLang("TAX2T"));
