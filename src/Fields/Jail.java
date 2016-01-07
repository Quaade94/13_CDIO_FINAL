package Fields;

public class Jail extends Jail_Prison_Start{

	public Jail(int FieldNumberC, String fieldName, String SubTextC){
		FieldName = fieldName;
		FieldNumber = FieldNumberC;
		SubText = SubTextC;
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
		return FieldName;
	}
	@Override
	public String getSubText() {
		return SubText;
	}

}
