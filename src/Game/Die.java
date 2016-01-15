package Game;

public class Die {

	private static int dice1;
	private static int dice2;
	private static int sum;

	/**
	 * Rolls the dice
	 */
	public void roll() {

			dice1 = (int) (Math.random() * 6) + 1;
			dice2 = (int) (Math.random() * 6) + 1;
dice1=dice2;
			sum = dice1 + dice2;
	}
	
	/**
	 * Gets the number of the first dice rolled
	 * @return int
	 */
	public static int getDice1(){		
		return dice1;
	}
	
	/**
	 * Gets the number of the second dice rolled
	 * @return int
	 */
	public static int getDice2(){		
		return dice2;
	}
	
	/**
	 * Get the sum of dice1 and dice2
	 * @return int
	 */
	public static int getDiceSum(){		
		return sum;
	}	
}
