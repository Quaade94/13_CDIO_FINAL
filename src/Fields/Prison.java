package Fields;

import Game.GameController;
import Players.Player;
import Players.PlayerController;

public class Prison extends JailPrisonStart{
		
	public Prison(int FieldNumberC, String fieldName, String SubTextC){
		FieldName = fieldName;
		FieldNumber = FieldNumberC;
		SubText = SubTextC;
		
	}
	
	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {
		Player jailedPlayer = playerController.getCurrentPlayer();
		jailedPlayer.setJail(true);
		GameController.movement(jailedPlayer.getPlace()+1, 11, jailedPlayer);
		jailedPlayer.setPlace(10);
	}
	@Override
	public String getName(){
		return FieldName;
	}
	@Override
	public int getFieldNumber(){
		return FieldNumber;
	}
	@Override
	public String getSubText(){
		return SubText;
	}
	
}