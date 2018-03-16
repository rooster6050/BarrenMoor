package barrenMoorPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Map 
{
	
	private ArrayList<MapTile> map = new ArrayList<>();
	private ArrayList<TileObject> currentItems = new ArrayList<>();
	private int defaultVisionRange = 2;
	private int gridSize;
	Random random = new Random();
	
	public Map()
	{
		gridSize=(2*defaultVisionRange)+1;
		for(int i=0;i<gridSize;i++)
		{
			for(int j=0;j<gridSize;j++)
			{
				map.add(new MapTile(i,j));
			}
		}
		TileObject temp = genItem();
		MapTile tempTile =map.get(random.nextInt(map.size()));
		tempTile.addItem(temp);
		temp.setxPosition(tempTile.getxPosition());
		temp.setyPosition(tempTile.getyPosition());
		currentItems.add(temp);
	}
	
	public Map(int visionRange)
	{
		gridSize=(2*visionRange)+1;
		defaultVisionRange=visionRange;
		for(int i=0;i<gridSize;i++)
		{
			for(int j=0;j<gridSize;j++)
			{
				map.add(new MapTile(i,j));
			}
		}
		TileObject temp = genItem();
		MapTile tempTile =map.get(random.nextInt(map.size()));
		tempTile.addItem(temp);
		temp.setxPosition(tempTile.getxPosition());
		temp.setyPosition(tempTile.getyPosition());
		currentItems.add(temp);
	}
	
	public void removeTilesByX(int x)
	{
		Iterator<MapTile> temp = map.iterator();
		while(temp.hasNext())
		{
			MapTile tile = temp.next();
			if(tile.getyPosition()==x)
			{
				if(tile.getTileItem()!=null)
				{
					currentItems.remove(tile.getTileItem());
					tile.setTileItem(null);
				}
				temp.remove();
			}
		}
	}
	
	public void removeTilesByY(int y)
	{
		Iterator<MapTile> temp = map.iterator();
		while(temp.hasNext())
		{
			MapTile tile = temp.next();
			if(tile.getyPosition()==y)
			{
				if(tile.getTileItem()!=null)
				{
					currentItems.remove(tile.getTileItem());
					tile.setTileItem(null);
				}
				temp.remove();
			}
		}
	}
	
	public void createTilesByX(int x, int y)
	{
		int itemPos;
		itemPos=random.nextInt(gridSize);
		for(int i=0;i<gridSize;i++)
		{
			map.add(new MapTile(x, y+i));
			if(currentItems.isEmpty() && itemPos==i)
			{
				TileObject temp = genItem();
				temp.setxPosition(map.get(map.size()-1).getxPosition());
				temp.setyPosition(map.get(map.size()-1).getyPosition());
				currentItems.add(temp);
				map.get(map.size()-1).addItem(temp);
			}
		}
	}
	
	public void createTilesByY(int x, int y)
	{
		int itemPos;
		itemPos=random.nextInt(gridSize);
		for(int i=0;i<gridSize;i++)
		{
			map.add(new MapTile(x+i, y));
			if(currentItems.isEmpty() && itemPos==i)
			{
				TileObject temp = genItem();
				temp.setxPosition(map.get(map.size()-1).getxPosition());
				temp.setyPosition(map.get(map.size()-1).getyPosition());
				currentItems.add(temp);
				map.get(map.size()-1).addItem(temp);
			}
		}
	}
	
	public void updateMap(Player player)
	{
		switch(player.getPlayerDirection())
		{
		case 'n':
			removeTilesByY(player.getyPosition()-(defaultVisionRange+1));
			createTilesByY(player.getxPosition()-defaultVisionRange, player.getyPosition()+defaultVisionRange);
			break;
		case 's':
			removeTilesByY(player.getyPosition()+(defaultVisionRange+1));
			createTilesByY(player.getxPosition()-defaultVisionRange, player.getyPosition()-defaultVisionRange);
			break;
		case 'e':
			removeTilesByX(player.getxPosition()-(defaultVisionRange+1));
			createTilesByX(player.getxPosition()+defaultVisionRange, player.getyPosition()-defaultVisionRange);
			break;
		case 'w':
			removeTilesByX(player.getxPosition()+(defaultVisionRange+1));
			createTilesByX(player.getxPosition()-defaultVisionRange, player.getyPosition()-defaultVisionRange);
			break;
			default: break;
		}
	}
	
	public void checkTile(Player player)
	{
		for(MapTile temp:map)
		{
			if(temp.getxPosition()==player.getxPosition()&&temp.getyPosition()==player.getyPosition())
			{
				System.out.println(temp.getTileDescription());
				if(temp.getTileItem()!=null)
				{
					currentItems.remove(temp.getTileItem());
					temp.getTileItem().reaction(player);		
					temp.setTileItem(null);
				}
			}
		}
	}
	
	public void displayMap()
	{
		for(MapTile temp:map)
		{
			System.out.println("X: " + temp.getxPosition() + " Y: " + temp.getyPosition());
		}
	}
	
	public void findClosestItem(Player player)
	{
		double distance =100;
		for(TileObject temp:currentItems)
		{
			if(Math.sqrt(Math.pow(player.getxPosition()-temp.getxPosition(), 2) + Math.pow(player.getyPosition()-temp.getyPosition(), 2))<distance)
			{		
				distance = Math.sqrt(Math.pow(player.getxPosition()-temp.getxPosition(), 2) + Math.pow(player.getyPosition()-temp.getyPosition(), 2));
			}
		}
		String num = String.format("%.2f",distance);
		System.out.println("Closest tile of interest is: " + num + " meters away" );
	}
	
	public TileObject genItem()
	{
		switch(random.nextInt(5))
		{
		case 0: return new HealthItem("healthpack", 20);
		case 1: return new TreasureItem("Treasure");
		case 2: case 3: case 4: switch(random.nextInt(5))
				{
			case 0: return new Monster("Shrek", 10);
			case 1: return new Monster("Dragon", 30);
			case 2: return new Monster("Vampire", 15);
			case 3: return new Monster("Goblin", 5);
			case 4: return new Monster("Angry Chicken", 1);
				}
		default: 
			System.out.println("Something broke");
			return null;
		}
	}
	
	public void debugInfo(Player player)
	{
		System.out.println("Player X: " +player.getxPosition()+ " Player Y: "+ player.getyPosition());
		System.out.println("Object X:" + currentItems.get(0).getxPosition() + " Object Y: " + currentItems.get(0).getyPosition());
		for(MapTile temp:map)
		{
			if(temp.getxPosition()==player.getxPosition()&&temp.getyPosition()==player.getyPosition())
			{
				System.out.println(temp.getTileItem()+"Something");
			}
		}
	}

}
