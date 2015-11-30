package space;

import java.awt.Color;
import java.awt.Graphics2D;

import pixgen.PixGen;

public class Territory extends Entity
{
	public Team team;
	public Color color;
	public int x, y;
	
	public Territory(int x, int y, Team t)
	{
		this.team = t;
		this.color = team.color;
		this.x = x;
		getPosition().setX((x * 10000) - 500000);
		this.y = y;
		getPosition().setY((y * 10000) - 500000);
		
		PixGen.addUpdateableObject(this);
	}
	
	public void update()
	{
		super.update();
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 75));
		for(int i = 0;i < 10;i++)
			g.drawRect(Math.round(getRenderpos().getX()) + i, Math.round(getRenderpos().getY() + i), 9999 - (2 * i), 9999 - (2 * i));
	}
	
	public Team getTeam()
	{
		return team;
	}
}
