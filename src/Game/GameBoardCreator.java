package Game;

import desktop_resources.GUI;

public class GameBoardCreator {

	Language Language = new Language();

	private int[] TryLuckNr = {3,8,18,23,34,37};
	private int ArrayNr = 0;
	
	public void setGameBoard(){

		while (ArrayNr<=5){
			GUI.setSubText(TryLuckNr[ArrayNr],Language.getLang("LUCK") );
			GUI.setDescriptionText(TryLuckNr[ArrayNr], Language.getLang("CARD"));
			ArrayNr++;
		}
	}

}
