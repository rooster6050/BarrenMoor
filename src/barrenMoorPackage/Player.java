package barrenMoorPackage;

import java.util.Scanner;

public class Player 
{
	
	private String name;
	private int health =50;
	private int xPosition;
	private int yPosition;
	private char playerDirection;
	private boolean hasTreasure = false;
	static private Scanner sc = new Scanner(System.in);
	
	public void obtainTreasure()
	{
		hasTreasure = true;
	}
	
	public boolean gethasTreasure()
	{
		return hasTreasure;
	}
	
	public char directionInput()
	{
		return playerDirection = sc.nextLine().charAt(0);
	}
	
	public char getPlayerDirection() 
	{
		return playerDirection;
	}

	public void setPlayerDirection(char playerDirection) 
	{
		this.playerDirection = playerDirection;
	}

	public void changeHealth(int change)
	{
		health+=change;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getHealth() 
	{
		return health;
	}

	public void setHealth(int health) 
	{
		this.health = health;
	}

	public int getxPosition() 
	{
		return xPosition;
	}

	public void setxPosition(int xPosition) 
	{
		this.xPosition = xPosition;
	}

	public int getyPosition() 
	{
		return yPosition;
	}

	public void setyPosition(int yPosition) 
	{
		this.yPosition = yPosition;
	}
	
	public boolean move()
	{
		switch (playerDirection)
		{
		case 'n': 
			yPosition++;
			System.out.println("You move north");
			return true;
		case 's':
			yPosition--;
			System.out.println("You move south");
			return true;
		case 'w':
			xPosition--;
			System.out.println("You move west");
			return true;
		case 'e':
			xPosition++;
			System.out.println("You move east");
			return true;
		default: 
			return false;
		}
	}
	
}
