package Fields;


public class Start extends NonOwnable{

	private int StartingMoney;

	public Start (int FieldnumberC, int StartingMoneyC, String NameC){
		
		Name = NameC;
		FieldNumber = FieldnumberC;
		StartingMoney = StartingMoneyC;
	}

	@Override
	public void landOnField() {

	}
	
	@Override
	public int getFieldNumber() {

		return FieldNumber;
	}
	@Override
	public String getName() {
		return Name;
	}
	
	public int getStartMoney(){
		return StartingMoney;
	}

}
