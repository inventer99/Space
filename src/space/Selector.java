package space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pixgen.PixGen;

public class Selector extends Entity
{
	private Image image;
	
	public Selector()
	{
		try 
		{
			image = ImageIO.read(new File("res/cursor.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		PixGen.addUpdateableObject(this);
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g)
	{
		((Graphics) g).drawImage(this.image, Math.round(getPosition().getX()), Math.round(getPosition().getY()), 27, 27, null);
	}
}
