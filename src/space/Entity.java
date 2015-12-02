package space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import pixgen.PixGen;
import pixgen.Settings;
import pixgen.Updateable;
import pixgen.Vector;

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
		renderpos = new Vector(
				PixGen.getViewPoint().getX() + position.getX() + (Settings.WIDTH / 2), 
				PixGen.getViewPoint().getY() + position.getY() + (Settings.HEIGHT / 2)
		);
	}

	@Override
	public void render(Graphics2D g) 
	{
		
	}
	
	public void RenderImageCenter(Graphics2D g, Image i, int scale)
	{
		int width = i.getWidth(null) * scale;
		int height = i.getHeight(null) * scale;
		
		((Graphics) g).drawImage(
				i, 
				Math.round(getRenderpos().getX()) - (width / 2), 
				Math.round(getRenderpos().getY()) - (height / 2), 
				width, 
				height, 
				null
		);
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
