package pixeng;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class InputManager implements KeyListener, MouseListener, MouseMotionListener
{
	private ArrayList<Integer> keys = new ArrayList<Integer>();
	private ArrayList<Integer> mouse = new ArrayList<Integer>();
	private int mouseX, mouseY, lastX, lastY;
	
	public boolean keyDown(int keycode)
	{
		return keys.contains(keycode);
	}
	
	public boolean mouseDown(int mousecode)
	{
		return mouse.contains(mousecode);
	}
	
	public int mouseX()
	{
		return mouseX;
	}
	
	public int mouseY()
	{
		return mouseY;
	}
	
	public int lastMouseX()
	{
		return lastX;
	}
	
	public int lastMouseY()
	{
		return lastY;
	}

	public void equalizeMouse()
	{
		lastX = mouseX;
		lastY = mouseY;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		lastX = mouseX;
		lastY = mouseY;
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{
		lastX = mouseX;
		lastY = mouseY;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{	
		if(!mouse.contains(e.getButton()))
		{
			mouse.add(e.getButton());
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		mouse.remove((Object) e.getButton());
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(!keys.contains(e.getKeyCode()))
		{
			keys.add(e.getKeyCode());
		}
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys.remove((Object) e.getKeyCode());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
}
