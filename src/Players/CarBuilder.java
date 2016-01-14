package Players;

import java.awt.Color;

import desktop_codebehind.Car;

public class CarBuilder {
	
	public static Car[] getCar(){
		
		Car car1 = new Car.Builder()
				.typeCar()
				.patternHorizontalDualColor()
				.primaryColor(Color.BLUE)
				.secondaryColor(Color.BLUE)
				.build();	
		
		Car car2 = new Car.Builder()
				.typeRacecar()
				.patternHorizontalDualColor()
				.primaryColor(Color.YELLOW)
				.secondaryColor(Color.YELLOW)
				.build();
		
		Car car3 = new Car.Builder()
				.typeTractor()
				.patternHorizontalDualColor()
				.primaryColor(Color.RED)
				.secondaryColor(Color.RED)
				.build();
		
		Car car4 = new Car.Builder()
				.typeUfo()
				.patternHorizontalDualColor()
				.primaryColor(Color.GREEN)
				.secondaryColor(Color.GREEN)
				.build();
		
		Car car5 = new Car.Builder()
				.typeCar()
				.patternHorizontalDualColor()
				.primaryColor(Color.darkGray)
				.secondaryColor(Color.darkGray)
				.build();
		
		Car car6 = new Car.Builder()
				.typeRacecar()
				.patternHorizontalDualColor()
				.primaryColor(Color.MAGENTA)
				.secondaryColor(Color.MAGENTA)
				.build();
		
		Car[] cars = {car1,car2,car3,car4,car5,car6};
		
		return cars;
		
	}

}
