package Game;

public class Die {

	private int dice1;
	private int dice2;
	private int sum;

	// Rolls the die
	public void roll() {

			dice1 = (int) (Math.random() * 6) + 1;
			dice2 = (int) (Math.random() * 6) + 1;

			sum = dice1 + dice2;
	}
	
	/**
	 * Gets the number of the first dice rolled
	 * @return int
	 */
	public int getDice1(){		
		return dice1;
	}
	
	/**
	 * Gets the number of the second dice rolled
	 * @return int
	 */
	public int getDice2(){		
		return dice2;
	}
	
	/**
	 * Get the sum of dice1 and dice2
	 * @return int
	 */
	public int getDiceSum(){		
		return sum;
	}
	
}
