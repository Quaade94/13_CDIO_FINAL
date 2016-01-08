package Fields;

import Players.PlayerController;

public class Jail extends JailPrisonStart{

	public Jail(int FieldNumberC, String fieldName, String SubTextC){
		FieldName = fieldName;
		FieldNumber = FieldNumberC;
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
	@Override
	public String getSubText() {
		return SubText;
	}

}
