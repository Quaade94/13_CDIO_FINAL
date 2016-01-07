package Fields;

import Players.Player;
import Game.TurnSwitcher;

public class Jail extends Field{

	public Jail(){
		boolean jailed = true;
	}

	@Override
	public void landOnField(){
		Player jailedPlayer = TurnSwitcher.getPlayerTurn();
	}
}