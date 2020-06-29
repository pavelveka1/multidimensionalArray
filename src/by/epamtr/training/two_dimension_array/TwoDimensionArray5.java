package by.epamtr.training.two_dimension_array;

import by.epamtr.training.exception.ValidationException;
import by.epamtr.training.util.ArrayResult;

public class TwoDimensionArray5 {

	public static void printMultiplicationMatrix(int[][] firstMatrix, int[][] secondMatrix) {
		validateMatrix(firstMatrix, secondMatrix);
		int[][] resultMatrix = new int[firstMatrix.length][secondMatrix[0].length];
		for (int i = 0; i < resultMatrix.length; i++) {
			for (int j = 0; j < resultMatrix[0].length; j++) {
				int element = 0;
				for (int k = 0; k < firstMatrix[0].length; k++) {
							element = element + firstMatrix[i][k] * secondMatrix[k][j];
						}
					resultMatrix[i][j] = element;
				}
			}
		ArrayResult.printTwoDimensionArrayResult(resultMatrix);
		}
	
	
	private static void validateMatrix(int[][] firstMatrix, int[][] secondMatrix) {
		if (firstMatrix == null || secondMatrix == null) {
			throw new ValidationException("passed argument is null!");
		}
		if (firstMatrix[0].length != secondMatrix.length) {
			throw new ValidationException("matrices can't be multiplied!");
		}
		for(int i=1; i<firstMatrix.length;i++) {
			if(firstMatrix[0].length!=firstMatrix[i].length) {
				throw new ValidationException("matrices can't be multiplied: firstMatrix is ​​a torn array");
			}
		}
		for(int i=1; i<secondMatrix.length;i++) {
			if(secondMatrix[0].length!=secondMatrix[i].length) {
				throw new ValidationException("matrices can't be multiplied: secondMatrix is ​​a torn array");
			}
		}
		
	}
	
	}
