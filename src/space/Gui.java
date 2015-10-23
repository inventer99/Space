package space;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;

import pixeng.PixEng;
import pixeng.Settings;
import pixeng.Updateable;
import space.main.Main;

public class Gui implements Updateable
{
	private final Color colorBack = new Color(89, 89, 89, 100);
	private final Color colorEdge = new Color(153, 0, 153);
	private final Color colorHealth = new Color(191, 0, 0);
	private final Color colorShield = new Color(48, 191, 191);
	private final Color colorPower = new Color(230, 230, 0);
	private final Color colorText = new Color(255, 255, 255);
	
	private ProgressBar healthBar = this.new ProgressBar(2, Settings.HEIGHT - 153, colorHealth);
	private ProgressBar shieldBar = this.new ProgressBar(25, Settings.HEIGHT - 153, colorShield);
	private ProgressBar powerBar = this.new ProgressBar(Settings.WIDTH - 23, Settings.HEIGHT - 153, colorPower);
	private AbilityBar abilityBar = this.new AbilityBar(Settings.WIDTH - 61, Settings.HEIGHT - 153);
	private MiniMap miniMap = this.new MiniMap(2, 2);
	private OptionButton optionButton = this.new OptionButton(Settings.WIDTH - 63, 2);
	private OptionMenu optionMenu = this.new OptionMenu(Settings.WIDTH - 78, 25);
	private OptionWindow optionWindow = this.new OptionWindow(Math.round((Settings.WIDTH / 2) - 200), Math.round((Settings.HEIGHT / 2) - 150));
	private ChatWindow chatWindow = this.new ChatWindow(48, Settings.HEIGHT - 202);
	
	public boolean drawOptionMenu = false;
	public boolean drawOptionWindow = false;
	public boolean drawChatWindow = false;
	
	public Gui()
	{
		PixEng.addUpdateableObject(this);
	}
	
	@Override
	public void update()
	{
		updateMouse();
	}
	
	@Override
	public void render(Graphics2D g)
	{	
		healthBar.render(((Main) PixEng.getGame()).getPlayer().getHealth(), g);
		
		shieldBar.render(((Main) PixEng.getGame()).getPlayer().getShield(), g);
		
		powerBar.render(((Main) PixEng.getGame()).getPlayer().getPower(), g);
		
		abilityBar.render(g);
		
		miniMap.render(g);
		
		optionButton.render(g);
		
		optionMenu.render(g);
		
		optionWindow.render(g);
		
		chatWindow.render(g);
	}
	
	boolean stillDown = false;
	
	public void updateMouse()
	{
		if(PixEng.getInputManager().mouseDown(1) && !stillDown)
		{
			optionButton.mousePressed();
			optionMenu.mousePressed();
			optionWindow.mousePressed();
			chatWindow.mousePressed();
			
			stillDown = true;
		}
		if(!PixEng.getInputManager().mouseDown(1) && stillDown)
		{
			optionWindow.mouseReleased();
			chatWindow.mouseReleased();
			
			stillDown = false;
		}
		
		if(
				PixEng.getInputManager().mouseX() != PixEng.getInputManager().lastMouseX() &&
				PixEng.getInputManager().mouseY() != PixEng.getInputManager().lastMouseY()	
		)
		{
			if(stillDown)
			{
				optionWindow.mouseDragged();
				chatWindow.mouseDragged();
			}
			else
			{
				// mouse moved
			}
			
			PixEng.getInputManager().equalizeMouse();
		}
	}
	
	private class MiniMap
	{
		private int x, y;
		
