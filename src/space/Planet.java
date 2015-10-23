package space;

import java.awt.Graphics2D;

import pixeng.Transformation;
import pixeng.Vector;

public class Planet extends SpaceBody
{
	private Vector starpos;
	private int dist;
	
	private boolean lastkeypress = false;
	
	public Planet(String img, Vector star)
	{
		super(img, "res/planets/" + img + ".png");
		
		this.starpos = star;
	}
	
	public void update()
	{
		super.update();
		
		setPosition(Transformation.RotateAbout(
				getPosition(),
				this.starpos,
				0.01F));
		
//		Vector dist = new Vector(
//				Main.getPlayer().getPosition().getX() - getPosition().getX(),
//				Main.getPlayer().getPosition().getY() - getPosition().getY());
//		
//		if((dist.getLength() < 1000 || dist.getLength() > -1000) && Main.getInputManager().keyDown(Settings.KEY_EXPLORE) && lastkeypress == false)
//		{
//			try 
//			{
//				Runtime.getRuntime().exec("java -jar TileGame.jar");
//			} 
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//			lastkeypress = true;
//			
//			Main.pause();
//		}
//		if(!Main.getInputManager().keyDown(Settings.KEY_EXPLORE))
//			lastkeypress = false;
	}
	
	public void render(Graphics2D g)
	{
		super.render(g);
	}
	
	public Vector getStarPos()
	{
		return starpos;
	}
	
	public String getImg()
	{
		return super.renderkey.substring(12, super.renderkey.length() - 4);
	}
}
