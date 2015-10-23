package space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import pixeng.ImageManager;
import pixeng.PixEng;

public class SpaceBody extends Entity
{
	protected String renderkey;
	
	public SpaceBody(String imgkey, String path)
	{
		renderkey = imgkey;
		PixEng.getImageManager().addImage(imgkey, path);
		
		PixEng.addUpdateableObject(this);
	}
	
	public void update()
	{
		super.update();
	}
	
	public void render(Graphics2D g)
	{
		Image image = PixEng.getImageManager().getImage(renderkey);
		((Graphics) g).drawImage(image, Math.round(getRenderpos().getX() - image.getWidth(null) * 3 / 2), Math.round(getRenderpos().getY() - image.getHeight(null) * 3 / 2), image.getWidth(null) * 3, image.getHeight(null) * 3, null);
	}
}
