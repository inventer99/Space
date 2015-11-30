package space.body;

import java.awt.Graphics2D;

import pixgen.Vector;

public class Star extends SpaceBody
{	
	public Star(String img)
	{
		super(img, "res/planets/" + img + ".png");
	}
	
	public void update()
	{
		super.update();
	}
	
	public void render(Graphics2D g)
	{
		super.render(g);
	}
	
	public Vector getPos()
	{
		return super.getPosition();
	}
}
