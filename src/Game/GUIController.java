package Game;

import desktop_resources.GUI;
import Fields.FieldController;
import Fields.ChanceCard;

public class GUIController {

	private int[] TryLuckNr = {3,8,18,23,34,37};
	
	public void GUINonoOwnable(){
		
		for (int ArrayNr = 0 ; ArrayNr <=5 ; ArrayNr++){
		//Try your luck field
			GUI.setSubText(TryLuckNr[ArrayNr],Language.getLang("LUCK") );
			GUI.setDescriptionText(TryLuckNr[ArrayNr], Language.getLang("CARD"));
		
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
		
		public static void getChanceCard(){
			
//			GUI.displayChanceCard(Language.getLang("LUCK"));
//			GUI.setChanceCard(ChanceCard.getLucky(((int)(Math.random()*8)+1)));
	}
		
		public void GUIOwnable(){

			for (int ArrayNr = 0 ; ArrayNr <34 ; ArrayNr++){
			
			int number = FieldController.getFieldNumber(ArrayNr);
			
			//Creates field price
			GUI.setSubText(number, Language.getLang("PRI")+FieldController.getPrice(ArrayNr));
			
			//Creates street name
			GUI.setTitleText(number, FieldController.getName(ArrayNr));
			GUI.setDescriptionText(number, FieldController.getName(ArrayNr));
			
			}
		}
}