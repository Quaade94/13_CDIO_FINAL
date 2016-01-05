package Cars;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_resources.GUI;

public class Cars {

	public void car(){
		
		Creator Creator = new Creator();
		
		Car[] cars = Creator.getCar();
		
		GUI.addPlayer("hej", 30000, cars[0]);

		

		
		
		
	}
	
	
}
