package Fields;

import Players.Player;
import Game.TurnSwitcher;

public class Jail extends Field{

	@Override
	public void landOnField(){
		Player jailedPlayer = TurnSwitcher.getPlayerTurn();
		jailedPlayer.setJail(true);
	}
}