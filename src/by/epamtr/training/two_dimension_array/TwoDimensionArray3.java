package by.epamtr.training.two_dimension_array;
import by.epamtr.training.exception.ValidationException;
import by.epamtr.training.util.ArrayResult;

public class TwoDimensionArray3 {

	public static void printMatrix(int evenMatrixOrder) {
		if (evenMatrixOrder < 0 || evenMatrixOrder % 2 != 0 || evenMatrixOrder == 0) {
			throw new ValidationException("passed argument is not even number!");
		}
		int numberLine = 0;
		int[][] array = new int[evenMatrixOrder][evenMatrixOrder];
		for (int i = 0; i < evenMatrixOrder / 2; i++) {
			for (int j = 0; j < evenMatrixOrder; j++) {
				if (j >= numberLine && j < (evenMatrixOrder - numberLine)) {
					array[i][j] = 1;
				}
			}
			numberLine++;
		}
		numberLine--;
		for (int i = evenMatrixOrder / 2; i < evenMatrixOrder; i++) {
			for (int j = 0; j < evenMatrixOrder; j++) {
				if (j >= numberLine & j < (evenMatrixOrder - numberLine)) {
					array[i][j] = 1;
				}
			}
			numberLine--;
		}
		ArrayResult.printTwoDimensionArrayResult(array);
	}

}
