package barrenMoorPackage;

import java.util.Random;

public class MapTile 
{
	
	private int xPosition;
	private int yPosition;
	private TileObject tileItem = null;
	private String tileDescription;

	public String getTileDescription()
	{
		return tileDescription;
	}
	
	public MapTile(int x, int y)
	{
		xPosition = x;
		yPosition = y;
		Random random = new Random();
		switch(random.nextInt(10))
		{
		case 0: case 1: case 2: case 3: case 4:
			tileDescription = "This area is a fetid swamp, with a pungent aroma";
			break;
		case 5: 
			tileDescription = "This area is surprisingly pleasant, with rolling grassy hills intersected by a flowing stream";
			break;
		case 6: 
			tileDescription = "This area is lightly wooded, a faint howling noise can be heard as the wind blows through the trees";
			break;
		case 7:
			tileDescription = "This area is a graveyard. Skulls litter the ground, and the fog swirls around menacingly";
			break;
		case 8:
			tileDescription = "This area is deadly. The ground underfoot can give way at any moment, pluging you into deep water";
			break;
		case 9: 
			tileDescription = "This area is so foggy it is impossible to see more than a foot in front of you at a time";
			break;
		}
	}
	
	public void addItem(TileObject inItem)
	{
		tileItem = inItem;
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

	public TileObject getTileItem() {
		return tileItem;
	}

	public void setTileItem(TileObject tileItem) {
		this.tileItem = tileItem;
	}

}
