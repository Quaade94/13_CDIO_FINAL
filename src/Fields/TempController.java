package Fields;

public class TempController {
	
	

	
	Field[] fields = Creator.createFields();
	

	
	public int getRent(int fieldIndex){
		
		int rent = -1;
		
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getRent();
			
		}
			
		return rent;
		
	}
	
	
}
