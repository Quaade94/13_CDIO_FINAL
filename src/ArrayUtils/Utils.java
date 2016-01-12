package ArrayUtils;

public class Utils {

	/**
	 * Changes int(s) in an array to another int
	 * 
	 * @param Array
	 *            : The array of int's you want to look through
	 * @param ForReplacement
	 *            : The int(s) in the array you want to replace
	 * @param ToReplaceWith
	 *            : The int you want to replace the other int(s) with
	 * @return The array with changed int(s)
	 */

	public int[] replaceInArray(int[] Array, int ForReplacement, int ToReplaceWith) {

		for (int i = 0; i < Array.length; i++) {

			if (Array[i] == ForReplacement) {

				Array[i] = ToReplaceWith;
			}
		}
		return Array;
	}

	/**
	 * Tells at what positions in the array a specifik int occures
	 * 
	 * @param Array
	 *            : The array of int's you want to look through
	 * @param LookingFor
	 *            : The int you are looking for in the array
	 * @return An array with the positions of the int you were looking for
	 */

	public int[] placesInArrayWithOccurences(int[] Array, int LookingFor) {

		int Occurances = 0;

		for (int i = 0; i < Array.length; i++) {

			if (Array[i] == LookingFor) {
				Occurances++;
			}
		}

		int[] array;
		array = new int[Occurances];

		for (int i = 0, Place = 0; i < Array.length; i++) {

			if (Array[i] == LookingFor) {

				array[Place] = i;
				Place++;
			}
		}
		return array;
	}

}

	
	
	
	
	

