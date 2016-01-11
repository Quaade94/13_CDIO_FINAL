package Fields;

import Players.PlayerController;

public abstract class Field {
	
	protected int FieldNumber;
	protected String FieldName;

	
	
	
	public abstract void landOnField(PlayerController playerController, FieldController fieldController);
	
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

