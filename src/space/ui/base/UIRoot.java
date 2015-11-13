package space.ui.base;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import space.ui.base.layout.UIAbsoluteLayout;

public class UIRoot extends UIComp
{
	private ArrayList<UIComp> children; 
	
	public UIRoot()
	{
		this.children = new ArrayList<UIComp>();
		this.bounds = new UIAbsoluteLayout(0, 0, 450, 300);
	}
	
	public void add(UIComp comp)
	{
		comp.setParent(this);
		children.add(comp);
	}
	
	public void remove(UIComp comp)
	{
		comp.setParent(null);
		children.remove(comp);
	}

	@Override
	public void renderComp(Graphics2D g) 
	{
		Image i = new BufferedImage(this.bounds.width, this.bounds.height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D ig = (Graphics2D) i.getGraphics();
		{
			ig.setColor(this.background);
			ig.fillRect(
					0, 
					0,
					this.bounds.width, 
					this.bounds.height
			);
			
			for(UIComp comp:children) 
				comp.renderComp(ig);
		}
		g.drawImage(i, 0, 0, this.bounds.width, this.bounds.height, null);
	}
}
