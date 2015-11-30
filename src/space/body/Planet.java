package space.body;

import java.awt.Graphics2D;

import pixgen.Transformation;
import pixgen.Vector;

public class Planet extends SpaceBody
{
	private Star star;
	private int dist, arc;
	
	public Planet(String img, Star star, int dist, int arc)
	{
		super(img, "res/planets/" + img + ".png");
		
		this.star = star;
		this.dist = dist;
		
		this.arc = arc;
		
//		setPosition(
//				new Vector(star.getPosition().getX() + dist, 0));
//		setPosition(Transformation.RotateAbout(
//				getPosition(),
//				star.getPos(),
//				arc));
		
		setPosition(new Vector(
				dist, 0));
		setPosition(Transformation.Translate(
				getPosition(),
				star.getPosition()));
		setPosition(Transformation.RotateAbout(
				getPosition(),
				star.getPosition(),
				arc));
	}
	
	public void update()
	{
		super.update();
		
		setPosition(Transformation.RotateAbout(
				getPosition(),
				star.getPos(),
				0.01F));
	}
	
	public void render(Graphics2D g)
	{
		super.render(g);
	}
	
	public Star getStar()
	{
		return star;
	}
	
	public void setStar(Star star)
	{
		this.star = star;
	}
	
	public int getDist()
	{
		return dist;
	}
	
	public int getArc()
	{
		return arc;
	}
	
	public String getImg()
	{
		return super.getRenderkey().substring(12, super.getRenderkey().length() - 4);
	}
}
