import java.io.*;

public class Matrix extends Player {

	private int rows;
	private int cols;
	public int[][] Mat;

	Matrix(int r, int c) {
		rows = r;
		cols = c;
		Mat = new int[rows][cols];
	}

	public boolean InputMatrix(int Position, Player p) {

		int possibleRow = rows - 1;
		int selectedColumn = Position - 1;
		// if all column is full
		if (Mat[0][selectedColumn] != 0) {
			return false;
		} else {
			while (true) {
				if (Mat[possibleRow][selectedColumn] == 0) {
					Mat[possibleRow][selectedColumn] = p.getValue();
					break;
				} else {
					possibleRow--;
				}
			}
		}

		print_Matrix();
		return true;
	}

	public int checkWin() {
		final int HEIGHT = rows;
		final int WIDTH = cols;
		final int EMPTY_SLOT = 0;
		for (int r = 0; r < HEIGHT; r++) { // iterate rows, bottom to top
			for (int c = 0; c < WIDTH; c++) { // iterate columns, left to right
				int player = Mat[r][c];
				if (player == EMPTY_SLOT)
					continue; // don't check empty slots

				if (c + 3 < WIDTH && player == Mat[r][c + 1] && // look right
						player == Mat[r][c + 2] && player == Mat[r][c + 3])
					return player;
				if (r + 3 < HEIGHT) {
					if (player == Mat[r + 1][c] && // look up
							player == Mat[r + 2][c] && player == Mat[r + 3][c])
						return player;
					if (c + 3 < WIDTH && player == Mat[r + 1][c + 1] && // look up & right
							player == Mat[r + 2][c + 2] && player == Mat[r + 3][c + 3])
						return player;
					if (c - 3 >= 0 && player == Mat[r + 1][c - 1] && // look up & left
							player == Mat[r + 2][c - 2] && player == Mat[r + 3][c - 3])
						return player;
				}
			}
		}
		return EMPTY_SLOT; // no winner
	}

	public void print_Matrix() {
		System.out.println();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.flush();
				System.out.print(Mat[i][j] + " ");
			}
			System.out.println();
		}

	}

	//
	public boolean isFull() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				if (Mat[i][j] == 0)
					return false;
		return true;
	}

}
