package space.ui.base;

import java.awt.Graphics2D;

public class UIButton extends UIComp
{
	private String text;
	
	public UIButton(String text)
	{
		this.text = text;
	}
	
	public UIButton()
	{
		this("");
	}
	
	@Override
	public void renderComp(Graphics2D g) 
	{
		g.setColor(this.background);
		g.fillRect(
				this.bounds.x, 
				this.bounds.y,
				this.bounds.width, 
				this.bounds.height
		);
		
		g.setColor(foreground);
		g.drawString(
				this.text, 
				this.bounds.x + 3, 
				(this.bounds.y + this.bounds.height) - 3
		);
		
	}
}
