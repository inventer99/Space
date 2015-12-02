package space.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import pixgen.PixGen;
import space.Territory;
import space.body.Planet;
import space.body.Star;
import space.main.Main;

public class MiniMap
	{
		private int x, y;
		private int scale = 1000;
		
		public MiniMap(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void render(Graphics2D g)
		{
			g.setColor(Color.BLACK);
			g.fillRect(x, y, 125, 125);
			
			//draw stars
			g.setColor(Color.YELLOW);
			for(Star s : ((Main) PixGen.getGame()).getWorld().stars)
			{
				int px = 62 + Math.round((s.getPosition().getX() - ((Main) PixGen.getGame()).getPlayer().getPosition().getX()) / scale);
				int py = 62 + Math.round((s.getPosition().getY() - ((Main) PixGen.getGame()).getPlayer().getPosition().getY()) / scale);
				
				if(px > x && px < x + 125 && py > y && py < y + 125)
					g.fillRect(x + px - 1, y + py - 1, 2, 2);
			}
			
			// draw orbits
			Image i = new BufferedImage(125, 125, BufferedImage.TYPE_INT_ARGB);
			Graphics2D ig = (Graphics2D) i.getGraphics();
			ig.setColor(new Color(89, 89, 89));
			for(Planet p : ((Main) PixGen.getGame()).getWorld().planets)
			{
				Star s = p.getStar();
				int sx = 62 + Math.round((s.getPosition().getX() - ((Main) PixGen.getGame()).getPlayer().getPosition().getX()) / scale);
				int sy = 62 + Math.round((s.getPosition().getY() - ((Main) PixGen.getGame()).getPlayer().getPosition().getY()) / scale);
							
				int otx = sx - (p.getDist() / scale);
				int oty = sy - (p.getDist() / scale);
				
				ig.drawArc(otx, oty, 2 * (p.getDist() / scale), 2 * (p.getDist() / scale), 0, 360);
			}
			g.drawImage(i, x, y, 125, 125, null);
			
			// draw planets
			g.setColor(Color.GREEN);
			for(Planet p : ((Main) PixGen.getGame()).getWorld().planets)
			{	
				int px = 62 + Math.round((p.getPosition().getX() - ((Main) PixGen.getGame()).getPlayer().getPosition().getX()) / scale);
				int py = 62 + Math.round((p.getPosition().getY() - ((Main) PixGen.getGame()).getPlayer().getPosition().getY()) / scale);
				
				if(px > x && px < x + 125 && py > y && py < y + 125)
					g.fillRect(x + px, y + py, 1, 1);
			}
			
			//draw territory
			for(Territory t : ((Main) PixGen.getGame()).getWorld().territory)
			{
				g.setColor(t.color);
				int px = 62 + Math.round((t.getPosition().getX() - ((Main) PixGen.getGame()).getPlayer().getPosition().getX()) / scale);
				int py = 62 + Math.round((t.getPosition().getY() - ((Main) PixGen.getGame()).getPlayer().getPosition().getY()) / scale);
				
				if(px > x && px < x + 125 && py > y && py < y + 125)
					g.drawRect(x + px, y + py, 9, 9);
			}
			
			g.setColor(Gui.colorEdge);
			g.drawRect(x, y, 125, 125);
			g.setColor(Gui.colorEdge);
			g.fillRect(x + 3, y + 62, 120, 1);
			g.fillRect(x + 62, y + 3, 1, 120);
			g.setColor(Gui.colorText);
			g.drawString("X: " + Math.round(-PixGen.getViewPoint().getX()) + " Y: " + Math.round(-PixGen.getViewPoint().getY()), x, y + 140);
		}
	}