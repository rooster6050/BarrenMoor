package barrenMoorPackage;

public class Monster extends TileObject {

	private int damage;
	
	public Monster(String itemNameIn, int damageIn) 
	{
		super(itemNameIn);
		damage = damageIn;
	}

	@Override
	public void reaction(Player player) 
	{
		player.changeHealth(-damage);
		System.out.println("You ran into a monster: " + getItemName() + " and fought him off, but were wounded in the process");
	}

}
