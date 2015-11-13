package space.ui.base;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class UITabbedPanel extends UIPanel
{
	private int index = 0;
	
	public void add(UIComp comp, String title)
	{
		UITabComp tmp = this.new UITabComp();
		
		tmp.parent = this;
		tmp.child = comp;
		tmp.title = title;
		tmp.index = this.children.size();
		
		comp.setParent(tmp);
		this.children.add(tmp);
	}
	
	@Override
	public void add(UIComp comp)
	{
		this.add(comp, "");
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
			
			ig.setColor(this.foreground);
			ig.drawLine(0, 0, 0, 20);
			
			for(UIComp comp:children) 
			{
				ig.drawString(((UITabComp) comp).title, (((UITabComp) comp).index * 40) + 3, 17);
				
				comp.renderComp(ig);
			}
		}
		g.drawImage(i, this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height, null);
	}
	
	private class UITabComp extends UIComp
	{	
		public UITabbedPanel parent;
		
		public String title;
		public int index;
		
		public UIComp child;
		
//		public 

		@Override
		public void renderComp(Graphics2D g) 
		{
			if(this.parent.index == this.index)
				child.renderComp(g);
		}
	}
}
