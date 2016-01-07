package Fields;

public class TryLuck extends Field {
	
	public TryLuck(int FieldNumberC, String NameC){
		
		FieldNumber = FieldNumberC;
		Name = NameC;
		
	}

	@Override
	public void landOnField() {
		
	}
	@Override
	public int getFieldNumber(){
		return FieldNumber;
	}
	@Override
	public String getName(){
		return Name;
	}
	
}
