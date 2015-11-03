package space.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import pixeng.PixEng;
import pixeng.Settings;
import space.main.Main;

public  class AbilityBar
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
			g.setColor(Gui.colorBack);
			g.fillRect(x1, y1, 35, 35);
			((Graphics) g).drawImage(img, x1 + 2, y1 + 2, 32, 32, null);
			g.setColor(Gui.colorEdge);
			g.drawRect(x1, y1, 35, 35);
		}
	}