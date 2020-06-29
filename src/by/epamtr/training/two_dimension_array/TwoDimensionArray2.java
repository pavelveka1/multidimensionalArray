package by.epamtr.training.two_dimension_array;

import by.epamtr.training.exception.ValidationException;
import by.epamtr.training.util.ArrayResult;

public class TwoDimensionArray2 {

	public static void printMatrix(int evenMatrixOrder) {
		if (evenMatrixOrder < 0 || evenMatrixOrder % 2 != 0 || evenMatrixOrder == 0) {
			throw new ValidationException("passed argument less then zero or is not even number!");
		}

		int[][] array = new int[evenMatrixOrder][evenMatrixOrder];
		for (int i = 0, j = i; i < evenMatrixOrder; i++, j++) {
			array[i][j] = (i + 1) * (i + 2);
		}
		ArrayResult.printTwoDimensionArrayResult(array);
	}
}
