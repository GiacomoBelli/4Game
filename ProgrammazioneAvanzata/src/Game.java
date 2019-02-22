import java.util.Scanner;
import java.io.*;

public class Game {

	public static void main(String[] args) throws IOException {
		Player a = new Player();
		Player b = new Player();
		a.setValue(1);
		b.setValue(2);
		a.setTurn(true);
		a.setTurn(false);
		int min = 1;
		int max = 7;
		int position;
		String input = null;
		int random;
		Scanner in = new Scanner(System.in);
		System.out.println("Write your name");
		a.setNamePlayer(in.next());
		System.out.println("Write your enemy's name");
		b.setNamePlayer(in.next());
		do {
			Matrix x = new Matrix(6, 7);
			System.out.println("Enjoy this game\n");
			x.print_Matrix();
			do {
				do {
					System.out.println("Insert coil position 1 to 7");
					position = in.nextInt();
				} while (x.InputMatrix(position, a) == false);
				if (x.checkWin() == 1) {
					System.out.println("Ha vinto:" + a.getNamePlayer());
					a.incCountWin();
					break;
				}
				do {
					random = (int) (Math.random() * (max - min) + min);
				} while (x.InputMatrix(random, b) == false);
				if (x.checkWin() == 2) {
					System.out.println("Ha vinto: " + b.getNamePlayer());
					b.incCountWin();
					break;
				}
			} while (!x.isFull());

			updateScore(a, b);
		} while (playAgain());

	}

	private static boolean playAgain() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Play again? (Y/N): ");
		String replay = keyboard.nextLine();
		return replay.equalsIgnoreCase("Y");
	}

	private static void updateScore(Player a, Player b) throws IOException {
		BufferedWriter buffer = new BufferedWriter(new FileWriter("Score.txt", true));
		String output = "Human: " + a.getNamePlayer() + " vs " + "Computer: " + b.getNamePlayer() + " "
				+ a.getCountWin() + "-" + b.getCountWin() + "\n";
		buffer.write(output);
		buffer.close();
	}

}
