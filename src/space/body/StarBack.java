package space.body;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pixgen.PixGen;
import pixgen.Settings;
import pixgen.Vector;
import space.Entity;

public class StarBack extends Entity 
{
	private Image image;
	public ArrayList<Vector> points = new ArrayList<Vector>();
	
	public StarBack()
	{
		try 
		{
			image = ImageIO.read(new File("res/starback.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		int tmp = Settings.WIDTH * Settings.HEIGHT;
		tmp /= 5000;
		
		for(int i = 0;i < tmp;i++)
		{
			Vector v = new Vector(0, 0);
			v.setX((float) Math.ceil(Math.random() * Settings.WIDTH) - PixGen.getViewPoint().getX());
			v.setY((float) Math.ceil(Math.random() * Settings.HEIGHT) - PixGen.getViewPoint().getY());
			points.add(v);
		}
		
		PixGen.addUpdateableObject(this);
	}
	
	public void update()
	{		
		setPosition(PixGen.getViewPoint());
		super.update();
		for(Vector v : points)
		{
			if(v.getX() < -PixGen.getViewPoint().getX())
			{
				float offset = v.getX() - -PixGen.getViewPoint().getX();
				v.setX(-PixGen.getViewPoint().getX() + Settings.WIDTH + offset);
				v.setY((float) Math.ceil(Math.random() * Settings.HEIGHT) - PixGen.getViewPoint().getY());
			}
			if(v.getY() < -PixGen.getViewPoint().getY())
			{
				float offset = v.getY() - -PixGen.getViewPoint().getY();
				v.setX((float) Math.ceil(Math.random() * Settings.WIDTH) - PixGen.getViewPoint().getX());
				v.setY(-PixGen.getViewPoint().getY() + Settings.HEIGHT + offset);
			}
			if(v.getX() > Settings.WIDTH + -PixGen.getViewPoint().getX())
			{
				float offset = v.getX() - (Settings.WIDTH + -PixGen.getViewPoint().getX());
				v.setX(-PixGen.getViewPoint().getX() + offset);
				v.setY((float) Math.ceil(Math.random() * Settings.HEIGHT) - PixGen.getViewPoint().getY());
			}
			if(v.getY() > Settings.HEIGHT + -PixGen.getViewPoint().getY())
			{
				float offset = v.getY() - (Settings.HEIGHT + -PixGen.getViewPoint().getY());
				v.setX((float) Math.ceil(Math.random() * Settings.WIDTH) - PixGen.getViewPoint().getX());
				v.setY(-PixGen.getViewPoint().getY() + offset);
			}
		}
	}
	
	public void render(Graphics2D g)
	{
		for(Vector v : points)
			((Graphics) g).drawImage(this.image, Math.round(v.getX() + (getRenderpos().getX() / 2)), Math.round(v.getY() + (getRenderpos().getY() / 2)), 6, 6, null);
	}
}
