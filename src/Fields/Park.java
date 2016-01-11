package Fields;

import Players.PlayerController;

public class Park extends ParkChance{

	private int Money;
	
	public Park(int FieldNumberC, String FieldNameC, String SubTextC, String DescriptionC){
		
		FieldNumber = FieldNumberC;
		FieldName = FieldNameC;
		SubText = SubTextC;
		Description = DescriptionC;
		
	}
	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {
		
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
	public String getDescription() {
		return Description;
	}
	
	public void setParkMoney(int MoneyM){
		Money = Money + MoneyM;
	}
	public int seeParkMoney(){
		return Money;
	}
	public void resetParkMoney(){
		Money = 0;
		
	}
	

}
