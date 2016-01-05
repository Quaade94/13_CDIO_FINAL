package Game;

import desktop_resources.GUI;

public class GameBoardCreator {

	Language Language = new Language();

	private int[] TryLuckNr = {3,8,18,23,34,37};
	private int ArrayNr = 0;
	
	public void setGameBoard(){
		
		while (ArrayNr<=5){
		//Try your luck field
			GUI.setSubText(TryLuckNr[ArrayNr],Language.getLang("LUCK") );
			GUI.setDescriptionText(TryLuckNr[ArrayNr], Language.getLang("CARD"));
			ArrayNr++;
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