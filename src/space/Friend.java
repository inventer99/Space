package space;

import java.awt.Graphics;
import java.awt.Graphics2D;

import pixgen.PixGen;

public class Friend extends PlayableEntity
{
	private String username = "";
	
	public Friend()
	{	
		PixGen.getImageManager().addImage("friend", "res/player/player_1.png");
		
		PixGen.addUpdateableObject(this);
	}
	
	public void update() 
	{	
		super.update();
	}
	
	public void render(Graphics2D g)
	{
		((Graphics) g).drawImage(PixGen.getImageManager().getImage("friend"), Math.round(getRenderpos().getX()), Math.round(getRenderpos().getY()), 90, 120, null);
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}
}
