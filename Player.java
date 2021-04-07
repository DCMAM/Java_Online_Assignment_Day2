package javaH2;

import java.util.ArrayList;

public class Player {
	String username, password;

	int dogeBall, playerRow, playerCol;
	
	static ArrayList<Player> playerlist = new ArrayList<Player>();

	public Player(String username, String password, int dogeBall, int playerRow, int playerCol) {
		super();
		this.username = username;
		this.password = password;
		this.dogeBall = dogeBall;
		this.playerRow = playerRow;
		this.playerCol = playerCol;
	}

	protected String getUsername() {
		return username;
	}
	
	protected void setUsername(String username) {
		this.username = username;
	}
	
	protected String getPassword() {
		return password;
	}
	
	protected void setPassword(String password) {
		this.password = password;
	}

	protected int getDogeBall() {
		return dogeBall;
	}

	protected void setDogeBall(int dogeBall) {
		this.dogeBall = dogeBall;
	}

	protected int getPlayerRow() {
		return playerRow;
	}

	protected void setPlayerRow(int playerRow) {
		this.playerRow = playerRow;
	}

	protected int getPlayerCol() {
		return playerCol;
	}

	protected void setPlayerCol(int playerCol) {
		this.playerCol = playerCol;
	}
	
	
	
}
