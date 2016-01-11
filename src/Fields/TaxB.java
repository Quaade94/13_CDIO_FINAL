package Fields;

import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class TaxB extends Tax{

	public TaxB(int FieldNumberC, int TaxC, String NameC, String SubTextC, String DescriptioC){
		
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
	public void landOnField(PlayerController playerController) {
		Player currentPlayer = playerController.getNextPlayer();
		currentPlayer.getAccount().updateBalance(-1000);
		GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
	}
	
	
	
	

}
