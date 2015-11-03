package space.ui;

import java.awt.Graphics2D;

import pixeng.PixEng;
import pixeng.Settings;

public class OptionWindow
	{
		private int x, y;
		private int sx, sy;
		private boolean drag = false;
		private short drawTab = 0;
		
		public OptionWindow(final int x, final int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void mousePressed()
		{
			int mx = PixEng.getInputManager().mouseX();
			int my = PixEng.getInputManager().mouseY();
			
			if(Gui.drawOptionWindow)
			{
				if((mx > x + 380 && mx < x + 400) && (my > y + 0 && my < y + 20))
					Gui.drawOptionWindow = false;
				
				if((mx > x + 0 && mx < x + 40) && (my > y + 0 && my < y + 20))
					drawTab = 0;
				if((mx > x + 40 && mx < x + 81) && (my > y + 0 && my < y + 20))
					drawTab = 1;
				if((mx > x + 81 && mx < x + 120) && (my > y + 0 && my < y + 20))
					drawTab = 2;
				if((mx > x + 120 && mx < x + 155) && (my > y + 0 && my < y + 20))
					drawTab = 3;
				if((mx > x + 155 && mx < x + 200) && (my > y + 0 && my < y + 20))
					drawTab = 4;
			
//				if(drawTab == 3)// Keys Settings
//				{
//					if((mx > x + 200 && mx < x + 400) && (my > y + 10 && my < y + 35))
//						PixEng.getInputManager().nextKeySet(1);
//					if((mx > x + 200 && mx < x + 400) && (my > y + 35 && my < y + 50))
//						PixEng.getInputManager().nextKeySet(2);
//					if((mx > x + 200 && mx < x + 400) && (my > y + 50 && my < y + 65))
//						PixEng.getInputManager().nextKeySet(3);
//					if((mx > x + 200 && mx < x + 400) && (my > y + 80 && my < y + 95))
//						PixEng.getInputManager().nextKeySet(4);
//				}
				
				if((mx > x + 200 && mx < x + 400) && (my > y + 0 && my < y + 20))
				{
					sx = mx - x;
					sy = my - y;
					drag = true;
				}
			}
		}
		
		public void mouseDragged()
		{
			int mx = PixEng.getInputManager().mouseX();
			int my = PixEng.getInputManager().mouseY();
			
			if(Gui.drawOptionWindow)
			{
				if(drag)
				{
					x = mx - sx;
					y = my - sy;
				}
			}
		}
		
		public void mouseReleased()
		{
			if(Gui.drawOptionWindow)
			{
				if(drag)
				{
					drag = false;
				}
			}
		}
			
		public void render(Graphics2D g)
		{
			if(Gui.drawOptionWindow)
			{
				g.setColor(Gui.colorBack);
				g.fillRect(x, y, 400, 300);
				g.setColor(Gui.colorEdge);
				if(drawTab == 0) g.fillRect(x + 4, y + 1, 37, 19);
				if(drawTab == 1) g.fillRect(x + 40, y + 1, 41, 19);
				if(drawTab == 2) g.fillRect(x + 81, y + 1, 39, 19);
				if(drawTab == 3) g.fillRect(x + 120, y + 1, 35, 19);
				if(drawTab == 4) g.fillRect(x + 155, y + 1, 45, 19);
				g.setColor(Gui.colorText);
				g.drawString("Game", x + 5, y + 15);
				g.drawString("Image", x + 45, y + 15);
				g.drawString("Audio", x + 86, y + 15);
				g.drawString("Keys", x + 125, y + 15);
				g.drawString("Mouse", x + 160, y + 15);
				g.drawString("X", x + 385, y + 15);
				g.setColor(Gui.colorEdge);
				g.fillRect(x + 4, y + 20, 392, 1);
				
				if(drawTab == 0)// Game Settings
				{
					
				}
				if(drawTab == 1)// Image Settings
				{
					g.setColor(Gui.colorText);
					g.drawString("Width", x + 5, y + 35);
					g.drawString("Height", x + 5, y + 50);
					
					g.drawString("" + Settings.WIDTH, x + 200, y + 35);
					g.drawString("" + Settings.HEIGHT, x + 200, y + 50);
				}
				if(drawTab == 2)// Audio Settings
				{
					g.setColor(Gui.colorText);
					g.drawString("Master Volume", x + 5, y + 35);
					g.drawString("SFX Volume", x + 5, y + 50);
					g.drawString("Music Volume", x + 5, y + 65);
					
					g.drawString("" + Settings.SOUND_MASTER, x + 200, y + 35);
					g.drawString("" + Settings.SOUND_SFX, x + 200, y + 50);
					g.drawString("" + Settings.SOUND_MUSIC, x + 200, y + 65);
				}
				if(drawTab == 3)// Keys Settings
				{
					g.setColor(Gui.colorText);
					g.drawString("Up", x + 5, y + 35);
					g.drawString("Down", x + 5, y + 50);
					g.drawString("Left", x + 5, y + 65);
					g.drawString("Right", x + 5, y + 80);
					g.drawString("Ability 1", x + 5, y + 95);
					g.drawString("Ability 2", x + 5, y + 110);
					g.drawString("Ability 3", x + 5, y + 125);
					g.drawString("Ability 4", x + 5, y + 140);
					g.drawString("Fix Shields", x + 5, y + 155);
					g.drawString("Fix Health", x + 5, y + 170);
					g.drawString("Explore", x + 5, y + 185);
					g.drawString("Warp", x + 5, y + 200);
					
					g.drawString("" + (char) Settings.KEY_UP, x + 200, y + 35);
					g.drawString("" + (char) Settings.KEY_DOWN, x + 200, y + 50);
					g.drawString("" + (char) Settings.KEY_LEFT, x + 200, y + 65);
					g.drawString("" + (char) Settings.KEY_RIGHT, x + 200, y + 80);
					g.drawString("" + (char) Settings.KEY_1, x + 200, y + 95);
					g.drawString("" + (char) Settings.KEY_2, x + 200, y + 110);
					g.drawString("" + (char) Settings.KEY_3, x + 200, y + 125);
					g.drawString("" + (char) Settings.KEY_4, x + 200, y + 140);
					g.drawString("" + (char) Settings.KEY_SHIELD, x + 200, y + 155);
					g.drawString("" + (char) Settings.KEY_HEALTH, x + 200, y + 170);
					g.drawString("" + (char) Settings.KEY_EXPLORE, x + 200, y + 185);
					g.drawString("" + (char) Settings.KEY_WARP, x + 200, y + 200);
				}
				if(drawTab == 4)// Mouse Settings
				{
					
				}
				
				g.setColor(Gui.colorEdge);
				g.drawRect(x, y, 400, 300);
			}
		}
	}