package javaH2;

import java.util.ArrayList;

public class Grass {
	
	static ArrayList<Grass> list = new ArrayList<Grass>();
	
	int x, y, player;
	
	public Grass(int x, int y, int player) {
		super();
		this.x = x;
		this.y = y;
		this.player = player;
	}

	protected int getX() {
		return x;
	}

	protected void setX(int x) {
		this.x = x;
	}

	protected int getY() {
		return y;
	}


	protected void setY(int y) {
		this.y = y;
	}

	protected int getPlayer() {
		return player;
	}

	protected void setPlayer(int player) {
		this.player = player;
	}
}
