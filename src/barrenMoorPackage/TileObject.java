package barrenMoorPackage;

public abstract class TileObject 
{

	private String itemName;
	private boolean hasBeenUsed;
	private int xPosition;
	private int yPosition;
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isHasBeenUsed() {
		return hasBeenUsed;
	}

	public void setHasBeenUsed(boolean hasBeenUsed) {
		this.hasBeenUsed = hasBeenUsed;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public TileObject(String itemNameIn)
	{
		itemName = itemNameIn;
		hasBeenUsed = false;
	}
	
	public abstract void reaction(Player player);
	
}
