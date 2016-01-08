package Fields;

import Players.PlayerController;

public class Start extends Jail_Prison_Start{

	private int StartingMoney;

	public Start (int FieldnumberC, int StartingMoneyC, String FieldNameC, String SubTextC){
		
		FieldName = FieldNameC;
		FieldNumber = FieldnumberC;
		StartingMoney = StartingMoneyC;
		SubText = SubTextC;
	}

	@Override
	public void landOnField(PlayerController playerController) {

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
