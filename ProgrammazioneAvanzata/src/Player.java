import java.io.*;
import java.util.Scanner;

public class Player {

	private String namePlayer;
	private boolean turn;
	private int value;
	private int countWin = 0;

	public void setName(String NamePlayer) {
		this.setNamePlayer(NamePlayer);
	}

	public void setTurn(boolean Turn) {
		this.turn = Turn;
	}

	public boolean getTurn() {
		return turn;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public void incCountWin() {
		this.countWin++;
	}

	public int getCountWin() {
		return countWin;
	}

	public String getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	

}
