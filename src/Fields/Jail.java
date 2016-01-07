package Fields;

import Players.Player;
import Game.TurnSwitcher;

public class Jail extends NonOwnable{
	
	public Jail(int FieldNumberC, String fieldName){
		Name = fieldName;
		FieldNumber = FieldNumberC;
	}
	
	@Override
	public void landOnField(){
		Player jailedPlayer = TurnSwitcher.getPlayerTurn();
		jailedPlayer.setJail(true);
	}
	@Override
	public String getName(){
		return Name;
	}
	@Override
	public int getFieldNumber(){
		return FieldNumber;
	}
}