package barrenMoorPackage;

public class TreasureItem extends TileObject {

	public TreasureItem(String itemNameIn) 
	{
		super(itemNameIn);

	}

	public void reaction(Player player) 
	{
		player.obtainTreasure();
	}

}
