package by.epamtr.training.two_dimension_array;

public class MagicSquare {

	public static void main(String[] args) {

		printMagicSquare(6);
	}

	public static void printMagicSquare(int order) {

		if (order < 3) {
			System.out.println("Магический квадрат с порядком меньше 3 не существует");
		} else if (order % 4 == 0) {
			printSquare(buildMultipleFourSquare(order));
		} else if (order % 2 != 0) {
			printSquare(buildOddSquare(order));
		} else {
			printSquare(buildEvenOddOrderSquare(order));
		}
	}

	// индийский метод для нечетного порядка
	private static int[][] buildOddSquare(int order) {
		int[][] array = new int[order][order];
		int numberLine = 0;
		int numberElement = (order - 1) / 2;
		// верхняя строка, средний элемент = 1
		array[numberLine--][numberElement++] = 1;

		for (int value = 2; value <= (order * order); value++, numberLine--, numberElement++) {
			if ((numberLine < 0) && (numberElement > (order - 1))) {
				numberLine = numberLine + 2;
				numberElement = numberElement - 1;
			} else if (numberLine < 0) {
				numberLine = order - 1;
			} else if (numberElement > (order - 1)) {
				numberElement = 0;
			}

			if (array[numberLine][numberElement] == 0) {
				array[numberLine][numberElement] = value;
			} else {
				numberLine = numberLine + 2;
				numberElement = numberElement - 1;
				array[numberLine][numberElement] = value;
			}
		}
		return array;
	}

	public static void printSquare(int[][] magicSquare) {
		for (int i = 0; i < magicSquare.length; i++) {
			for (int j = 0; j < magicSquare.length; j++) {
				System.out.print(magicSquare[i][j] + "       ");
			}
			System.out.println();
			System.out.println();
		}
	}

	// метод Рауз-Болла для порядка кратного 4
	private static int[][] buildMultipleFourSquare(int order) {
		int buf;
		int[][] array = new int[order][order];
		for (int i = 0; i < order; i++) {
			for (int j = 0; j < order; j++) {
				array[i][j] = i * order + j + 1;
			}
		}
		for (int i = 0, j = 0; i <= order / 2 - 1; i++, j++) {
			buf = array[i][j];
			array[i][j] = array[order - 1 - i][order - 1 - j];
			array[order - 1 - i][order - 1 - j] = buf;

			buf = array[i][order - 1 - j];
			array[i][order - 1 - j] = array[order - 1 - i][j];
			array[order - 1 - i][j] = buf;
		}
		int baseOrder = 4;
		if (order > 4) {
			while (baseOrder < (order - 1)) {
				for (int i = 0, j = baseOrder; j <= order - 1; i++, j++) {
					buf = array[i][j];
					array[i][j] = array[order - 1 - i][order - 1 - j];
					array[order - 1 - i][order - 1 - j] = buf;
				}
				for (int i = 0, j = baseOrder - 1; j >= 0; i++, j--) {
					buf = array[i][j];
					array[i][j] = array[order - 1 - i][order - 1 - j];
					array[order - 1 - i][order - 1 - j] = buf;
				}
				baseOrder = baseOrder + 4;
			}
		}
		return array;
	}

	// метод окаймленных квадратов четно-нечетного порядка
	private static int[][] buildEvenOddOrderSquare(int order) {

		int[][] multipleFoutOrderArray = buildMultipleFourSquare(order - 2);
		// увеличиваем все элементы полученного массива на 2(n-1)
		for (int i = 0; i < order-2; i++) {
			for (int j = 0; j < order-2; j++) {
				multipleFoutOrderArray[i][j] = multipleFoutOrderArray[i][j] + 2 * (order - 1);
			}
		}
	
		int[][] evenOddArray = new int[order][order];
		for (int i = 1; i < order - 1; i++) {
			for (int j = 1; j < order - 1; j++) {
				evenOddArray[i][j] =  multipleFoutOrderArray[i-1][j-1];
			}
		}
		// заполняем угловые ячейки
		final int variable1 = order / 2;
		final int variable2 = order * order + 1;
		evenOddArray[0][0] = 3 * variable1 - 1;
		evenOddArray[0][order - 1] = 1;
		evenOddArray[order - 1][0] = variable2 - 1;
		evenOddArray[order - 1][order - 1] = variable2 - 3 * variable1 + 1;
		// заполняем верхнюю и нижнюю строки
		int t = 1;
		for (int j = 1; j < order - 1; j++) {
			if (j <= variable1) {
				evenOddArray[0][j] = variable2 - 2 * j;
				evenOddArray[order - 1][j] = (order * order + 1) - evenOddArray[0][j];
			} else if (t <= variable1 - 2) {
				evenOddArray[0][j] = 2 * t + 1;
				evenOddArray[order - 1][j] = (order * order + 1) - evenOddArray[0][j];
				t++;
			}
		}
		// заполняем левый и правый столбец
		int n = variable1 / 2;
		int q = 1;
		int l = 1;
		int p = 1;
		for (int i = 1; i < order - 1; i++) {
			if (q <= n - 1) {
				evenOddArray[i][0] = variable2 - 2 * variable1 - q;
				evenOddArray[i][order - 1] = (order * order + 1) - evenOddArray[i][0];
				q++;
			} else if (p <= n) {
				evenOddArray[i][0] = 3 * variable1 - 1 - p;
				evenOddArray[i][order - 1] = (order * order + 1) - evenOddArray[i][0];
				p++;
			} else if (l <= n + 1) {
				evenOddArray[i][0] = variable2 - 4 * variable1 + 1 + l;
				evenOddArray[i][order - 1] = (order * order + 1) - evenOddArray[i][0];
				l++;
			} else {
				evenOddArray[i][0] = 2 * variable1 - 1;
				evenOddArray[i][order - 1] = (order * order + 1) - evenOddArray[i][0];
			}
		}

		return evenOddArray;
	}
}
