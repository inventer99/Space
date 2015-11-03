package space.ui;

import java.awt.Color;
import java.awt.Graphics2D;

public class ProgressBar
	{
		private int x, y;
		private Color c;
		
		public ProgressBar(int x, int y, Color c)
		{
			this.x = x;
			this.y = y;
			this.c = c;
		}
		
		public void render(int percent, Graphics2D g)
		{
			g.setColor(Gui.colorBack);
			g.fillRect(x, y, 20, 150);
			g.setColor(c);
			g.fillRect(x, y + (150 - (int) Math.round(percent * 1.5)), 20, (int) Math.round(percent * 1.5));
			g.setColor(Gui.colorEdge);
			g.drawRect(x, y, 20, 150);
		}
	}