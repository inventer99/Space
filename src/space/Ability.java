package space;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ability
{
	private Image img;
	
	public Ability(String i)
	{
		try 
		{
			this.img = ImageIO.read(new File(i));
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}

	public Image getImage() 
	{
		return img;
	}

	public void setImage(Image img) 
	{
		this.img = img;
	}
}
