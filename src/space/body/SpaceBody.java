package space.body;

import java.awt.Graphics2D;
import java.awt.Image;

import pixgen.PixGen;
import space.Entity;

public class SpaceBody extends Entity
{
	private String renderkey;
	
	public SpaceBody(String imgkey, String path)
	{
		renderkey = imgkey;
		PixGen.getImageManager().addImage(imgkey, path);
		
		PixGen.addUpdateableObject(this);
	}
	
	public void update()
	{
		super.update();
	}
	
	public void render(Graphics2D g)
	{
		Image image = PixGen.getImageManager().getImage(getRenderkey());
		super.RenderImageCenter(g, image, 3);
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
