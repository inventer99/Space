package space.ui;

import java.awt.Graphics2D;

import pixgen.PixGen;

public class OptionButton
{
	private int x, y;
	
	public OptionButton(final int x, final int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void mousePressed()
	{
		int mx = PixGen.getInputManager().mouseX();
		int my = PixGen.getInputManager().mouseY();
		
		if((mx > x && mx < x + 60) && (my > y && my < y + 20))
			Gui.drawOptionMenu = !Gui.drawOptionMenu;
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Gui.colorBack);
		g.fillRect(x, y, 60, 20);
		g.setColor(Gui.colorText);
		g.drawString("Options", x + 5, y + 14);
		g.setColor(Gui.colorEdge);
		g.drawRect(x, y, 60, 20);
	}
}