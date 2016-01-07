package Fields;

import Players.Player;
import Game.TurnSwitcher;

public class Prison extends Jail_Prison_Start{
		
	public Prison(int FieldNumberC, String fieldName, String SubTextC){
		FieldName = fieldName;
		FieldNumber = FieldNumberC;
		SubText = SubTextC;
	}
	
	@Override
	public void landOnField(){
		Player jailedPlayer = TurnSwitcher.getPlayerTurn();
		jailedPlayer.setJail(true);
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