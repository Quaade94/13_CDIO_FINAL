package Fields;

public abstract class Field {
	
	
	protected int FieldNumber;
	protected String Name;
	
	public abstract void landOnField();
	
	/**
	 * This method will return the Name of the object
	 * @return the Name of the object
	 */
	public abstract String getName();
	
	/**
	 * This method will return the Field Number of the object
	 * @return the Field Number of the object
	 */
	public abstract int getFieldNumber();
	
}
