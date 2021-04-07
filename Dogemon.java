package javaH2;

import java.util.ArrayList;

public class Dogemon {
	
	static ArrayList<Dogemon> dogelist = new ArrayList<Dogemon>();
	
	int player;
	String Name;
	
	public Dogemon(int player, String name) {
		super();
		this.player = player;
		Name = name;
	}
	
	protected int getPlayer() {
		return player;
	}
	protected void setPlayer(int player) {
		this.player = player;
	}
	protected String getName() {
		return Name;
	}
	protected void setName(String name) {
		Name = name;
	}

}
