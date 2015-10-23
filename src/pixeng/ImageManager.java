package pixeng;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageManager 
{
	private HashMap<String, Image> images = new HashMap<String, Image>();
	
	public void addImage(String name, String path)
	{
		if(!images.containsKey(name))
		{
			try 
			{
				Image image = ImageIO.read(new File(path));
				images.put(name, image);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public Image getImage(String name)
	{
		return images.get(name);
	}
}
