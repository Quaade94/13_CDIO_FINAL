package Players;

import desktop_codebehind.Car;


import Cars.CarCreator;


public class PlayerCreator {
		
	
	CarCreator CarCreator = new CarCreator();
	
	Car[] cars = Cars.CarCreator.getCar();
		
		int startingCapital = 30000;
		
		Car car1 = cars[0];
		Car car2 = cars[1];
		Car car3 = cars[2];
		Car car4 = cars[3];
		Car car5 = cars[4];
		Car car6 = cars[5];
		
		
		public void setPlayerName(String Name){
			
			
			
		}
			
		Player Player1 = new Player(startingCapital, null, car1, null, null, null);
		Player Player2 = new Player(startingCapital, null, car2, null, null, null);
		Player Player3 = new Player(startingCapital, null, car3, null, null, null);
		Player Player4 = new Player(startingCapital, null, car4, null, null, null);
		Player Player5 = new Player(startingCapital, null, car5, null, null, null);
		Player Player6 = new Player(startingCapital, null, car6, null, null, null);

	
	

	

}
