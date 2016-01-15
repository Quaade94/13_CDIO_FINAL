package Fields;

import Game.Language;
import desktop_resources.GUI;
import Players.Player;
import Players.PlayerController;

public class OwnableController {
/**
 * This method is for when a player lands on a territory field that is not owned
 * @param Price
 * @param currentPlayer
 * @param colour
 * @param Owner
 * @param FieldNumber
 * @return
 */
	public Player territoryNotOwned(int Price, Player currentPlayer, String colour, Player Owner, int FieldNumber){
		if (GUI.getUserLeftButtonPressed(""+Language.getLang("CHOOSE"), ""+Language.getLang("YES"), ""+Language.getLang("NO"))){
			if(currentPlayer.getAccount().getBalance() >= Price){
				currentPlayer.getAccount().updateBalance(-Price);
				currentPlayer.addTerColour(colour);
				Owner = currentPlayer;
				GUI.setOwner(FieldNumber, currentPlayer.getName());
				GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
	
			} else{
				GUI.showMessage("You can't afford it");
			}
		}
		return Owner;
	}
	/**
	 * This method is for when a player lands on a territory field that is owned
	 * @param currentPlayer
	 * @param curRent
	 * @param Owner
	 */
	public void territoryOwned(Player currentPlayer, int curRent, Player Owner){
		if (currentPlayer.getAccount().getBalance() >= curRent){
			currentPlayer.getAccount().updateBalance(-curRent);
			Owner.getAccount().updateBalance(curRent);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.setBalance(Owner.getName(), Owner.getAccount().getBalance());
		} else{
			Owner.getAccount().updateBalance(currentPlayer.getAccount().getBalance());
			currentPlayer.getAccount().updateBalance(-(currentPlayer.getAccount().getBalance()+1));
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.setBalance(Owner.getName(), Owner.getAccount().getBalance());
		}
	}
/**
 * This method is for when a player lands on a fleet field that is not owned
 * @param Owner
 * @param Price
 * @param FieldNumber
 * @param pC
 * @return
 */
	public Player fleetNotOwned(Player Owner, int Price, int FieldNumber, PlayerController pC){
		Player currentPlayer = pC.getCurrentPlayer();
		if (GUI.getUserLeftButtonPressed(""+Language.getLang("CHOOSE"), ""+Language.getLang("YES"), ""+Language.getLang("NO"))){
			if(currentPlayer.getAccount().getBalance() >= Price){
				currentPlayer.getAccount().updateBalance(-Price);
				Owner = currentPlayer;
				currentPlayer.updateFleetOwned();
				GUI.setOwner(FieldNumber, currentPlayer.getName());
				GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());

			} else{
				GUI.showMessage("You can't afford it");
			}
		}
		return Owner;
	}
	/**
	 * This method is for when a player lands on a fleet field that is owned
	 * @param Owner
	 * @param currentPlayer
	 * @param curRent
	 */
	public void fleetOwned(Player Owner, Player currentPlayer, int curRent){
		if (currentPlayer.getAccount().getBalance() >= curRent){
			currentPlayer.getAccount().updateBalance(-curRent);
			Owner.getAccount().updateBalance(curRent);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.setBalance(Owner.getName(), Owner.getAccount().getBalance());
		} else{
			Owner.getAccount().updateBalance(currentPlayer.getAccount().getBalance());
			currentPlayer.getAccount().updateBalance(-(currentPlayer.getAccount().getBalance()+1));
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.setBalance(Owner.getName(), Owner.getAccount().getBalance());
		}
	}
	/**
	 * This method is for when a player lands on a laborcamp field that is not owned
	 * @param currentPlayer
	 * @param Price
	 * @param Owner
	 * @param FieldNumber
	 * @return
	 */
	public Player laborCampNotOwned(Player currentPlayer, int Price, Player Owner, int FieldNumber){
		if (GUI.getUserLeftButtonPressed(""+Language.getLang("CHOOSE"), ""+Language.getLang("YES"), ""+Language.getLang("NO"))){
			if(currentPlayer.getAccount().getBalance() >= Price){
				currentPlayer.getAccount().updateBalance(-Price);
				Owner = currentPlayer;
				currentPlayer.updateLaborOwned();
				GUI.setOwner(FieldNumber, currentPlayer.getName());
				GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());

			} else{
				GUI.showMessage("You can't afford it");
			}
		}
		return Owner;
	}
/**
 * This method is for when a player lands on a laborcamp field that is owned
 * @param currentPlayer
 * @param Owner
 * @param curRent
 */
	public void laborCampOwned(Player currentPlayer, Player Owner, int curRent){
		if (currentPlayer.getAccount().getBalance() >= curRent){
			currentPlayer.getAccount().updateBalance(-curRent);
			Owner.getAccount().updateBalance(curRent);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.setBalance(Owner.getName(), Owner.getAccount().getBalance());
		} else{
			Owner.getAccount().updateBalance(currentPlayer.getAccount().getBalance());
			currentPlayer.getAccount().updateBalance(-(currentPlayer.getAccount().getBalance()+1));
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.setBalance(Owner.getName(), Owner.getAccount().getBalance());
		}
	}
}
