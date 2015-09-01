package main;

public class Player {
	private static final int DEFAULT_START_VALUE = 2000;
	
	private String name;
	
	private int playerId = -1;
	
	private int money;
	
	private int position;

	private Die die;
	
	public Player(String n,int i) {
		playerId = i;
		name = n;
		money = DEFAULT_START_VALUE;
		position = 0;
		try {
			die = new Die();
		} catch(TooFewDieFacesException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		
		System.out.println(name + " created.");
	}
	
	public void charge(int m,String type) {
		System.out.println("	" + name + " charged " + " for " + type + " $" + m + " new balance $" + (money - m));
		money -= m;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return playerId;
	}
	
	public int getNetworth() {
		return money;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void takeTurn() {
		int roll = die.roll();
		position += roll; 
		
		System.out.println(name + " rolled a " + roll + " and is at position " + position);
	}

}
