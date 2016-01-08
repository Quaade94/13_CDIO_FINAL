package Game;

import desktop_resources.GUI;
import Fields.FieldController;

public class GUISetupManager {

	public GUISetupManager(FieldController fieldController) {
		createFields(fieldController);
	}

	public void createFields(FieldController fieldController) {

		// OWNABLE

		for (int ArrayNr = 0; ArrayNr < 40; ArrayNr++) {

			if (fieldController.getFieldNumber(ArrayNr) == 2 || fieldController.getFieldNumber(ArrayNr) == 4
					|| fieldController.getFieldNumber(ArrayNr) == 7 || fieldController.getFieldNumber(ArrayNr) == 9
					|| fieldController.getFieldNumber(ArrayNr) == 10 || fieldController.getFieldNumber(ArrayNr) == 12
					|| fieldController.getFieldNumber(ArrayNr) == 13 || fieldController.getFieldNumber(ArrayNr) == 14
					|| fieldController.getFieldNumber(ArrayNr) == 15 || fieldController.getFieldNumber(ArrayNr) == 17
					|| fieldController.getFieldNumber(ArrayNr) == 19 || fieldController.getFieldNumber(ArrayNr) == 20
					|| fieldController.getFieldNumber(ArrayNr) == 22 || fieldController.getFieldNumber(ArrayNr) == 24
					|| fieldController.getFieldNumber(ArrayNr) == 25 || fieldController.getFieldNumber(ArrayNr) == 27
					|| fieldController.getFieldNumber(ArrayNr) == 28 || fieldController.getFieldNumber(ArrayNr) == 29
					|| fieldController.getFieldNumber(ArrayNr) == 30 || fieldController.getFieldNumber(ArrayNr) == 32
					|| fieldController.getFieldNumber(ArrayNr) == 33 || fieldController.getFieldNumber(ArrayNr) == 35
					|| fieldController.getFieldNumber(ArrayNr) == 38 || fieldController.getFieldNumber(ArrayNr) == 40) {

				int number = fieldController.getFieldNumber(ArrayNr);

				// Creates field price
				GUI.setSubText(number, Language.getLang("PRI") + fieldController.getPrice(ArrayNr));

				// Creates street name
				GUI.setTitleText(number, fieldController.getName(ArrayNr));
				GUI.setDescriptionText(number, fieldController.getName(ArrayNr));

			}
			if (fieldController.getFieldNumber(ArrayNr) == 6 || fieldController.getFieldNumber(ArrayNr) == 16
					|| fieldController.getFieldNumber(ArrayNr) == 26 || fieldController.getFieldNumber(ArrayNr) == 36) {
				int number = fieldController.getFieldNumber(ArrayNr);

				// Creates field price
				GUI.setSubText(number, Language.getLang("PRI") + fieldController.getPrice(ArrayNr));

				// Creates street name
				GUI.setTitleText(number, fieldController.getName(ArrayNr));
				GUI.setDescriptionText(number, fieldController.getName(ArrayNr));
			}
			
			if (fieldController.getFieldNumber(ArrayNr) == 31) {
				// Go to jail field
				GUI.setSubText(31, Language.getLang("PRISONS"));
				GUI.setDescriptionText(31, Language.getLang("PRISOND"));
			}
			if (fieldController.getFieldNumber(ArrayNr) == 11) {
				// Visit jail field
				GUI.setSubText(11, Language.getLang("PRISON"));
				GUI.setDescriptionText(11, Language.getLang("PRISONV"));
			}
			if (fieldController.getFieldNumber(ArrayNr) == 1) {
				// Start field
				GUI.setSubText(1, Language.getLang("STARTS"));
				GUI.setDescriptionText(1, Language.getLang("STARTD"));
			}
			if (fieldController.getFieldNumber(ArrayNr) == 21) {
				// Parking
				GUI.setSubText(21, Language.getLang("PARKS"));
				GUI.setDescriptionText(21, Language.getLang("PARKD"));
				GUI.setTitleText(21, Language.getLang("PARKT"));
			}
			if (fieldController.getFieldNumber(ArrayNr) == 39) {
				// Tax1 before START
				GUI.setSubText(39, Language.getLang("TAX1S"));
				GUI.setDescriptionText(39, Language.getLang("TAX1D"));
				GUI.setTitleText(39, Language.getLang("TAX1T"));
			}
			if (fieldController.getFieldNumber(ArrayNr) == 5) {
				// Tax2 after START
				GUI.setSubText(5, Language.getLang("TAX2S"));
				GUI.setDescriptionText(5, Language.getLang("TAX2D"));
				GUI.setTitleText(5, Language.getLang("TAX2T"));
			}
			
			
		}
	}
}