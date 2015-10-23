package space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pixeng.Animation;
import pixeng.PixEng;
import pixeng.Settings;
import pixeng.Vector;

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
