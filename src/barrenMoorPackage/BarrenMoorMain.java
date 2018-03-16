package barrenMoorPackage;



public class BarrenMoorMain {
	
	static Map map = new Map(4);
	static Player player = new Player();
	
	public static void initGame()
	{	
		player.setxPosition(4);
		player.setyPosition(4);
		System.out.println("You find yourself in a murky swamp, fog clouds around you restricting your vision");
		System.out.println("You can feel an object in your pocket pressing against you, you reach in and find a compass");
		System.out.println("Strangely instead of pointing north, the compass seems to rotate wildly as you move");
		System.out.println("You decide to attempt to escape, enter n, e, s or w to move, or q to quit");
	}

	public static void gameLoop()
	{
		while(player.directionInput()!='q')
		{
			if(player.getPlayerDirection()=='t')
			{
				map.debugInfo(player);
			}
			if(player.move())
			{
			map.updateMap(player);
			map.findClosestItem(player);
			map.checkTile(player);
			if(player.gethasTreasure())
			{
				System.out.println("You found the treasure and escaped! You win!");
				break;
			}
			if(player.getHealth()<=0)
			{
				System.out.println("You died. RIP");
				break;
			}
			}
			else System.out.println("Not a valid input, please try again");
		}
	}
	public static void main(String[] args) 
	{
		
		initGame();
		gameLoop();
		
	}

}