		public MiniMap(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void render(Graphics2D g)
		{
			g.setColor(Color.BLACK);
			g.fillRect(x, y, 125, 125);
			
			g.setColor(colorEdge);
			g.fillRect(x, y + 62, 125, 1);
			g.fillRect(x + 62, y, 1, 125);
			
			//draw stars
			g.setColor(Color.YELLOW);
			for(Star s : ((Main) PixEng.getGame()).getWorld().stars)
			{
				int px = 62 + Math.round((s.getPosition().getX() - ((Main) PixEng.getGame()).getPlayer().getPosition().getX()) / 1000);
				int py = 62 + Math.round((s.getPosition().getY() - ((Main) PixEng.getGame()).getPlayer().getPosition().getY()) / 1000);
				
				if(px > x && px < x + 125 && py > y && py < y + 125)
					g.fillRect(x + px + 1, y + py - 1, 2, 2);
			}
			
			// draw planets
			g.setColor(Color.GREEN);
			for(Planet p : ((Main) PixEng.getGame()).getWorld().planets)
			{
				int px = 62 + Math.round((p.getPosition().getX() - ((Main) PixEng.getGame()).getPlayer().getPosition().getX()) / 1000);
				int py = 62 + Math.round((p.getPosition().getY() - ((Main) PixEng.getGame()).getPlayer().getPosition().getY()) / 1000);
				
				if(px > x && px < x + 125 && py > y && py < y + 125)
					g.fillRect(x + px, y + py, 1, 1);
			}
			
			//draw territory
			for(Territory t : ((Main) PixEng.getGame()).getWorld().territory)
			{
				g.setColor(t.color);
				int px = 62 + Math.round((t.getPosition().getX() - ((Main) PixEng.getGame()).getPlayer().getPosition().getX()) / 1000);
				int py = 62 + Math.round((t.getPosition().getY() - ((Main) PixEng.getGame()).getPlayer().getPosition().getY()) / 1000);
				
				if(px > x && px < x + 125 && py > y && py < y + 125)
					g.drawRect(x + px, y + py, 9, 9);
			}
			
			g.setColor(colorEdge);
			g.drawRect(x, y, 125, 125);
			g.setColor(colorText);
			g.drawString("X: " + Math.round(PixEng.getPosition().getX()) + " Y: " + Math.round(PixEng.getPosition().getY()), x, y + 140);
		}
	}
	
