package Fields;

import Game.Language;
import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class TaxA  extends Tax{

	public TaxA(int FieldNumberC, int TaxC, String NameC, String SubTextC, String DescriptioC){
		
		FieldNumber = FieldNumberC;
		FieldName = NameC;
		SubText = SubTextC;
		Description = DescriptioC;
		Tax = TaxC;	
	}

	@Override
	public int payTax() {
		return Tax;
	}
	
	@Override
	public String getDescription() {
		return Description;
	}

	@Override
	public int getFieldNumber() {
		return FieldNumber;
	}

	@Override
	public String getName() {
		return FieldName;
	}

	@Override
	public String getSubText() {
		return SubText;
	}

	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {
		Player currentPlayer = playerController.getCurrentPlayer();
		int playerBalance;
		if (GUI.getUserLeftButtonPressed(""+Language.getLang("PAY"), ""+Language.getLang("10%"), ""+Language.getLang("4000"))){
			playerBalance = currentPlayer.getAccount().getBalance();
			currentPlayer.getAccount().updateBalance(-((int)(playerBalance*0.1)));
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
		} else {
			currentPlayer.getAccount().updateBalance(-4000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
		}
	}
		
}
