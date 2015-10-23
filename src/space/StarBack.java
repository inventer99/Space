package space;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pixeng.PixEng;
import pixeng.Settings;
import pixeng.Vector;

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
			v.setX((float) Math.ceil(Math.random() * Settings.WIDTH) - PixEng.getPosition().getX());
			v.setY((float) Math.ceil(Math.random() * Settings.HEIGHT) - PixEng.getPosition().getY());
			points.add(v);
		}
		
		PixEng.addUpdateableObject(this);
	}
	
	public void update()
	{		
		setPosition(PixEng.getPosition());
		super.update();
		for(Vector v : points)
		{
			if(v.getX() < -PixEng.getPosition().getX())
			{
				float offset = v.getX() - -PixEng.getPosition().getX();
				v.setX(-PixEng.getPosition().getX() + Settings.WIDTH + offset);
				v.setY((float) Math.ceil(Math.random() * Settings.HEIGHT) - PixEng.getPosition().getY());
			}
			if(v.getY() < -PixEng.getPosition().getY())
			{
				float offset = v.getY() - -PixEng.getPosition().getY();
				v.setX((float) Math.ceil(Math.random() * Settings.WIDTH) - PixEng.getPosition().getX());
				v.setY(-PixEng.getPosition().getY() + Settings.HEIGHT + offset);
			}
			if(v.getX() > Settings.WIDTH + -PixEng.getPosition().getX())
			{
				float offset = v.getX() - (Settings.WIDTH + -PixEng.getPosition().getX());
				v.setX(-PixEng.getPosition().getX() + offset);
				v.setY((float) Math.ceil(Math.random() * Settings.HEIGHT) - PixEng.getPosition().getY());
			}
			if(v.getY() > Settings.HEIGHT + -PixEng.getPosition().getY())
			{
				float offset = v.getY() - (Settings.HEIGHT + -PixEng.getPosition().getY());
				v.setX((float) Math.ceil(Math.random() * Settings.WIDTH) - PixEng.getPosition().getX());
				v.setY(-PixEng.getPosition().getY() + offset);
			}
		}
	}
	
	public void render(Graphics2D g)
	{
		for(Vector v : points)
			((Graphics) g).drawImage(this.image, Math.round(v.getX() + (getRenderpos().getX() / 2)), Math.round(v.getY() + (getRenderpos().getY() / 2)), 6, 6, null);
	}
}
