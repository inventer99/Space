package space.body;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import pixeng.PixEng;
import space.Entity;

public class SpaceBody extends Entity
{
	private String renderkey;
	
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
		Image image = PixEng.getImageManager().getImage(getRenderkey());
		((Graphics) g).drawImage(image, Math.round(getRenderpos().getX() - image.getWidth(null) * 3 / 2), Math.round(getRenderpos().getY() - image.getHeight(null) * 3 / 2), image.getWidth(null) * 3, image.getHeight(null) * 3, null);
	}

	public String getRenderkey() 
	{
		return renderkey;
	}
	
	public void setRenderkey(String renderkey) 
	{
		this.renderkey = renderkey;
	}
}
