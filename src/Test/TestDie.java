package Test;

import Game.Die;

public class TestDie extends Die{

	private static int dice1;
	private static int dice2;
	private static int sum;

	@Override
	public void roll() {

			dice1 = 3;
			dice2 = 3;

			sum = dice1 + dice2;
	}
	public static int getDiceSum(){		
		return sum;
	}

}
