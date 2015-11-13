package space.ui.base.border;

import java.awt.Graphics2D;

import space.ui.base.UIComp;

public abstract class UIBorder 
{	
	protected int width;
	
	public UIBorder(int width)
	{
		this.width = width;
	}
	
	public abstract void Render(UIComp comp, Graphics2D g);

	public int getWidth() 
	{
		return width;
	}
}