	private class ProgressBar
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
			g.setColor(colorBack);
			g.fillRect(x, y, 20, 150);
			g.setColor(c);
			g.fillRect(x, y + (150 - (int) Math.round(percent * 1.5)), 20, (int) Math.round(percent * 1.5));
			g.setColor(colorEdge);
			g.drawRect(x, y, 20, 150);
		}
	}
	
	private class AbilityBar
	{
		private int x, y;
		private boolean all = false;
		
		private boolean lastkeypress = false;
		
		public AbilityBar(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void render(Graphics2D g)
		{
			drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[0].getImage(), x, y + 0, g);
			drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[1].getImage(), x, y + 38, g);
			drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[2].getImage(), x, y + 76, g);
			drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[3].getImage(), x, y + 114, g);
			
			if(all)
			{
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[4 ].getImage(), x - 38, y + 0, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[5 ].getImage(), x - 38, y + 38, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[6 ].getImage(), x - 38, y + 76, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[7 ].getImage(), x - 38, y + 114, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[8 ].getImage(), x - 76, y + 0, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[9 ].getImage(), x - 76, y + 38, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[10].getImage(), x - 76, y + 76, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[11].getImage(), x - 76, y + 114, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[12].getImage(), x - 114, y + 0, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[13].getImage(), x - 114, y + 38, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[14].getImage(), x - 114, y + 76, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[15].getImage(), x - 114, y + 114, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[16].getImage(), x - 152, y + 0, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[17].getImage(), x - 152, y + 38, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[18].getImage(), x - 152, y + 76, g);
				drawAbility(((Main) PixEng.getGame()).getPlayer().getAbilitys()[19].getImage(), x - 152, y + 114, g);
			}
			
			if(PixEng.getInputManager().keyDown(Settings.KEY_ABILITY) && lastkeypress == false)
			{
				all = !all;
				lastkeypress = true;
			}
			if(!PixEng.getInputManager().keyDown(Settings.KEY_ABILITY))
				lastkeypress = false;
		}
		
		private void drawAbility(Image img, int x1, int y1, Graphics2D g)
		{
			g.setColor(colorBack);
			g.fillRect(x1, y1, 35, 35);
			((Graphics) g).drawImage(img, x1 + 2, y1 + 2, 32, 32, null);
			g.setColor(colorEdge);
			g.drawRect(x1, y1, 35, 35);
		}
	}
	
	private class OptionButton
	{
		private int x, y;
		
		public OptionButton(final int x, final int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void mousePressed()
		{
			int mx = PixEng.getInputManager().mouseX();
			int my = PixEng.getInputManager().mouseY();
			
			if((mx > x && mx < x + 60) && (my > y && my < y + 20))
				drawOptionMenu = !drawOptionMenu;
		}
		
		public void render(Graphics2D g)
		{
			g.setColor(colorBack);
			g.fillRect(x, y, 60, 20);
			g.setColor(colorText);
			g.drawString("Options", x + 5, y + 14);
			g.setColor(colorEdge);
			g.drawRect(x, y, 60, 20);
		}
	}
	
	private class OptionMenu
	{
		private int x, y;
		
		private boolean lastkeypress = false;
		
		public OptionMenu(final int x, final int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void mousePressed()
		{
			int mx = PixEng.getInputManager().mouseX();
			int my = PixEng.getInputManager().mouseY();
			
			if(drawOptionMenu)
			{
//				if((mx > x && mx < x + 75) && (my > y + 0 && my < y + 20))
//					((Main) PixEng.getGame()).getWorld().save();
				if((mx > x && mx < x + 75) && (my > y + 20 && my < y + 40))
					drawOptionWindow = true;
//				if((mx > x && mx < x + 75) && (my > y + 40 && my < y + 60))
//					((Main) PixEng.getGame()).getWorld().load();
				if((mx > x && mx < x + 75) && (my > y + 60 && my < y + 80))
					System.out.println("World 2 clicked");
				if((mx > x && mx < x + 75) && (my > y + 80 && my < y + 100))
					System.out.println("World 3 clicked");
				if((mx > x && mx < x + 75) && (my > y + 100 && my < y + 120))
					System.out.println("World 4 clicked");
				if((mx > x && mx < x + 75) && (my > y + 120 && my < y + 140))
					System.out.println("World 5 clicked");
				if((mx > x && mx < x + 75) && (my > y + 140 && my < y + 160))
					System.exit(0);
			
				if((mx > x && mx < x + 75) && (my > y + 0 && my < y + 160))
					drawOptionMenu = false;
			}
		}
		
		public void render(Graphics2D g)
		{
			if(drawOptionMenu)
			{
				g.setColor(colorBack);
				g.fillRect(x, y, 75, 160);
				g.setColor(colorText);
				g.drawString("Save", x + 5, y + 14);
				g.drawString("Options", x + 5, y + 34);
				g.drawString("World 1", x + 5, y + 54);
				g.drawString("World 2", x + 5, y + 74);
				g.drawString("World 3", x + 5, y + 94);
				g.drawString("World 4", x + 5, y + 114);
				g.drawString("World 5", x + 5, y + 134);
				g.drawString("Exit", x + 5, y + 154);
				g.setColor(colorEdge);
				g.drawRect(x, y, 75, 160);
			}
			
			if(PixEng.getInputManager().keyDown(27) && lastkeypress == false)
			{
				drawOptionMenu = !drawOptionMenu;
				lastkeypress = true;
			}
			if(!PixEng.getInputManager().keyDown(27))
				lastkeypress = false;
		}
	}
	
	private class OptionWindow
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
			
			if(drawOptionWindow)
			{
				if((mx > x + 380 && mx < x + 400) && (my > y + 0 && my < y + 20))
					drawOptionWindow = false;
				
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
			
			if(drawOptionWindow)
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
			if(drawOptionWindow)
			{
				if(drag)
				{
					drag = false;
				}
			}
		}
			
		public void render(Graphics2D g)
		{
			if(drawOptionWindow)
			{
				g.setColor(colorBack);
				g.fillRect(x, y, 400, 300);
				g.setColor(colorEdge);
				if(drawTab == 0) g.fillRect(x + 4, y + 1, 37, 19);
				if(drawTab == 1) g.fillRect(x + 40, y + 1, 41, 19);
				if(drawTab == 2) g.fillRect(x + 81, y + 1, 39, 19);
				if(drawTab == 3) g.fillRect(x + 120, y + 1, 35, 19);
				if(drawTab == 4) g.fillRect(x + 155, y + 1, 45, 19);
				g.setColor(colorText);
				g.drawString("Game", x + 5, y + 15);
				g.drawString("Image", x + 45, y + 15);
				g.drawString("Audio", x + 86, y + 15);
				g.drawString("Keys", x + 125, y + 15);
				g.drawString("Mouse", x + 160, y + 15);
				g.drawString("X", x + 385, y + 15);
				g.setColor(colorEdge);
				g.fillRect(x + 4, y + 20, 392, 1);
				
				if(drawTab == 0)// Game Settings
				{
					
				}
				if(drawTab == 1)// Image Settings
				{
					g.setColor(colorText);
					g.drawString("Width", x + 5, y + 35);
					g.drawString("Height", x + 5, y + 50);
					
					g.drawString("" + Settings.WIDTH, x + 200, y + 35);
					g.drawString("" + Settings.HEIGHT, x + 200, y + 50);
				}
				if(drawTab == 2)// Audio Settings
				{
					g.setColor(colorText);
					g.drawString("Master Volume", x + 5, y + 35);
					g.drawString("SFX Volume", x + 5, y + 50);
					g.drawString("Music Volume", x + 5, y + 65);
					
					g.drawString("" + Settings.SOUND_MASTER, x + 200, y + 35);
					g.drawString("" + Settings.SOUND_SFX, x + 200, y + 50);
					g.drawString("" + Settings.SOUND_MUSIC, x + 200, y + 65);
				}
				if(drawTab == 3)// Keys Settings
				{
					g.setColor(colorText);
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
				
				g.setColor(colorEdge);
				g.drawRect(x, y, 400, 300);
			}
		}
	}
	
	private class ChatWindow
	{
		private int x, y;
		private int sx, sy;
		private boolean drag = false;
		
		private boolean lastkeypress = false;
		
		public ChatWindow(final int x, final int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public void mousePressed()
		{
			int mx = PixEng.getInputManager().mouseX();
			int my = PixEng.getInputManager().mouseY();
			
			if(drawChatWindow)
			{
				if((mx > x + 380 && mx < x + 400) && (my > y + 0 && my < y + 20))
					drawChatWindow = false;
				
				if((mx > x + 40 && mx < x + 400) && (my > y + 0 && my < y + 20))
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
			
			if(drawChatWindow)
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
			if(drawChatWindow)
			{
				if(drag)
				{
					drag = false;
				}
			}
		}
			
		public void render(Graphics2D g)
		{
			if(drawChatWindow)
			{
				g.setColor(colorBack);
				g.fillRect(x, y, 400, 200);
				g.setColor(colorText);
				g.drawString("Chat", x + 5, y + 15);
				g.drawString("X", x + 385, y + 15);
				g.drawString("Send", x + 365, y + 195);
				g.setColor(colorEdge);
				g.fillRect(x + 4, y + 20, 392, 1);
				
				g.fillRect(x + 4, y + 180, 392, 1);
				g.fillRect(x + 360, y + 183, 1, 15);
				
				g.setColor(colorEdge);
				g.drawRect(x, y, 400, 200);
			}
			
			if(PixEng.getInputManager().keyDown(Settings.KEY_CHAT) && lastkeypress == false)
			{
				drawChatWindow = !drawChatWindow;
				lastkeypress = true;
			}
			if(!PixEng.getInputManager().keyDown(Settings.KEY_CHAT))
				lastkeypress = false;
		}
	}
}
