package Fields;

public abstract class Field {
	
	protected int FieldNumber;
	protected String FieldName;

	
	
	
	public abstract void landOnField();
	
	/**
	 * This method will return the Field Number of the object
	 * @return the Field Number of the object
	 */
	public abstract int getFieldNumber();
	/**
	 * This method will return the Name of the object
	 * @return the Name of the object
	 */
	public abstract String getName();

	
}

