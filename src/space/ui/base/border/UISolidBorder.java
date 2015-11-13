package space.ui.base.border;

import java.awt.Color;
import java.awt.Graphics2D;

import space.ui.base.UIComp;

public class UISolidBorder extends UIBorder
{
	private Color color;
	
	public UISolidBorder(int width, Color color) 
	{
		super(width);
		
		this.color = color;
	}

	@Override
	public void Render(UIComp comp, Graphics2D g) 
	{
		g.setColor(this.color);
		g.drawRect(
				0, 
				0, 
				comp.getBounds().width - 1, 
				comp.getBounds().height - 1
		);
	}
}