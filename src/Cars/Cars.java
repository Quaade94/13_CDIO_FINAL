package Cars;

import Cars.CarCreator;
import Game.Language;
import desktop_codebehind.Car;
import desktop_resources.GUI;

public class Cars {

	public void car(){
		
		CarCreator CarCreator = new CarCreator();
		
		Car[] cars = CarCreator.getCar();
		
		GUI.addPlayer("hej", 30000, cars[0]);

	String navn = GUI.getUserString(Language.getLang("NAMEERROR"));


		
		
		
	}
	
	
}
