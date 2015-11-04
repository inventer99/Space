package space.ui.base;

import java.awt.Color;
import java.awt.Graphics2D;

import space.ui.base.border.UIBorder;
import space.ui.base.event.EventCreator;
import space.ui.base.event.EventListener;
import space.ui.base.layout.UILayout;

public abstract class UIComp 
{
	protected UIComp parent;
	
	protected UILayout bounds;
	protected UIBorder border;
	
	protected Color foreground = Color.BLACK;
	protected Color background = Color.WHITE;
	
	public abstract void renderComp(Graphics2D g);
	
	public void addEventListener(EventListener listener)
	{
		EventCreator.addEventListener(listener);
	}
	
	public UIComp getParent() 
	{
		return parent;
	}

	public void setParent(UIComp parent) 
	{
		this.parent = parent;
	}

	public UILayout getBounds() 
	{
		return bounds;
	}

	public void setBounds(UILayout bounds) 
	{
		this.bounds = bounds;
	}
	
	public UIBorder getBorder() 
	{
		return border;
	}

	public void setBorder(UIBorder border) 
	{
		this.border = border;
	}

	public Color getForegroundColor() 
	{
		return foreground;
	}

	public void setForegroundColor(Color color) 
	{
		this.foreground = color;
	}

	public Color getBackgroundColor() 
	{
		return background;
	}

	public void setBackgroundColor(Color color) 
	{
		this.background = color;
	}
}
