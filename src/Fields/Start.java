package Fields;


import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class Start extends NonOwnable{

	private int StartingMoney;

	public Start (int FieldnumberC, int StartingMoneyC, String FieldNameC, String SubTextC){
		
		FieldName = FieldNameC;
		FieldNumber = FieldnumberC;
		StartingMoney = StartingMoneyC;
		SubText = SubTextC;
	}

	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {

		Player currentPlayer = playerController.getCurrentPlayer();
		
		currentPlayer.getAccount().updateBalance(4000);
		GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());		
	}
	
	@Override
	public int getFieldNumber() {

		return FieldNumber;
	}
	
	@Override
	public String getName() {
		return FieldName;
	}
	
	public int getStartMoney(){
		return StartingMoney;
	}

	@Override
	public String getSubText() {
		return SubText;
	}

}
