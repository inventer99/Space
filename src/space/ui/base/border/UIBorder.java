package space.ui.base.border;

import java.awt.Graphics2D;

public abstract class UIBorder 
{	
	protected int width;
	
	public UIBorder(int width)
	{
		this.width = width;
	}
	
	public abstract void Render(Graphics2D g);
}
