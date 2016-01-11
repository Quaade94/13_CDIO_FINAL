package Fields;


import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class Start extends JailPrisonStart{

	private int StartingMoney;

	public Start (int FieldnumberC, int StartingMoneyC, String FieldNameC, String SubTextC){
		
		FieldName = FieldNameC;
		FieldNumber = FieldnumberC;
		StartingMoney = StartingMoneyC;
		SubText = SubTextC;
	}

	@Override
	public void landOnField(PlayerController playerController) {

		Player currentPlayer = playerController.getNextPlayer();
		
		Player players[] = playerController.getPlayers();
		
		for(int i = 0 ; i < players.length ; i++){
			if (players[i] == currentPlayer){
				players[i].getAccount().updateBalance(4000);
				GUI.setBalance(currentPlayer.getName(), players[i].getAccount().getBalance());
				System.out.println(players[i].toString());
			}
		}		
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
