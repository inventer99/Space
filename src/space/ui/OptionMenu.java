package space.ui;

import java.awt.Graphics2D;

import pixeng.PixEng;
import space.main.Main;

public class OptionMenu
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
			
			if(Gui.drawOptionMenu)
			{
				if((mx > x && mx < x + 75) && (my > y + 0 && my < y + 20))
					((Main) PixEng.getGame()).getWorld().save();
				if((mx > x && mx < x + 75) && (my > y + 20 && my < y + 40))
					Gui.drawOptionWindow = true;
				if((mx > x && mx < x + 75) && (my > y + 40 && my < y + 60))
					((Main) PixEng.getGame()).getWorld().load();
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
					Gui.drawOptionMenu = false;
			}
		}
		
		public void render(Graphics2D g)
		{
			if(Gui.drawOptionMenu)
			{
				g.setColor(Gui.colorBack);
				g.fillRect(x, y, 75, 160);
				g.setColor(Gui.colorText);
				g.drawString("Save", x + 5, y + 14);
				g.drawString("Options", x + 5, y + 34);
				g.drawString("World 1", x + 5, y + 54);
				g.drawString("World 2", x + 5, y + 74);
				g.drawString("World 3", x + 5, y + 94);
				g.drawString("World 4", x + 5, y + 114);
				g.drawString("World 5", x + 5, y + 134);
				g.drawString("Exit", x + 5, y + 154);
				g.setColor(Gui.colorEdge);
				g.drawRect(x, y, 75, 160);
			}
			
			if(PixEng.getInputManager().keyDown(27) && lastkeypress == false)
			{
				Gui.drawOptionMenu = !Gui.drawOptionMenu;
				lastkeypress = true;
			}
			if(!PixEng.getInputManager().keyDown(27))
				lastkeypress = false;
		}
	}