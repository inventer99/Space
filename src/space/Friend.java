package space;

import java.awt.Graphics;
import java.awt.Graphics2D;

import pixeng.PixEng;

public class Friend extends Entity
{
	public Friend()
	{	
		PixEng.getImageManager().addImage("friend", "res/player/player_1.png");
		
		PixEng.addUpdateableObject(this);
	}
	
	public void update() 
	{	
		super.update();
	}
	
	public void render(Graphics2D g)
	{
		((Graphics) g).drawImage(PixEng.getImageManager().getImage("friend"), Math.round(getRenderpos().getX()), Math.round(getRenderpos().getY()), 90, 120, null);
	}
}
