package space.ui;

import java.awt.Graphics2D;

import pixeng.PixEng;
import pixeng.Settings;

public class ChatWindow
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
		
		if(Gui.drawChatWindow)
		{
			if((mx > x + 380 && mx < x + 400) && (my > y + 0 && my < y + 20))
				Gui.drawChatWindow = false;
			
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
		
		if(Gui.drawChatWindow)
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
		if(Gui.drawChatWindow)
		{
			if(drag)
			{
				drag = false;
			}
		}
	}
		
	public void render(Graphics2D g)
	{
		if(Gui.drawChatWindow)
		{
			g.setColor(Gui.colorBack);
			g.fillRect(x, y, 400, 200);
			g.setColor(Gui.colorText);
			g.drawString("Chat", x + 5, y + 15);
			g.drawString("X", x + 385, y + 15);
			g.drawString("Send", x + 365, y + 195);
			g.setColor(Gui.colorEdge);
			g.fillRect(x + 4, y + 20, 392, 1);
			
			g.fillRect(x + 4, y + 180, 392, 1);
			g.fillRect(x + 360, y + 183, 1, 15);
			
			g.setColor(Gui.colorEdge);
			g.drawRect(x, y, 400, 200);
		}
		
		if(PixEng.getInputManager().keyDown(Settings.KEY_CHAT) && lastkeypress == false)
		{
			Gui.drawChatWindow = !Gui.drawChatWindow;
			lastkeypress = true;
		}
		if(!PixEng.getInputManager().keyDown(Settings.KEY_CHAT))
			lastkeypress = false;
	}
}