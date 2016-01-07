package Fields;

import Players.Player;
import Game.TurnSwitcher;

public class Jail extends Field{
	private String name;
	private int id;

	public Jail(int fieldNumber, String fieldName){
		name = fieldName;
		id = fieldNumber;
	}
	@Override
	public void landOnField(){
		Player jailedPlayer = TurnSwitcher.getPlayerTurn();
		jailedPlayer.setJail(true);
	}
	public String getName(){
		return name;
	}
	
	@Override
	public int getFieldNumber(){
		return id;
	}
}