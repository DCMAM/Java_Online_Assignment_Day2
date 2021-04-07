package javaH2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	Scanner input = new Scanner(System.in);
	char[][] map = new char[10][20];
	
	int playerRow, playerCol;
	int dogeBall = 5;
	int totalPlayer = 0;
	
	static ArrayList<String> grassList = new ArrayList<>();
	static ArrayList<String> dogemonList = new ArrayList<>();
	
	public Main() {
		do{
			cls();
			printMenu();
			String menu = input.nextLine();
			if(menu.equals("1")) {
				totalPlayer++;
				newGame();
			}
			else if(menu.equals("2")) {
				loadGame();
			}
			else if(menu.equals("3")) {
				printMenu3();
			}
			else if(menu.equals("4")) {
				break;
			}
		}while(true);
	}
	
	public void loadGame() {
		String name;
		System.out.print("input name: ");
		name = input.nextLine();
		String password;
		System.out.print("Input password: ");
		password = input.nextLine();
		for (int i = 0; i < Player.playerlist.size(); i++) {
			if(Player.playerlist.get(i).getUsername().equals(name)) {
				if(Player.playerlist.get(i).getPassword().equals(password)) {
					generateMap();
					map[Player.playerlist.get(i).getPlayerRow()][Player.playerlist.get(i).getPlayerCol()] = '*';
					playerRow = Player.playerlist.get(i).getPlayerRow();
					playerCol = Player.playerlist.get(i).getPlayerCol();
					map[4][10] = 'O';
					for (int j = 0; j < Grass.list.size(); j++) {
						if(Grass.list.get(j).getPlayer() == i) {
							map[Grass.list.get(j).getX()][Grass.list.get(j).getY()] = 'V';
						}
					}
					do {
						cls();
						printMap();
						System.out.print("> ");
						char ch = input.nextLine().charAt(0);
						updatePlayer(ch);
						if(ch == 'q') {
							Player.playerlist.get(totalPlayer-1).setDogeBall(dogeBall);
							Player.playerlist.get(totalPlayer-1).setPlayerRow(playerRow);
							Player.playerlist.get(totalPlayer-1).setPlayerCol(playerCol);
							break;
						}
					}while(true);
				}
			}
		}
	}
	
	public void newGame() {
		generateMap();
		map[8][18] = '*';
		map[4][10] = 'O';
		playerRow = 8;
		playerCol = 18;
		generateGrass();
//		printMap();
		String username, password;
		do {
			System.out.print("Input username: ");
			username = input.next();			
		}while(username.length()<1);
		for (int i = 0; i < Player.playerlist.size(); i++) {
			if(Player.playerlist.get(i).getUsername().equals(username)) {
				return;
			}
		}
		do {
			System.out.print("Input password: ");
			password = input.nextLine();			
		}while(password.length()<1);
		Player np = new Player(username, password, 5, 8, 18);
		Player.playerlist.add(np);
		do {
			cls();
			printMap();
			System.out.print("> ");
			char ch = input.next().charAt(0); input.nextLine();
			updatePlayer(ch);
			if(ch == 'q') {
				Player.playerlist.get(totalPlayer-1).setDogeBall(dogeBall);
				Player.playerlist.get(totalPlayer-1).setPlayerRow(playerRow);
				Player.playerlist.get(totalPlayer-1).setPlayerCol(playerCol);
				break;
			}
		}while(true);
	}
	
	public void gamePlay() {
		System.out.println("You've encountered a Dogemon!");
		System.out.println("My Dogeball: " + dogeBall);
		System.out.println("What will you do?");
		System.out.println("1. Throw Dogeball\t2.Flee");
		System.out.print("> ");
		String option = input.nextLine();
		if(option.equals("1")) {
			if(dogeBall > 0) {
				dogeBall--;
				int random = (int)(Math.random()*10);
				if(random <= 7) {
					System.out.println("you missed!");
					int random2 = (int)(Math.random()*100);
					if(random2 <= 15) {
						System.out.println("The Dogemon has fled!");
					}
				}
				else {
					System.out.println("Congratulation! You've caught a Dogemon!");
					String dogeName;
					System.out.print("Please enter Dogemon name: ");
					dogeName = input.nextLine();
					Dogemon nd = new Dogemon(totalPlayer, dogeName);
					Dogemon.dogelist.add(nd);
				}
			}
		}
		else {
			return;
		}
	}
	
	public void dogeStop() {
		System.out.println("You've arrived at Dogestop.");
		System.out.println("Would you like to restore DogeBall?");
		System.out.println("1. Yes\t2.No");
		System.out.print(">> ");
		String option = input.nextLine();
		if(option.equals("1")) {
			dogeBall = 10;
		}
		else {
			return;
		}
	}
	
	public void updatePlayer(char ch) {
		if(ch == 'w' && map[playerRow-1][playerCol] != '=' && map[playerRow-1][playerCol] != '+' && map[playerRow-1][playerCol] != '|') {
			if(map[playerRow-1][playerCol] == 'O') {
				dogeStop();
				return;
			}
			if(map[playerRow-1][playerCol] == 'V') {
				int randomNum = (int)(Math.random()*10);
				if(randomNum <= 4) {
					gamePlay();
				}
				return;
			}
			map[playerRow][playerCol] = ' ';
			playerRow = playerRow - 1;
			map[playerRow][playerCol] = '*';
		}
		else if(ch == 'a' && map[playerRow][playerCol-1] != '=' && map[playerRow][playerCol-1] != '+' && map[playerRow][playerCol-1] != '|') {
			if(map[playerRow][playerCol-1] == 'O') {
				dogeStop();
				return;
			}
			if(map[playerRow][playerCol-1] == 'V') {
				int randomNum = (int)(Math.random()*10);
				if(randomNum <= 4) {
					gamePlay();
				}
				return;
			}
			map[playerRow][playerCol] = ' ';
			playerCol = playerCol - 1;
			map[playerRow][playerCol] = '*';
		}
		else if(ch == 's' && map[playerRow+1][playerCol] != '=' && map[playerRow+1][playerCol] != '+' && map[playerRow+1][playerCol] != '|') {
			if(map[playerRow+1][playerCol] == 'O') {
				dogeStop();
				return;
			}
			if(map[playerRow+1][playerCol] == 'V') {
				int randomNum = (int)(Math.random()*10);
				if(randomNum <= 4) {
					gamePlay();
				}
				return;
			}
			map[playerRow][playerCol] = ' ';
			playerRow = playerRow + 1;
			map[playerRow][playerCol] = '*';
		}
		else if(ch == 'd' && map[playerRow][playerCol+1] != '=' && map[playerRow][playerCol+1] != '+' && map[playerRow][playerCol+1] != '|') {
			if(map[playerRow][playerCol+1] == 'O') {
				dogeStop();
				return;
			}
			if(map[playerRow][playerCol+1] == 'V') {
				int randomNum = (int)(Math.random()*10);
				if(randomNum <= 4) {
					gamePlay();
				}
				return;
			}
			map[playerRow][playerCol] = ' ';
			playerCol = playerCol + 1;
			map[playerRow][playerCol] = '*';
		}
		else if(ch == 'p') {
			System.out.println("Username : "+Player.playerlist.get(totalPlayer-1).getUsername());
			System.out.println("Password : "+Player.playerlist.get(totalPlayer-1).getPassword());
			System.out.println("Dogeball : "+Player.playerlist.get(totalPlayer-1).getDogeBall());
		}
	}
	
	public void generateGrass() {
		for (int i = 0; i < 20; ) {
			int row = (int)(Math.random()*9);
			int col = (int)(Math.random()*19);
			if(map[row][col] != '+' && map[row][col] != '=' && map[row][col] != '|' 
			&& map[row][col] != 'V' && map[row][col] != 'O' && map[row][col] != '*') {
				map[row][col] = 'V';
				Grass ng = new Grass(row, col, totalPlayer-1);
				Grass.list.add(ng);
				i++;
			}
		}
	}
	
	public void generateMap() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				if(i==0) {
					map[i][j] = '=';
				}
				else if(j==0) {
					map[i][j] = '|';
				}
				else if(i==9) {
					map[i][j] = '=';
				}
				else if(j==19) {
					map[i][j] = '|';
				}
				else {
					map[i][j] = ' ';
				}
			}
			map[0][0] = '+';
			map[0][19] = '+';
			map[9][0] = '+';
			map[9][19] = '+';
		}
	}
	
	public void printMap() {
		for (int i = 0; i < 10; i++) {
			System.out.println(map[i]);
		}
	}
	
	public void printMenu() {
		System.out.println("1. New Game");
		System.out.println("2. Load Game");
		System.out.println("3. How to Play");
		System.out.println("4. Exit");
		System.out.print(">> ");
	}
	
	public void printMenu3() {
		System.out.println("Welcome to the world of Dogemon");
		System.out.println("In this world, your goal is to collect as many Dogeman as possible");
		System.out.println("==============================================================================");
		System.out.println("Your character is denoted by '*' on the map. User [W|A|S|D] to move around");
		System.out.println("You are given 5 Dogebal at the start of the game, user them to capture Dogemon");
		System.out.println("Dogemon can be found in GRASSES denoted by 'v' on the map");
		System.out.println("If you ever run out of Dogeball, visit DOGESTOP ('O') at the center of the map");
	}
	
	private void cls() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
