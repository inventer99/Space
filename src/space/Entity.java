package space;

import java.awt.Graphics2D;

import pixeng.PixEng;
import pixeng.Updateable;
import pixeng.Vector;

public class Entity implements Updateable
{
	private Vector position;
	private Vector renderpos;
	private Vector direction;
	
	public Entity()
	{
		this.position = new Vector(0, 0);
		this.direction = new Vector(0, 0);
		this.renderpos = new Vector(0, 0);
	}
	
	@Override
	public void update() 
	{
		renderpos = new Vector(PixEng.getPosition().getX() + position.getX(), PixEng.getPosition().getY() + position.getY());
	}

	@Override
	public void render(Graphics2D g) 
	{
		
	}

	public Vector getPosition() 
	{
		return position;
	}

	public void setPosition(Vector location) 
	{
		this.position = location;
	}

	public Vector getDirection() 
	{
		return direction;
	}

	public void setDirection(Vector direction) 
	{
		this.direction = direction;
	}

	public Vector getRenderpos() 
	{
		return renderpos;
	}
	
	public void setRenderpos(Vector renderpos)
	{
		this.renderpos = renderpos;
	}
}
