package Fields;

import Fields.Field;

public class Start extends Field{

	private String name;
	private int FieldNumber;

	public Start (int Fieldnumber, String name){
		
		this.name = name;
		this.FieldNumber = FieldNumber;
	}


	@Override
	public void landOnField() {


	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public int getFieldNumber() {

		return FieldNumber;
	}

}
