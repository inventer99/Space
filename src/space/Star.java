package space;

import java.awt.Graphics2D;

import pixeng.Vector;

public class Star extends SpaceBody
{	
	public Star()
	{
		super("star", "res/planets/star_yellow.png");
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
