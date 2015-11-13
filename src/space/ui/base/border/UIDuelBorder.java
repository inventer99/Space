package space.ui.base.border;

import java.awt.Color;
import java.awt.Graphics2D;

import space.ui.base.UIComp;

public class UIDuelBorder extends UIBorder
{
	private Color color1;
	private Color color2;
	
	public UIDuelBorder(int width, Color color1, Color color2) 
	{
		super(width);
		
		this.color1 = color1;
		this.color2 = color2;
	}

	@Override
	public void Render(UIComp comp, Graphics2D g) 
	{
		g.setColor(this.color1);
		g.drawLine(0, 0, comp.getBounds().width - 1, 0);
		g.drawLine(0, 0, 0, comp.getBounds().height - 1);
		
		g.setColor(this.color2);
		g.drawLine(1, comp.getBounds().height - 1, comp.getBounds().width - 1, comp.getBounds().height - 1);
		g.drawLine(comp.getBounds().width - 1, 1, comp.getBounds().width - 1, comp.getBounds().height - 1);
	}
}
