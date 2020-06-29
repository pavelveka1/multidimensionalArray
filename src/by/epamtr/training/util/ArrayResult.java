package by.epamtr.training.util;

public class ArrayResult {

	public static void printTwoDimensionArrayResult(int[][] arrayResult) {
		for (int i = 0; i < arrayResult.length; i++) {
			for (int j = 0; j < arrayResult[i].length; j++) {
				System.out.print(arrayResult[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
