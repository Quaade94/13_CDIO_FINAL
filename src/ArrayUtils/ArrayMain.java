package ArrayUtils;

import java.util.Arrays;

public class ArrayMain {

		public static void main(String[] args) {

			Utils Utils = new Utils();

			int[] Array = { -1, 1, 1, 10, -1, 1, 2, -1, 0, -1 };

			// int ForReplacement = -1;
			// int ToReplaceWith = 4;

			// System.out.println("Array before change = " +
			// Arrays.toString(Array));
			//
			// int[] NewArray = Utils.replaceInArray(Array, ForReplacement,
			// ToReplaceWith);
			//
			// System.out.println("Array after change = " +
			// Arrays.toString(NewArray));

			System.out.println("************************************************");

			int LookingFor = 1;

			System.out.println("Array before change = " + Arrays.toString(Array));

			int[] NewNewArray = Utils.placesInArrayWithOccurences(Array, LookingFor);

			System.out.println("Array after change = " + Arrays.toString(NewNewArray));

		}

	}

	
	
	

