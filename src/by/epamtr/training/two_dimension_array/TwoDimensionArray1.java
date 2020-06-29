package by.epamtr.training.two_dimension_array;

import by.epamtr.training.exception.ValidationException;
import by.epamtr.training.util.ArrayResult;

public class TwoDimensionArray1 {

	public static void printMatrix(int evenMatrixOrder) {
		if (evenMatrixOrder < 0 || evenMatrixOrder % 2 != 0 || evenMatrixOrder == 0) {
			throw new ValidationException("passed argument less then zero or is not even number!");
		}

		int[][] arr = new int[evenMatrixOrder][evenMatrixOrder];

		for (int i = 0; i < evenMatrixOrder; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < evenMatrixOrder; j++) {
					arr[i][j] = j + 1;
				}
			} else {
				for (int j = evenMatrixOrder - 1; j >= 0; j--) {
					arr[i][evenMatrixOrder - 1 - j] = j + 1;
				}
			}
		}
		ArrayResult.printTwoDimensionArrayResult(arr);
	}
}
