package space.ui.base.event;

import space.ui.base.event.types.KeyEvent;
import space.ui.base.event.types.MouseEvent;

public interface EventListener 
{
	public void KeyPressed(KeyEvent e);
	public void KeyReleased(KeyEvent e);
	public void MousePressed(MouseEvent e);
	public void MouseReleased(MouseEvent e);
	public void MouseDragged(MouseEvent e);
	public void MouseMoved(MouseEvent e);
}
