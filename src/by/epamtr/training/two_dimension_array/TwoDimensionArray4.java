package by.epamtr.training.two_dimension_array;

import by.epamtr.training.exception.ValidationException;
import by.epamtr.training.util.ArrayResult;

public class TwoDimensionArray4 {

	public static void printMatrix(int[] array) {
		if (array == null) {
			throw new ValidationException("passed argument is null!");
		}
		int[][] resultArray = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				resultArray[i][j] = (int) Math.pow(array[j], i + 1);
			}
		}
		ArrayResult.printTwoDimensionArrayResult(resultArray);
	}

}
