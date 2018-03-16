package barrenMoorPackage;

public class HealthItem extends TileObject 
{

	public HealthItem(String itemNameIn, int healAmountIn) 
	{
		super(itemNameIn);
		healAmount = healAmountIn;
	}
	
	public void reaction(Player player)
	{
		player.changeHealth(healAmount);
		System.out.println("You found a medical kit, and patched yourself up");
	}
	
	private int healAmount = 20;

}
