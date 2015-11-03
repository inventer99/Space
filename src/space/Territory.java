package space;

import java.awt.Color;
import java.awt.Graphics2D;

import pixeng.PixEng;

public class Territory extends Entity
{
	public Color color;
	public int x, y;
	
	public Territory(int x, int y, Color c)
	{
		this.color = c;
		this.x = x;
		getPosition().setX((x * 10000) - 500000);
		this.y = y;
		getPosition().setY((y * 10000) - 500000);
		
		PixEng.addUpdateableObject(this);
//		((Main) PixEng.getGame()).getWorld().territory.add(this);
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
}
