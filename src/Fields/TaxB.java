package Fields;

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
